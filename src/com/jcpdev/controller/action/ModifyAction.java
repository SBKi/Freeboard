package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.FreeboardDao;
import com.jcpdev.dto.Freeboard;

public class ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		Freeboard vo = new Freeboard();
		vo.setIdx(idx);
		vo.setSubject(request.getParameter("subject"));
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setContent(request.getParameter("content"));
		vo.setIp(request.getRemoteAddr());

		FreeboardDao dao = FreeboardDao.getInstance();
		dao.update(vo);

//		response.sendRedirect("detailAction.jsp?idx=" + idx+"&page="+pageNo);
		request.setAttribute("idx", idx);
		request.setAttribute("page", pageNo);

		ActionForward foward = new ActionForward();
		foward.isRedirect = false;
		foward.url = "detail.do";
		return foward;
	}

}
