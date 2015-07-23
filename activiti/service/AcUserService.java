package com.xz.project.activiti.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.xz.project.activiti.pojo.User;


public class AcUserService {

	@Resource
	private SqlSession session;
	
	public User identiUser(Map map) {
		// TODO Auto-generated method stub
		
		return (User)session.selectOne(this.getClass().getName()+".indentiUser", map);
	}

}
