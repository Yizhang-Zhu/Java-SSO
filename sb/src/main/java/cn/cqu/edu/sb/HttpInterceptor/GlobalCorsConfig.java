// package cn.cqu.edu.sa.HttpInterceptor;

// import org.apache.catalina.filters.CorsFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import
// org.springframework.web.servlet.view.AbstractCachingViewResolver.CacheFilter;

// @Configuration
// public class GlobalCorsConfig {
// @Bean
// public CorsFilter CorsFilter() {
// CorsConfiguration config = new CorsConfiguration();
// config.addAllowedOrigin("*");
// config.setAllowCredentials(true);
// config.addAllowedMethod("*");
// config.addAllowedHeader("*");
// config.addExposedHeader("*");

// UrlBasedCorsConfigurationSource configSource = new
// UrlBasedCorsConfigurationSource();
// configSource.registerCorsConfiguration("/**", config);

// return new CorsFilter(configSource);

// }

// }
