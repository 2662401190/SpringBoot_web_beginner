package com.bdqn.springboot_web.config;

import com.atguigu.springboot.servlet.MyServlet;
import com.bdqn.springboot_web.filter.MtFilter;
import com.bdqn.springboot_web.listener.Mylistener;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.EventListener;

/**
 * @author 贺威
 * @create 2018-12-01 17:58
 */
@Configuration
public class MyServerConfig {


    //注册三个组件

    /**
     * 注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MtFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<EventListener> eventListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new Mylistener());
        return eventListenerServletListenerRegistrationBean;
    }


    /**
     * 修改默认配置
     * 修改tomcat 端口号
     * 也可以去application.properties文件修改
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer embeddedServlerContainerCustomizer() {
        return new WebServerFactoryCustomizer() {
            //定制嵌入式Servlet容器相关规则
            @Override
            public void customize(WebServerFactory factory) {
                ((TomcatServletWebServerFactory)factory).addConnectorCustomizers(new TomcatConnectorCustomizer() {
                    @Override
                    public void customize(Connector connector) {
                        connector.setPort(8088);
                    }
                });
            }
        };
    }
}
