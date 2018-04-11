package com.wasea.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wasea.bean.Student;
import com.wasea.service.StudentService;
import com.wasea.service.StudentServiceImpl;

@WebServlet("/list.do")
public class ListStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListStudentsServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		StudentService service = new StudentServiceImpl();
		List<Student> list = service.listAll();
		List<Student> hist = new ArrayList<Student>();
		
		Map<Integer,Student> stus = new HashMap<Integer,Student>();
		for(Student s:list) {
			stus.put(s.getId(), s);
		}
		
		// Cookie技术处理历史浏览记录
		Cookie cookies[] = request.getCookies();
		Cookie ck = null;
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("stuHist")) {
					ck = c;
				}
			}
		}
		
		
		if(ck!=null) {
			String[] ids = ck.getValue().split("-");
			for(String id:ids) {
				hist.add(stus.get(Integer.valueOf(id)));
			}
		}
		
		// Session技术实现购物车
		HttpSession session = request.getSession();
		List<Student> clist = (List<Student>) session.getAttribute("cartList");
		System.out.println("clist:"+clist);
	
		request.setAttribute("list", list);
		request.setAttribute("hist", hist);
		request.setAttribute("clist", clist);
		request.getServletContext().setAttribute("sMap", stus);
		
		System.out.println("写入域对象成功~");
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
