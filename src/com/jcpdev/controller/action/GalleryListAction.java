package com.jcpdev.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GalleryDao;
import com.jcpdev.dto.Gallery;

public class GalleryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GalleryDao dao = GalleryDao.getInstance();
		List<Gallery> g_list = null;
		g_list = dao.getList();

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("list", g_list);
		
		ActionForward forward = new ActionForward();
		forward.isRedirect = false;
		forward.url = "gallery/gallery.jsp";
		return forward;
	}

}
