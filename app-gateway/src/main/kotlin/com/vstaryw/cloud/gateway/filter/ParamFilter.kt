package com.vstaryw.cloud.gateway.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ParamFilter:ZuulFilter() {
    private val logger: Logger = LoggerFactory.getLogger(ParamFilter::class.java)
    override fun run(): Any {
        logger.info("拦截请求了。。。")
        return "ok"
    }

    override fun shouldFilter(): Boolean {
        val currentContext = RequestContext.getCurrentContext()
        val request = currentContext.request
        val servletPath = request.servletPath
        logger.info("request servletPath path is $servletPath")
        return when{
            servletPath.startsWith("/app-consumer-feign")-> true
            else ->  false
        }
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 1
    }
}