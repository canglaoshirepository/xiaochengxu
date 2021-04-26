package com.cang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("feignAutoConfiguration")
@ComponentScan("com.cang.starter")
public class AutoConfiguration {
}
