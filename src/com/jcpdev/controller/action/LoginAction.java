package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcpdev.dao.CustomerDao;
import com.jcpdev.dto.SessionDto;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		Map<String, String> map = new HashMap<>();
		map.put("email", id);
		map.put("password", password);
		HttpSession session = request.getSession();
		CustomerDao dao = CustomerDao.getInstance();
		SessionDto user = dao.login(map);
		if (user != null) {
			session.setAttribute("user", user);
			// response.sendRedirect("../home.jsp");
			request.setAttribute("message", "로그인 되었습니다.");
			request.setAttribute("url", "../home.jsp");
		} else {
			request.setAttribute("message", "로그인 정보 올바르지 않음");
			request.setAttribute("url", "loginView.jsp");
			// response.sendRedirect("loginView.jsp");
		}

		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url = "home.do";
		return foward;
	}

}
