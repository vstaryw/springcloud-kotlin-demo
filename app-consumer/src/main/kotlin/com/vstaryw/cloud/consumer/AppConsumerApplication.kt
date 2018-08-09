package com.vstaryw.cloud.consumer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class AppConsumerApplication

fun main(args: Array<String>) {
    SpringApplication.run(AppConsumerApplication::class.java,*args)
}