package com.hibernate_prova;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateProvaApplication {


	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/palestra1");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("root");
		return dataSourceBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernateProvaApplication.class, args);
	}

}
