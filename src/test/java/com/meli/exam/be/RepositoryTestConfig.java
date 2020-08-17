//package com.meli.exam.be;
//
//import javax.activation.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class RepositoryTestConfig {
//
////	@Bean
////    @Profile("test")
////    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("org.h2.Driver");
////        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
////        dataSource.setUsername("sa");
////        dataSource.setPassword("sa");
//// 
////        return (DataSource) dataSource;
////    }
//	
//	@Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//            .setType(EmbeddedDatabaseType.H2)
//            .addScript("classpath:schema.sql")
//            .addScript("classpath:test-data.sql")
//            .build();
//    }
//}
