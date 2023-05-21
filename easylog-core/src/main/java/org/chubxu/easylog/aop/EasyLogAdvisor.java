package org.chubxu.easylog.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;

public class EasyLogAdvisor extends AbstractPointcutAdvisor {

    private Advice advice;

    private final Pointcut pointcut;

    public EasyLogAdvisor() {
        pointcut = new EasyLogPointcut();
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
