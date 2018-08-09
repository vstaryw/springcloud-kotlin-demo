package com.vstaryw.cloud.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@SpringBootApplication
class AppGatewayApplication

fun main(args: Array<String>) {
    SpringApplication.run(AppGatewayApplication::class.java,*args)
}