package org.chubxu.easylog.autoconfigure;

import org.chubxu.easylog.aop.EasyLogAdvisor;
import org.chubxu.easylog.aop.EasyLogInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EasyLogProperties.class)
public class EasyLogAutoConfiguration {
    @Bean
    public EasyLogAdvisor easyLogAdvisor(EasyLogInterceptor easyLogInterceptor) {
        EasyLogAdvisor easyLogAdvisor = new EasyLogAdvisor();
        easyLogAdvisor.setAdvice(easyLogInterceptor);
        return easyLogAdvisor;
    }

    @Bean
    public EasyLogInterceptor easyLogInterceptor() {
        return new EasyLogInterceptor();
    }
}
