package com.vstaryw.cloud.consumer.service.impl

import com.alibaba.fastjson.JSONObject
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.vstaryw.cloud.consumer.client.DcClient
import com.vstaryw.cloud.consumer.service.IndexService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class IndexServiceImpl(
        private val dcClient: DcClient
):IndexService{
    private val logger:Logger = LoggerFactory.getLogger(IndexServiceImpl::class.java)

    @HystrixCommand(fallbackMethod = "fallback")
    override fun consumer(): Map<String, Any> {
        val consumer = dcClient.consumer()
        val result = JSONObject.parseObject(consumer, Map::class.java)
        return result as Map<String, Any>
    }

    fun fallback(throwable: Throwable):Map<String,Any>{
        logger.error("fallback is error",throwable)
        val mapOf = mapOf(Pair("services", "fallback is error"))
        return mapOf
    }
}