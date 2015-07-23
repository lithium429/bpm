package com.xz.project.activiti.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.Group;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xz.project.activiti.pojo.User;
import com.xz.project.activiti.service.AcUserService;

@Controller
@RequestMapping(value="/activiti")
public class AcUserController {
	
	@Resource
	private ProcessEngine engine;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String userLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		/*Map map=new HashMap();
		map.put("id", username);
		map.put("password", password);
		User idtentiUser=(User)service.identiUser(map);
		request.getSession().setAttribute("user", idtentiUser);*/
		IdentityService identityService = engine.getIdentityService();
		boolean checkUser = identityService.checkPassword(username, password);
		if(checkUser){
//			User user=(User)identityService.createUserQuery().userId(username).singleResult();
//			request.getSession().setAttribute("user", user);
//			List<Group> groupList = identityService.createGroupQuery().groupMember(username).list();
//			request.getSession().setAttribute("groups", groupList);
//			String[] groupNames = new String[groupList.size()];
//			for (int i = 0; i < groupNames.length; i++) {
//				System.out.println(groupList.get(i).getName());
//				groupNames[i] = groupList.get(i).getName();
//			}
//			
//			request.getSession().setAttribute("groupNames", ArrayUtils.toString(groupNames));
			System.out.println(request.getContextPath());
			System.out.println(request.getServletPath());
			return "redirect:/views/activiti/acti_index.jsp";
		}else {
			return "redirect:/activi_login.jsp";
		}
		
	}
	
}
