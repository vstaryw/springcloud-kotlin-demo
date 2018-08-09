package com.vstaryw.cloud.eureka.client

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class EurekaClientApplication

fun main(args: Array<String>) {
    SpringApplication.run(EurekaClientApplication::class.java,*args)
}