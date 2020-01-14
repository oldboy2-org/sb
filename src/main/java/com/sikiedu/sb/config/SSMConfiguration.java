package com.sikiedu.sb.config;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
//mapper的扫描路径
@MapperScan("com.sikiedu.sb.dao")
public class SSMConfiguration {
	
	@Autowired
	private DataSource dataSource;
	
	//dataSource
	@Bean(name="dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		//driver
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		//url
		dataSource.setJdbcUrl("jdbc:mysql://::1:3306/ssm?serverTimezone=UTC&characterEncoding=utf-8&useSSL=true");
		//username
		dataSource.setUser("root");
		//password
		dataSource.setPassword("root");
		//在关闭连接之后不会自动的Commit
		dataSource.setAutoCommitOnClose(false);
		return dataSource;
	}
	
	//sessionFactory
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		
		//加载主配置文件mybatis-config.xml
		bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		//Mapper扫描路径
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = "classpath*:/mapper/**.xml";
		bean.setMapperLocations(resolver.getResources(packageSearchPath));
		//配置实体的包
		bean.setTypeAliasesPackage("com.sikiedu.sb.entity");
		//dataSource
		bean.setDataSource(dataSource);
		return bean;		
	}
	
	

}
