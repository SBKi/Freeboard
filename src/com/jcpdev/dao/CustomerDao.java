package com.jcpdev.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jcpdev.dto.Customer;
import com.jcpdev.dto.SessionDto;
import com.jcpdev.mybatis.SqlSessionBean;

public class CustomerDao {

	private static CustomerDao dao = new CustomerDao();

	private CustomerDao() {
	}

	public static CustomerDao getInstance() {
		return dao;
	}

	SqlSessionFactory sqlFactory = SqlSessionBean.getSessionFactory();

	public SessionDto login(Map<String, String> map) {
		SqlSession mapper = sqlFactory.openSession();
		SessionDto vo = null;
		vo = mapper.selectOne("LoginCheck", map);
		mapper.close();
		return vo;
	}

}
