package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("../home.jsp");

		HttpSession session = request.getSession();
		session.invalidate();
		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url = "home.do";
		return foward;
	}

}
