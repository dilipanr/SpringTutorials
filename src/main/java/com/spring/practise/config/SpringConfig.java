package com.spring.practise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.spring.practise"})
public class SpringConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/jsp/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	DriverManagerDataSource getDataSource() {
		String url = "jdbc:mysql://127.0.0.1:3306/dilipanr";
		String userName = "root";
		String password = "password";
		DriverManagerDataSource datasource = new DriverManagerDataSource(url, userName, password);
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		return datasource;
	}
	
	@Bean
	NamedParameterJdbcTemplate getNPJDBCTmpl() {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		return namedParameterJdbcTemplate;
	}
	
}
