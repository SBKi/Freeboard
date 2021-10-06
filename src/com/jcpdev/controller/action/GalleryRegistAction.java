package com.jcpdev.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.GalleryDao;
import com.jcpdev.dto.Gallery;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class GalleryRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GalleryDao gdao = GalleryDao.getInstance();
		request.setCharacterEncoding("UTF-8");

		String path = "C:\\Users\\Beomki\\ShinBeomki"; // 프로젝트 폴더와 관련 없는 경로일때 url 매핑을 server.xml에 설정한다.
//	      String path = request.getServletContext().getRealPath("/image");    //프로젝트 폴더의 하위 경로일때

		int size = 10 * 1024 * 1024;
		try {
			MultipartRequest multi_request = new MultipartRequest(request, path, size, "UTF-8",
					new DefaultFileRenamePolicy());
			// title(text), pic(file) 2개 파라미터
			String title = multi_request.getParameter("title");
			String filename = multi_request.getFilesystemName("pic");
			Gallery vo = new Gallery(0, title, filename);
			gdao.insert(vo); // 업로드한 파일을 테이블 컬럼 값으로 저장.
			System.out.println("gallery insert 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ActionForward forward = new ActionForward();
		forward.isRedirect = true;
		forward.url = "gallery.do";
		return forward;
	}

}
