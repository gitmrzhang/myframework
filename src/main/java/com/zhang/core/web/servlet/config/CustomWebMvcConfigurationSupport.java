package com.zhang.core.web.servlet.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.zhang.core.web.servlet.mvc.annotation.CustomRequestMappingHandlerMapping;

@EnableWebMvc
@Configurable
public class CustomWebMvcConfigurationSupport extends DelegatingWebMvcConfiguration{
	
	private final Log logger  = LogFactory.getLog(CustomWebMvcConfigurationSupport.class);

	@Override
	protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
		if(logger.isInfoEnabled()){
			logger.info("CustomWebMvcConfigurationSupport set CustomRequestMappingHandlerMapping for RequestMappingHandlerMapping");
		}
		return new CustomRequestMappingHandlerMapping();
	}


}