package com.wasea.dao;

import java.util.List;

import com.wasea.bean.Student;

public interface StudentDao {
	public List<Student> listAll();
	public void deleteStudent(int id);
	public void updateStudent(String id,String name,String sex);
	public void addStudent(String id,String name,String sex);
}
