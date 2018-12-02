package com.bdqn.springboot_web.config;

import com.bdqn.springboot_web.compoent.LoginHandlerInterceptor;
import com.bdqn.springboot_web.compoent.MyLocaleResolver;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 贺威
 * @create 2018-11-28 18:14
 *  使用WebMvcConfigurerAdapter  可以扩展springMvc功能
 */
@Configuration
public class MyMvconfig extends WebMvcConfigurerAdapter{




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/bqan").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter  webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            /**
             * 注册拦截器
             * @param registry
             */
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                // 拦截哪些请求addPathPatterns
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                        //哪些请求不拦截
//                        excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
//            }
        };
        return  adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }


}
