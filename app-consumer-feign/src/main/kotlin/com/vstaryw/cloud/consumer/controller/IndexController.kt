package com.vstaryw.cloud.consumer.controller

import com.vstaryw.cloud.consumer.common.ResultInfo
import com.vstaryw.cloud.consumer.service.IndexService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController(
        private val indexService: IndexService
) {
    @GetMapping("index")
    fun index():ResultInfo{
        val result = indexService.consumer()
        return  ResultInfo(data = result)
    }
}
