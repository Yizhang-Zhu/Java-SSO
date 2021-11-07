package cn.cqu.edu.sa.HttpInterceptor;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfigurer implements WebMvcConfigurer {
    @Resource
    private Interceptor interceptor;

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/**").allowCredentials(true).allowedOriginPatterns("*")
    // .allowedMethods("GET", "POST", "DELETE", "PUT",
    // "PATCH").allowedHeaders("*").allowCredentials(true)
    // .maxAge(3600);
    // }

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置拦截请求
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/toPage/login");
    }
}
