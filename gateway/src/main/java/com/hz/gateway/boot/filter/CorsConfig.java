package com.hz.gateway.boot.filter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author Peng
 */
@Configuration
@Order(0)
public class CorsConfig{
	/**
	 * 使用注解的形式，配置org.springframework.web.filter.CorsFilter，通常springboot项目多数使用这种方式
	 * 
	 * 解决跨域问题springboot所需配置
	 * @return
	 */
    @Bean
    public CorsWebFilter corsFilter() {
    	//添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");// 允许任何方法(post、get等)
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");// 允许任何的头信息
        config.setAllowCredentials(true);//是否发送Cookie信息
       // config.setMaxAge(3600*24L);//配置有效时长

        //添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}