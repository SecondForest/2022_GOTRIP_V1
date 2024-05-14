package com.bitc.gotrip.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);
        return commonsMultipartResolver;
    }

    @Value("${user.resource.location}")
    private String userLoc;
    @Value("${user.resource.path}")
    private String userPath;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//      addResourceHandler() : 스프링프레임워크 내에서 사용할 폴더명
//      addResourceLocations() : 실제 디스크의 파일 폴더 위치
//      리눅스 및 유닉스에서는 file:/폴더명/
//      윈도우에서는 file:///C:/폴더명/
//      registry 에 여러개의 외부폴더를 추가할 수 있음
//        registry.addResourceHandler("/img/**").addResourceLocations("file:///C:/images/").setCachePeriod(20);

        registry.addResourceHandler(userLoc + "**").addResourceLocations("file:" + userPath).setCachePeriod(20);
    }

}
