package com.wasea.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wasea.bean.Student;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String str = request.getParameter("id");
		int id = Integer.valueOf(str);
		Map<Integer, Student> map = (Map<Integer, Student>) request.getServletContext().getAttribute("sMap");
		Student stu = null;
		if (map != null) {
				stu = map.get(id);
		}

		Cookie c = new Cookie("stuHist", createValue(request, str));
		c.setMaxAge(1 * 30 * 24 * 60 * 60);
		response.addCookie(c);

		request.setAttribute("stu", stu);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String createValue(HttpServletRequest req, String id) {
		Cookie[] cookies = req.getCookies();
		String stuHist = null;

		System.out.println(stuHist);
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("stuHist")) {
					stuHist = c.getValue();
					break;
				}
			}
		}

		if (cookies == null || stuHist == null) {
			return id;
		}

		String[] arr = stuHist.split("-");
		List<String> link = Arrays.asList(arr);
		LinkedList<String> ids = new LinkedList<String>(link);

		if (arr.length < 3) {
			if (ids.contains(id)) {
				ids.remove(id);
				ids.addFirst(id);
			} else {
				ids.addFirst(id);
			}
		} else {
			if (ids.contains(id)) {
				ids.remove(id);
				ids.addFirst(id);
			} else {
				ids.removeLast();
				ids.addFirst(id);
			}
		}

		StringBuffer sb = new StringBuffer();
		for (String string : ids) {
			sb.append(string + "-");
		}

		String str = sb.toString();
		stuHist = str.substring(0, str.length() - 1);

		return stuHist;
	}

}
