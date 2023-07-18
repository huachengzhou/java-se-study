package com.my.aop.service;

import com.my.annotation.OperationLog;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OperateLogBean {
    private final Logger logger = Logger.getLogger(getClass().getSimpleName());

    /**
     * 删除数据
     * @param uuid
     * @throws Exception
     */
    @OperationLog(moduleName = "数据删除",operateType = "delete")
    public void delData(String uuid)throws Exception{
        logger.info(" delete before uuid:"+uuid);
        Thread.sleep(2000);
        logger.info(" delete finish uuid:"+uuid);
    }

}
