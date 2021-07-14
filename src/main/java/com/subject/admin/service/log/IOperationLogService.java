package com.subject.admin.service.log;

import com.subject.admin.dto.log.OperationLog;

public interface IOperationLogService {
    /**
     * 插入日志
     * @param operationLog 插入日志
     */
    public void insert(OperationLog operationLog);
}
