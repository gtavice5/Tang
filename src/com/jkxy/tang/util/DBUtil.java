package com.jkxy.tang.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String DRIVER;
	private static String DBURL;
	private static String USER;
	private static String PASSWORD;
	private static Connection connection=null;
	/**
	 * 加载配置文件
	 */
	static{
		InputStream inputStream=DBUtil.class.getClassLoader().getResourceAsStream("DBUtil.properties");
		Properties properties=new Properties();
		
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER=properties.getProperty("DRIVER");
		DBURL=properties.getProperty("DBURL");
		USER=properties.getProperty("USER");
		PASSWORD=properties.getProperty("PASSWORD");
	}
	/**
	 * 获取链接
	 */
	public static Connection makeConnection(){
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(DBURL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	
	
	public static void closeConnection(PreparedStatement ps,Connection conn) {
		try {
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
