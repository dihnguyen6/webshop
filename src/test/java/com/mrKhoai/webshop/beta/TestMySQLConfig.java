package com.mrKhoai.webshop.beta;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.mrKhoai.webshop")
@EnableWebMvc
/*@EntityScan(basePackages = "com.mrKhoai.webshop.objects")
@EnableJpaRepositories(basePackages = "com.mrKhoai.webshop.repositories")
@EnableTransactionManagement*/
public class TestMySQLConfig {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://85.10.205.173:3306/mrkhoai_test_db?useSSL=false");
        dataSource.setUsername("mrkhoai_tester");
        dataSource.setPassword("mrkhoaitest");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
