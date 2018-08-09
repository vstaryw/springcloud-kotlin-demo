package com.vstaryw.cloud.consumer.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient("eureka-client")
interface DcClient {

    @GetMapping("/dc")
    fun consumer():String
}