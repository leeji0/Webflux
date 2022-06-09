//package com.icon.webflux.userservice.config;
//
//
//import io.r2dbc.h2.H2ConnectionConfiguration;
//import io.r2dbc.h2.H2ConnectionFactory;
//import io.r2dbc.h2.H2ConnectionOption;
//import io.r2dbc.spi.ConnectionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
//import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
//import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//
//@Profile("h2")
//@EnableR2dbcRepositories
//@Configuration
//public class H2R2dbcConfig extends AbstractR2dbcConfiguration {
//
//    @Override
//    public ConnectionFactory connectionFactory() {
//        return new H2ConnectionFactory(H2ConnectionConfiguration.builder()
//            .inMemory("userdb") // 데이터베이스 이름
//            .property(H2ConnectionOption.DB_CLOSE_DELAY, "-1") // DB연결이 닫혀도 유지되도록 설정
//            .username("sa")
//            .build());
//    }
//
//    @Bean
//    public ConnectionFactoryInitializer h2DbInitializer() {
//        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
//        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//        resourceDatabasePopulator.addScript(new ClassPathResource("init.sql"));
////        resourceDatabasePopulator.addScript(new ClassPathResource("schema-boards-h2.sql"));
//
//        initializer.setConnectionFactory(connectionFactory());
//        initializer.setDatabasePopulator(resourceDatabasePopulator);
//        return initializer;
//    }
//}