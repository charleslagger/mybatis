package com.tsdv.application;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@MapperScan(basePackages = "com.tsdv.student.mapper")
public class MybatisConfig {

	@Value("${spring.datasource.url}")
	private String jdbcURl;

	@Value("${spring.datasource.username}")
	private String dbUsername;

	@Value("${spring.datasource.password}")
	private String dbPassword;

	@Value("${spring.datasource.driverClassName}")
	private String dbDriverClass;

	@Bean
	public DataSource dataSource() {
		OracleDataSource ods = null;
		try {
			ods = new OracleDataSource();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		ods.setURL(jdbcURl);
		ods.setUser(dbUsername);
		ods.setPassword(dbPassword);
		ods.setDriverType(dbDriverClass);

		return ods;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory.getObject();
	}
}
