package com.vstaryw.cloud.consumer.config

import com.alibaba.fastjson.serializer.SerializerFeature
import com.alibaba.fastjson.support.config.FastJsonConfig
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
import org.springframework.boot.autoconfigure.web.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun httpMessageConverters(): HttpMessageConverters {
        val fastJsonHttpMessageConverter = FastJsonHttpMessageConverter()
        val fastJsonConfig = FastJsonConfig()
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat)
        fastJsonHttpMessageConverter.fastJsonConfig = fastJsonConfig
        return HttpMessageConverters(fastJsonHttpMessageConverter)
    }
}