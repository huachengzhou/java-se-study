package com.my.aop.aspest;


import cn.hutool.json.JSONUtil;
import com.my.annotation.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
@Aspect
public class OperateLogAspect {


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
     * @param e
     */
    private void handleLog(final JoinPoint joinPoint, OperationLog operationLog, final Exception e) {
        Map<String, Object> operLogMap = new HashMap<>();
        //计算耗时
        long cost = System.currentTimeMillis() - TIME_THREADLOCAL.get();
        // 获取自定义注解的参数
        operLogMap.put("moduleName", operationLog.moduleName());
        operLogMap.put("requestDuration", cost);
        logger.info(JSONUtil.toJsonStr(operLogMap));
        logger.info("time:" + cost);
    }

}
