//package com.icon.webflux.userservice.config;
//
//import io.r2dbc.spi.Connection;
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.r2dbc.connection.R2dbcTransactionManager;
//import org.springframework.transaction.ReactiveTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import reactor.core.publisher.Mono;
//
//@Configuration
//@EnableTransactionManagement
//public class R2DBCConfig extends AbstractR2dbcConfiguration {
//
//    @Override
//    @Bean("customR2ConnectionFactory")
//    @Primary
//    public ConnectionFactory connectionFactory() {
//        return ConnectionFactories.get("r2dbc:mysql://root:jiyounglee@127.0.0.1:3306/userdb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul");
//    }
//
//    @Bean
//    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
//        return new R2dbcTransactionManager(connectionFactory);
//    }
//
////    ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:mysql://root:jiyounglee@127.0.0.1:3306/userdb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul");
//
////    Mono<Connection> connectionMono = Mono.from(connectionFactory.create());
//}
