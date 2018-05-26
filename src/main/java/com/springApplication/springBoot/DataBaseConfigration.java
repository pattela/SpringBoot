package com.springApplication.springBoot;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@Component
public class DataBaseConfigration {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	Environment  env;
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(env.getProperty("enity.scan"));
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(getHibernateProperties());
		return factoryBean;
	}
	
	
	private Properties getHibernateProperties() {

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
       // hibernateProperties.put("hibernate.generate_statistics", env.getProperty(""));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        //hibernateProperties.put("hibernate.use_sql_comments", env.getProperty(""));
        return hibernateProperties;
    }
	
	 @Bean
     @Autowired
     public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
     }

}
