package com.my.aop.aspest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.my.annotation.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author noatn
 * @description
 * @date 2023-08-30
 */
@Component
@Aspect
public class OperateLogAspect2 {

    private final Logger logger = Logger.getLogger(getClass().getSimpleName());
    /**
     * 计算操作消耗时间
     */
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();


    /**
     * 处理请求前执行
     */
    @Before(value = "@annotation(operationLog)")
    public void boBefore(JoinPoint joinPoint, OperationLog operationLog) {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint    切点
     * @param operationLog 注解
     */
    @AfterReturning(pointcut = "@annotation(operationLog)")
    public void doAfterReturning(JoinPoint joinPoint, OperationLog operationLog) {
        handleLog(joinPoint, operationLog, null);
    }

    /**
     * 拦截异常操作，方法异常时执行
     *
     * @param joinPoint    切点
     * @param operationLog 注解
     * @param e            异常
     */
    @AfterThrowing(value = "@annotation(operationLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, OperationLog operationLog, Exception e) {
        handleLog(joinPoint, operationLog, e);
    }

    /**
     * 封装日志
     *
     * @param joinPoint
     * @param operationLog
     * @param ex
     */
    private void handleLog(final JoinPoint joinPoint, OperationLog operationLog, final Exception ex) {
        Object[] args = joinPoint.getArgs();
        Map<String, Object> operateLogMap = new HashMap<>();
        //计算耗时
        long cost = System.currentTimeMillis() - TIME_THREADLOCAL.get();
        // 获取自定义注解的参数
        operateLogMap.put("operateDesc", operationLog.operateDesc());
        operateLogMap.put("requestDuration", cost);
        operateLogMap.put("args", args);
        logger.info(JSONUtil.toJsonStr(operateLogMap));
        logger.info("time:" + cost);

        StringBuilder stringBuilder = new StringBuilder();
        String dir = FileUtil.getTmpDirPath();
        stringBuilder.append(dir);
        int len = dir.length();
        //判断末尾是否包含\
        if (!dir.substring(len - 1, len).equals(File.separator)) {
            stringBuilder.append(File.separator);
        }
        stringBuilder.append("OperationLog").append(File.separator);
        FileUtil.mkParentDirs(stringBuilder.toString());
        stringBuilder.append((cost / 1000) + "秒_" + operationLog.operateDesc() + "_" + UUID.randomUUID().toString().substring(0, 6) + ".txt");
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(operateLogMap), stringBuilder.toString());
    }
}
