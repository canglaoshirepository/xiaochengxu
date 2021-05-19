package com.cang.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration("feignAutoConfiguration1")
@AutoConfigureOrder(1)
//@ComponentScan("com.cang.starter")
@EnableFeignClients("com.cang.starter")
@EnableSwagger2
public class AutoConfiguration {
}
