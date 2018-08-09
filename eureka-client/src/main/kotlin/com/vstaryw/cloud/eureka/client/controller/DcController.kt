package com.vstaryw.cloud.eureka.client.controller

import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DcController(
        private val discoveryClient: DiscoveryClient
){


    @GetMapping("/dc")
    fun dc(): Map<String,Any> {
        val services = "Services is ,${discoveryClient.services}"
        println(services)
        return mapOf<String,Any>("services" to services)
    }
}