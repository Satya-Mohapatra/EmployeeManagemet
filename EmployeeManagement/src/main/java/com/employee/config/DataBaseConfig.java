package com.employee.config;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.employee.entity.Employee;
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DataBaseConfig {
	
	@Value("${database.driver}")
	private String dataBaseDriver;

	@Value("${database.url}")
	private String dataBaseUrl;
	
	@Value("${database.user}")
	private String dataBaseUser;
	
	@Value("${database.password}")
	private String dataBasePassword;
	
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(getDataSource())
		   .addAnnotatedClasses(Employee.class)
		   .buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(dataBaseDriver);
	    dataSource.setUrl(dataBaseUrl);
	    dataSource.setUsername(dataBaseUser);
	    dataSource.setPassword(dataBasePassword);
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
}
