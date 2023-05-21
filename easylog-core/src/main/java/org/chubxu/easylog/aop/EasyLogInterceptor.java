package org.chubxu.easylog.aop;

import com.alibaba.fastjson2.JSON;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;

public class EasyLogInterceptor implements MethodInterceptor, Serializable {

    private final Logger log = LoggerFactory.getLogger(EasyLogInterceptor.class);

    public EasyLogInterceptor() {
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (Objects.nonNull(invocation)) {
            String methodName = invocation.getMethod().getName();
            Object[] arguments = invocation.getArguments();
            log.info("method name: {}, arguments: {}", methodName, JSON.toJSONString(arguments));
            long start = System.currentTimeMillis();
            Object proceed = invocation.proceed();
            long end = System.currentTimeMillis();
            log.info("return value: {}, cost {} ms", JSON.toJSONString(proceed), end - start);
            return proceed;
        }
        return null;
    }
}
