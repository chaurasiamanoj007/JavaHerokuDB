package com.java.github.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/****************************************************************************************
 * This Config files picks up the data source detail from application.properties file
 * This establishes the JDBC connection
 ****************************************************************************************/
@Configuration
public class DatabaseConfig {
	
	public static String CURRENT_CLASS		 		= "DatabaseConfig";
	
	/**
	 * The datasource for project is loaded
	 * @return datasource
	 */
	@Bean(name = "postgresDS")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		String CURRENT_METHOD = "dataSource";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		return DataSourceBuilder.create().build();
	}

	/**
	 * This method returns the JDBC Template
	 * @param ds - Postgres Datasource detail
	 * @return - JDBCTemplate
	 */
	@Bean(name = "pgJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("postgresDS") DataSource postgresDataSource) {
		String CURRENT_METHOD = "jdbcTemplate";		
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+" :: Inside method");
		
		return new JdbcTemplate(postgresDataSource);
	}
}