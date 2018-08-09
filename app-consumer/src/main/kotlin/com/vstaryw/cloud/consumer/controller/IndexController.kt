package com.vstaryw.cloud.consumer.controller

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class IndexController(
        private val restTemplate: RestTemplate,
        private val loadBalancerClient: LoadBalancerClient
) {
    @GetMapping("index")
    fun index():String{
        val serviceBalance = loadBalancerClient.choose("eureka-client")
        val url = "http://${serviceBalance.host}:${serviceBalance.port}/dc"
        return restTemplate.getForObject(url,String::class.java)
    }
}
