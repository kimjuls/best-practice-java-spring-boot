package com.kimjuls.best_practice_java_spring_boot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kimjuls.best_practice_java_spring_boot.filter.AccessLogFilter;
import com.kimjuls.best_practice_java_spring_boot.service.KafkaProducerService;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<AccessLogFilter> accessLogFilter(KafkaProducerService kafkaProducerService) {
        FilterRegistrationBean<AccessLogFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new AccessLogFilter(kafkaProducerService));
        bean.addUrlPatterns("/*");
        return bean;
    }
}
