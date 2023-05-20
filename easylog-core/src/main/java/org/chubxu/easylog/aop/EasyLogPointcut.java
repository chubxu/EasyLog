package org.chubxu.easylog.aop;

import org.chubxu.easylog.annotation.ELog;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;

public class EasyLogPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        Annotation[] annotations = method.getAnnotations();
        if (Objects.nonNull(annotations) && annotations.length > 0) {
            for (Annotation annotation : annotations) {
                if (ELog.class.getName().equalsIgnoreCase(annotations.getClass().getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
