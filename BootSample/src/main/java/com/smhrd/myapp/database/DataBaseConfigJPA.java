package com.smhrd.myapp.database;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//configuration annotation
@EnableJpaRepositories(
       basePackages="com.smhrd.myapp.repo",  //repository를 관리할 패키지 명시
       entityManagerFactoryRef = "entityManagerFactory", //EntityManagerFactory
       transactionManagerRef = "transactionManager") // transactionManager
public class DataBaseConfigJPA {
   private static final String DEFAULT_NAMING_STRATEGY
      = "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy";
   
   @Bean
   @Primary //해당 Bean을 우선적으로 선택하도록 하는 annotation
   public DataSource defaultDataSource() {
      HikariConfig dataSourceConfig = new HikariConfig();
      dataSourceConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
       dataSourceConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
       dataSourceConfig.setUsername("hr");
       dataSourceConfig.setPassword("hr");
       dataSourceConfig.setMaximumPoolSize(10);
       dataSourceConfig.setMinimumIdle(5);
       dataSourceConfig.setMaxLifetime(1200000);
       dataSourceConfig.setConnectionTimeout(20000   );
       dataSourceConfig.setIdleTimeout(300000);
       
       return new HikariDataSource(dataSourceConfig);
   }
   
   //SessionFactory를 생성
   @Bean(name = "entityManagerFactory")
   @Primary
   public LocalContainerEntityManagerFactoryBean entityManagerFactory(
       EntityManagerFactoryBuilder builder) {
   
     Map<String, String> propertiesHashMap = new HashMap<>();
     propertiesHashMap.put("hibernate.physical_naming_strategy",DEFAULT_NAMING_STRATEGY);

     LocalContainerEntityManagerFactoryBean rep =
     builder.dataSource(defaultDataSource())
       .packages("com.smhrd.myapp.domain")
      //domain을 관리할 패키지 경로 명시 (domain = DO 파일)
       .properties(propertiesHashMap)
       .build();
    
     return rep;
   }
   
   
   //트랜잭션 관리
   @Primary
   @Bean(name = "transactionManager")
   PlatformTransactionManager transactionManager(
       EntityManagerFactoryBuilder builder) {
     return new JpaTransactionManager(entityManagerFactory(builder).getObject());
   }

}