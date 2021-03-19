package springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        return routes
                .route("path_route1", r->r.path("/guoji").uri("https://news.baidu.com/guonei"))
                .route("path_route2", r-> r.path("/guonei").uri("https://news.baidu.com/guonei"))
                .build();
    }
}
