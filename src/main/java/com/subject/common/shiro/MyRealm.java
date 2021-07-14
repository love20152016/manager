package com.subject.common.shiro;

import com.subject.admin.dto.user.PermitDTO;
import com.subject.admin.dto.user.RoleDTO;
import com.subject.admin.dto.user.UserInfoDTO;
import com.subject.admin.service.user.UserInfoPermitService;
import com.subject.admin.service.user.UserInfoRoleService;
import com.subject.admin.service.user.UserInfoService;
import com.subject.common.base.Constant;
import com.subject.common.service.SpringContextBeanService;
import com.subject.common.util.ComUtil;
import com.subject.common.util.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liugh
 * @since 2018-05-03
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoRoleService userInfoRoleService;
    @Autowired
    private UserInfoPermitService userInfoPermitService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (userInfoRoleService == null) {
            this.userInfoRoleService = SpringContextBeanService.getBean(UserInfoRoleService.class);
        }
        if (userInfoPermitService == null) {
            this.userInfoPermitService = SpringContextBeanService.getBean(UserInfoPermitService.class);
        }
        if (null == userInfoService){
            this.userInfoService = SpringContextBeanService.getBean(UserInfoService.class);
        }
        //获取账号
        String account = JWTUtil.getUserNo(principals.toString());
        UserInfoDTO user = userInfoService.querUserInfo(account);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if(null != user){
            List<RoleDTO> userRoles = userInfoRoleService.queryUserRole(user.getId());

        /*
        Role role = roleService.selectOne(new EntityWrapper<Role>().eq("role_code", userToRole.getRoleCode()));
        //添加控制角色级别的权限
        Set<String> roleNameSet = new HashSet<>();
        roleNameSet.add(role.getRoleName());
        simpleAuthorizationInfo.addRoles(roleNameSet);
        */
            //控制菜单级别按钮  类中用@RequiresPermissions("user:list") 对应数据库中code字段来控制controller
            ArrayList<String> pers = new ArrayList<String>();
            List<PermitDTO> menuList = userInfoPermitService.queryUserPermitsByUserId(user.getId());
            for (PermitDTO per : menuList) {
                if (!ComUtil.isEmpty(per.getCode())) {
                    pers.add(String.valueOf(per.getCode()));
                }
            }
            Set<String> permission = new HashSet<String>(pers);
            simpleAuthorizationInfo.addStringPermissions(permission);
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        if (userInfoService == null) {
            this.userInfoService = SpringContextBeanService.getBean(UserInfoService.class);
        }
        String token = (String) auth.getCredentials();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(Constant.METHOD_URL_SET.contains(request.getRequestURI())){
            request.setAttribute("currentUser",new UserInfoDTO());
            return new SimpleAuthenticationInfo(token, token, this.getName());
        }
        // 解密获得username，用于和数据库进行对比
        String account = JWTUtil.getUserNo(token);
        if (StringUtils.isEmpty(account)) {
            throw new AuthenticationException("token invalid");
        }
        UserInfoDTO userBean = userInfoService.querUserInfo(account);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }
        if (! JWTUtil.verify(token, account, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }
        return new SimpleAuthenticationInfo(token, token, this.getName());
    }
}
