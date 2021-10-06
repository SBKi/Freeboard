package com.jcpdev.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.FreeboardDao;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int pageNo = Integer.parseInt(request.getParameter("page"));
		String password = request.getParameter("password");
		FreeboardDao dao = FreeboardDao.getInstance();
		Map<String, Object> map = new HashMap<>();
		map.put("idx", idx);
		map.put("password", password);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		int n = dao.delete(map);
		String del = null;
		String href = null;
		String message = null;
		request.setAttribute("idx", idx);
		if (n == 1) {
			message = "삭제 완료 되었습니다.";
			href = "list.do?page=" + pageNo;
		} else {
			message = "비밀번호가 다릅니다.";
			href = "detail.do?page=" + pageNo + "&idx=" + idx;
		}
		out.print("<script>");
		out.print("alert('" + message + "');");
		out.print("location.href='" + href + "';");
		out.print("");
		out.print("</script>");

		return null;
	}

}
