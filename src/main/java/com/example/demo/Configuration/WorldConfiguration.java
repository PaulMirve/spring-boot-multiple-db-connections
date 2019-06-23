package com.example.demo.Configuration;

import com.example.demo.World.Entities.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "worldDSEmFactory",
        transactionManagerRef = "worldDSTransactionManager",
        basePackages = "com.example.demo.World.Repositories"
)
public class WorldConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource2")
    public DataSourceProperties worldDSProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource worldDS(@Qualifier("worldDSProperties") DataSourceProperties worldDSProperties){
        return worldDSProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean worldDSEmFactory(
            @Qualifier("worldDS") DataSource worldDS,
            EntityManagerFactoryBuilder builder
            ){
        return builder.dataSource(worldDS).packages(Country.class).build();
    }

    @Bean
    public PlatformTransactionManager worldDSTransactionManager(@Qualifier("worldDSEmFactory")EntityManagerFactory worldDSEmFactory){
        return new JpaTransactionManager(worldDSEmFactory);
    }
}
