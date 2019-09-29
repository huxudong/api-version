package com.hxd.apiversion.config.version.web;

import com.hxd.apiversion.config.version.ApiVersioningRequestMappingHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Author: huxudong
 * @Date: 2019/9/27 2:28 下午
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new ApiVersioningRequestMappingHandlerMapping();
    }
}
