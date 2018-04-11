package com.wasea.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wasea.service.StudentService;
import com.wasea.service.StudentServiceImpl;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		StudentService service = new StudentServiceImpl();
		service.addStudent(id, name, sex);
		response.sendRedirect("list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
