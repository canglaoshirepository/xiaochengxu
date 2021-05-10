package com.cang.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("exceptionConfiguration")
@ComponentScan("com.cang.handler")
@AutoConfigureOrder(10)
public class AutoConfiguration {
}
