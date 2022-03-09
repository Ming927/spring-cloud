package com.ming.springcloud.filter;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author yzm
 * @date: 2021/9/17
 * @Description:
 * @Version: 1.0
 **/
@Component
@Log4j2
public class GateWayGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("开始进入全局日志：" + new Date());
        log.info("exchange ----> " + exchange);
        log.info("chain ----> " + chain);
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (name == null) {
            log.info("******非法用户名,验证不通过！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0; // 越小优先级越高
    }
}
