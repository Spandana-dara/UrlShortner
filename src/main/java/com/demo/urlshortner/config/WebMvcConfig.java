package com.demo.urlshortner.config;

import com.demo.urlshortner.interceptor.RateLimitingInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for Url Shortner.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Autowired
  private RateLimitingInterceptor rateLimitingInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(rateLimitingInterceptor);
  }
}

