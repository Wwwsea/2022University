package com.city.oa.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//数据库连接工厂,使用HikariCP连接池框架
public class ConnectionFactory {
	private static HikariDataSource hds=null;
	static {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/wy?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
		config.setUsername("root");
		config.setPassword("root");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.setMaximumPoolSize(2);
		config.setMinimumIdle(1);
		hds = new HikariDataSource(config);
	}
		//直接从HirakiCP连接池取得连接
	public static Connection getConenctionFromHarikeCP() throws Exception{
		return hds.getConnection();
	}

}
