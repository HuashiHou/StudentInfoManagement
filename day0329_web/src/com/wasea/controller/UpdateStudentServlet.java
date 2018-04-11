package com.wasea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wasea.bean.Student;
import com.wasea.service.StudentService;
import com.wasea.service.StudentServiceImpl;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		StudentService service = new StudentServiceImpl();
		Student student = null;
		for(Student s:service.listAll()) {
			if(s.getId()==id) {
				student = s;
			}
		}
		request.setAttribute("stu", student);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		StudentService service = new StudentServiceImpl();
		service.updateStudent(id, name, sex);
		response.sendRedirect("list.do");
	}

}
