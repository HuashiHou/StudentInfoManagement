package com.wasea.service;

import java.util.List;

import com.wasea.bean.Student;

public interface StudentService {
	public List<Student> listAll();
	public void deleteStudent(int i);
	public void updateStudent(String id,String name,String sex);
	public void addStudent(String id,String name,String sex);
	

}
