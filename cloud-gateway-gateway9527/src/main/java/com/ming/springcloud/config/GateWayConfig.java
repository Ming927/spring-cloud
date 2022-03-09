package com.ming.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yzm
 * @date: 2021/9/16
 * @Description:
 * @Version: 1.0
 **/
@Configuration
public class GateWayConfig {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("payment",
//                r ->
//                        r.path("/payment/get/**").
//                                uri("http://localhost:8001"));
//        return routes.build();
//    }
//
//    @Bean
//    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("payment2",
//                r ->
//                        r.path("/payment/lb").
//                                uri("http://localhost:8001"));
//        return routes.build();
//    }

}
