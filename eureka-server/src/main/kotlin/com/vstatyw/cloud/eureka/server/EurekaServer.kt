package com.vstatyw.cloud.eureka.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaServer

fun main(args: Array<String>) {
    SpringApplication.run(EurekaServer::class.java,*args)
}