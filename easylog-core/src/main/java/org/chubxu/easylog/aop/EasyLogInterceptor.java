package org.chubxu.easylog.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyLogInterceptor implements MethodInterceptor {

    private final Logger log = LoggerFactory.getLogger(EasyLogInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("start invoke");
        Object proceed = invocation.proceed();
        log.info("end invoke");
        return proceed;
    }
}
