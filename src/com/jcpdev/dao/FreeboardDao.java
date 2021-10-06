package com.jcpdev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.Freeboard;
import com.jcpdev.mybatis.SqlSessionBean;

public class FreeboardDao {

	private static FreeboardDao dao = new FreeboardDao();

	private FreeboardDao() {
	}

	public static FreeboardDao getInstance() {
		return dao;
	}

	SqlSessionFactory sqlFactory = SqlSessionBean.getSessionFactory();

	// idx로 한개 행 조회
	public Freeboard getOne(int idx) {
		SqlSession mapper = sqlFactory.openSession();
		Freeboard dto = mapper.selectOne("selectByIdx", idx);
		mapper.close();
		return dto;
	}

	// getList
	public List<Freeboard> getList(Map<String, Integer> map) {
		List<Freeboard> list = null;
		SqlSession mapper = sqlFactory.openSession();
		list = mapper.selectList("getList", map);
		mapper.close();
		return list;
	}

	public void insertBoard(Freeboard vo) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.insert("freeboard.insert", vo);
		mapper.commit();
		mapper.close();
	}

	public int getCount() {
		SqlSession mapper = sqlFactory.openSession();
		int result = mapper.selectOne("getCount");
		return result;
	}

	public void update(Freeboard vo) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.update("update", vo);
		mapper.commit();
		mapper.close();
	}

	public void readCount(int idx) {
		SqlSession mapper = sqlFactory.openSession();
		mapper.update("readCount", idx);
		mapper.commit();
		mapper.close();
	}

	public int delete(Map<String, Object> map) {
		SqlSession mapper = sqlFactory.openSession();
		int n = mapper.delete("freeboard.delete", map);
		mapper.commit();
		mapper.close();
		return n;
	}

	public Freeboard passwordCheck(Map<String, Integer> map) {
		SqlSession mapper = sqlFactory.openSession();
		Freeboard vo = mapper.selectOne("passwordCheck", map);
		mapper.close();
		return vo;
	}
}
