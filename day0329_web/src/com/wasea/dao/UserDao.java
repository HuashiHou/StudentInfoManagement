package com.wasea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.wasea.utils.DBUtils;

public class UserDao {
	public static boolean isCorrect(String usr,String pwd) {
		try {
			Connection conn = DBUtils.getInstance();
			String sql = "select u_pwd from usrInfo where u_name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usr);
			ResultSet rs = ps.executeQuery();
			
			String mpwd =null;
			while(rs.next()) {
				mpwd = rs.getString(1);
			}
			
			if(pwd.equals(mpwd)) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		
	}
}
