package com.wasea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.wasea.bean.Student;
import com.wasea.utils.DBUtils;

public class StudentDaoImpl implements StudentDao{
	Connection conn = null;
	
	@Override
	public List<Student> listAll() {
		List<Student> list =null;
		try {
			list = new ArrayList<Student>();
			conn = DBUtils.getInstance();
			String sql = "select s_id,s_name,s_sex from student order by s_id";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setSex(rs.getString(3).toCharArray()[0]);
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Override
	public void deleteStudent(int id) {
		try {
			conn = DBUtils.getInstance();
			String sql = "delete from student where s_id="+id;
			PreparedStatement st = conn.prepareStatement(sql);
			st.executeUpdate();
			System.out.println(id+"��ͬѧɾ���ɹ�~");
		} catch (Exception e) {
			System.out.println("ɾ��ʧ�ܣ�" );
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
//		List<Student> s = listAll();
//		System.out.println(s);
		
//		deleteStudent(6);
		updateStudent("16", "����", "Ů");
	}


	@Override
	public void updateStudent(String id, String name, String sex) {
		int s_id = Integer.valueOf(id);
		char s_sex = sex.toCharArray()[0];
		
		try {
			conn = DBUtils.getInstance();
			String sql = "update student set s_name=?,s_sex=? where s_id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, sex);
			statement.setInt(3, s_id);
			statement.executeUpdate();
			System.out.println(id+"�ŵ�ͬѧ��Ϣ���³ɹ�~");
		} catch (Exception e) {
			System.err.println("����ʧ��~");
			e.printStackTrace();
		}
		
	}


	@Override
	public void addStudent(String id, String name, String sex) {
		int s_id = Integer.valueOf(id);
		char s_sex = sex.toCharArray()[0];
		System.out.println(id+name+sex);
		
		try {
			conn = DBUtils.getInstance();
			String sql = "insert into student values(?,?,?,null,null)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, s_id);
			statement.setString(2, name);
			statement.setString(3, sex);
			statement.executeUpdate();
			System.out.println(id+"�ŵ�ͬѧ��Ϣ��ӳɹ�~");
		} catch (Exception e) {
			System.err.println("���ʧ��~");
			e.printStackTrace();
		}
	}

	
}
