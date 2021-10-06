package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.FreeboardDao;
import com.jcpdev.dto.Freeboard;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Freeboard vo = new Freeboard();
		vo.setSubject(request.getParameter("subject"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setContent(request.getParameter("content"));
		vo.setIp(request.getRemoteAddr());

		FreeboardDao dao = FreeboardDao.getInstance();
		dao.insertBoard(vo);

//		response.sendRedirect("listAction.jsp");
		ActionForward foward = new ActionForward();
		foward.isRedirect = true;
		foward.url = "list.do";
		return foward;
	}

}
