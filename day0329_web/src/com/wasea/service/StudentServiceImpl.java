package com.wasea.service;

import java.util.List;

import com.wasea.bean.Student;
import com.wasea.dao.StudentDao;
import com.wasea.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> listAll() {
		StudentDao dao = new StudentDaoImpl();
		return dao.listAll();
	}

	@Override
	public void deleteStudent(int i) {
		StudentDao dao = new StudentDaoImpl();
		dao.deleteStudent(i);
	}

	@Override
	public void updateStudent(String id, String name, String sex) {
		StudentDao dao = new StudentDaoImpl();
		dao.updateStudent(id,name,sex);
		
	}

	@Override
	public void addStudent(String id, String name, String sex) {
		StudentDao dao = new StudentDaoImpl();
		dao.addStudent(id, name, sex);
	}

}
