package com.wasea.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils {
	static Connection conn = null;

	public static Connection getInstance() {
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "dbadmin", "123");
				System.out.println("�½���һ�����ݿ����ӣ�����������������");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
