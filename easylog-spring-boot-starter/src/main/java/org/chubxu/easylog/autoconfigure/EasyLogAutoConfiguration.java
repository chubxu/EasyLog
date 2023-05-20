package org.chubxu.easylog.autoconfigure;

import org.chubxu.easylog.aop.EasyLogAdvisor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EasyLogProperties.class)
public class EasyLogAutoConfiguration {
    @Bean
    public EasyLogAdvisor easyLogAdvisor() {
        return new EasyLogAdvisor();
    }
}
