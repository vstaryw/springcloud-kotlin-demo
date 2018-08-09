package com.vstaryw.cloud.consumer.common

data class ResultInfo(
        val code : String = "0",
        val msg : String = "success",
        val data : Any? = null
)