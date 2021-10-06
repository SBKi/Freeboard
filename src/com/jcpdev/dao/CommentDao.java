package com.jcpdev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.Comment;
import com.jcpdev.dto.Freeboard;
import com.jcpdev.mybatis.SqlSessionBean;

public class CommentDao {

	private static CommentDao dao = new CommentDao();

	private CommentDao() {
	}

	public static CommentDao getInstance() {
		return dao;
	}

	SqlSessionFactory sqlFactory = SqlSessionBean.getSessionFactory();

	public List<Comment> getComments(int mref) {

		SqlSession mapper = sqlFactory.openSession();
		List<Comment> list = mapper.selectList("getComments", mref);
		mapper.close();
		return list;
	}

	public void insert(Comment vo) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.insert("comment.insert", vo);
		mapper.commit();
		mapper.close();
	}

	public void updateCommnetCnt(int idx) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.update("updateCommentCnt", idx);
		mapper.commit();
		mapper.close();
	}

	public void delete(int mref) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.delete("comment.delete", mref);
		mapper.commit();
		mapper.close();
	}
	
	public void updateCountAll(int idx) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.update("updateCountAll", idx);
		mapper.commit();
		mapper.close();
	}
}
