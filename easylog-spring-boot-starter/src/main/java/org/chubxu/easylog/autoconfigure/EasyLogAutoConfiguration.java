package org.chubxu.easylog.autoconfigure;

import org.chubxu.easylog.aop.EasyLogAdvisor;
import org.chubxu.easylog.aop.EasyLogInterceptor;
import org.chubxu.easylog.aop.EasyLogPointcut;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EasyLogProperties.class)
public class EasyLogAutoConfiguration {
    @Bean
    public EasyLogAdvisor easyLogAdvisor() {
        EasyLogAdvisor easyLogAdvisor = new EasyLogAdvisor();
        easyLogAdvisor.setAdvice(new EasyLogInterceptor());
        easyLogAdvisor.setPointcut(new EasyLogPointcut());
        return easyLogAdvisor;
    }
}
