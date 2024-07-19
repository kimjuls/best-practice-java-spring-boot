package com.kimjuls.best_practice_java_spring_boot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kimjuls.best_practice_java_spring_boot.filter.AccessLogFilter;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<AccessLogFilter> accessLogFilter() {
        FilterRegistrationBean<AccessLogFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new AccessLogFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}
