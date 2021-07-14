package com.subject.admin.impl.user;

import com.subject.admin.dao.permit.UserInfoPermitMapper;
import com.subject.admin.dto.user.PermitDTO;
import com.subject.admin.dto.user.RoleDTO;
import com.subject.admin.dto.user.UserInfoDTO;
import com.subject.admin.dto.vo.user.UserInfoRoleMenuVO;
import com.subject.admin.service.user.UserInfoPermitService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName: UserInfoPermitServiceImpl
 * @Description:
 * @Author: liaijun
 * @Date: 2021/7/8 10:27
 */
@Component("userInfoPermitService")
public class UserInfoPermitServiceImpl implements UserInfoPermitService {

    private static final String USER_INFO_KEY = "userInfo";
    private static final String USER_RULE_KEY = "role";
    private static final String USER_PERMIT_KEY = "permits";

    @Autowired
    UserInfoPermitMapper userInfoPermitMapper;

    @Override
    public Map<String,Object> queryUserPermits(String id) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        List<UserInfoRoleMenuVO> menus = userInfoPermitMapper.queryUserPermits(id);
        //为空则返回空对象
        if (null == menus || CollectionUtils.isEmpty(menus) && menus.size() > 0){
            return new HashMap<String,Object>();
        }
        UserInfoRoleMenuVO menu = menus.get(0);
        //获取客户数据
        UserInfoDTO userInfoDTO = new UserInfoDTO(menu.getUserId(),menu.getAccount(),menu.getUserName(),menu.getSalt(),menu.getEmail(),menu.getMobile(),menu.getStatus());
        Set<RoleDTO> roles = new HashSet<RoleDTO>();
        Set<PermitDTO> permits = new HashSet<PermitDTO>();
        for(UserInfoRoleMenuVO vo : menus){
          if (null == vo){
              continue;
          }
          //获取角色
          RoleDTO roleDTO = new RoleDTO(vo.getRoleId(),vo.getRoleName());
          roles.add(roleDTO);
            if (StringUtils.isEmpty(vo.getPermitId())) {
                continue;
            }
          PermitDTO permitDTO = new PermitDTO(vo.getPermitId(),vo.getParentId(),vo.getName(),vo.getUrl(),vo.getType(),vo.getOrderNumber(),vo.getPerms());
          permits.add(permitDTO);
        }
        resultMap.put(USER_INFO_KEY,userInfoDTO);
        resultMap.put(USER_RULE_KEY,roles);
        resultMap.put(USER_PERMIT_KEY,permits);
        return resultMap;
    }

    @Override
    public List<PermitDTO> queryUserPermitsByUserId(String userId) {
        List<PermitDTO> list = userInfoPermitMapper.queryUserPermitsByUserId(userId);
        return list;
    }
}
