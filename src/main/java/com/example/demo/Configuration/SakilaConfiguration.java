package com.example.demo.Configuration;

import com.example.demo.Sakila.Entities.Actor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sakilaDSEmFactory",
        transactionManagerRef = "sakilaDSTransactionManager",
        basePackages = "com.example.demo.Sakila.Repositories"
)
public class SakilaConfiguration {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties sakilaDSProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource sakilaDS(@Qualifier("sakilaDSProperties") DataSourceProperties sakilaDSProperties){
        return sakilaDSProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean sakilaDSEmFactory(@Qualifier("sakilaDS") DataSource sakilaDS, EntityManagerFactoryBuilder builder){
        return builder.dataSource ( sakilaDS ).packages (Actor.class).build ();
    }

    @Primary
    @Bean
    public PlatformTransactionManager sakilaDSTransactionManager(@Qualifier("sakilaDSEmFactory") EntityManagerFactory sakilaDSEmFactory){
        return new JpaTransactionManager ( sakilaDSEmFactory );
    }
}
