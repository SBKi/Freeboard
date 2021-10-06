package com.jcpdev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.Comment;
import com.jcpdev.dto.Freeboard;
import com.jcpdev.dto.Gallery;
import com.jcpdev.mybatis.SqlSessionBean;

public class GalleryDao {

	private static GalleryDao dao = new GalleryDao();

	private GalleryDao() {
	}

	public static GalleryDao getInstance() {
		return dao;
	}

	SqlSessionFactory sqlFactory = SqlSessionBean.getSessionFactory();

	public List<Gallery> getList() {
		SqlSession mapper = sqlFactory.openSession();
		List<Gallery> list = null;
		list = mapper.selectList("gallery.getAll");
		mapper.close();
		return list;
	}

	public void insert(Gallery vo) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.insert("gallery.insert", vo);
		mapper.commit();
		mapper.close();
	}
}
