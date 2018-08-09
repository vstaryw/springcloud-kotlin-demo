package com.vstaryw.cloud.gateway.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ApiFilter:ZuulFilter() {
    private val logger:Logger = LoggerFactory.getLogger(ApiFilter::class.java)
    override fun run(): Any? {
        val currentContext = RequestContext.getCurrentContext()
        val request = currentContext.request
        val accessToken = request.getParameter("token")
        if(accessToken == null){
            logger.warn("token is empty")
            currentContext.setSendZuulResponse(false)
            currentContext.responseStatusCode=401
            return null
        }
        logger.info("token is ok")
        return null
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 0
    }
}