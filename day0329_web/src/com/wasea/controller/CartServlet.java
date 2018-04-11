package com.wasea.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wasea.bean.Student;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Student> clist = (List<Student>) session.getAttribute("cartList");
		Map<Integer, Student> sMap = (Map<Integer, Student>) getServletContext().getAttribute("sMap");

		String s_id = request.getParameter("id");
		int id = Integer.valueOf(s_id);

		String op = request.getParameter("op");

		if ("del".equals(op)) {
			for (int i = 0; i < clist.size(); i++) {
				if (clist.get(i).getId() == id) {
					clist.remove(i);
					break;
				}
			}
		} else {
			if (clist != null) {
				clist.add(sMap.get(id));
			} else {
				clist = new ArrayList<Student>();
				clist.add(sMap.get(id));
			}
		}
		session.setAttribute("cartList", clist);

		response.sendRedirect("list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
