package com.xz.project.activiti.service;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.Group;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xz.base.exception.ServiceException;
import com.xz.project.activiti.pojo.User;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	
	private Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Resource
	private ProcessEngine engine;
	
	private IdentityService identityService=engine.getIdentityService();

	@Override
	public void save(User user, Long orgId, List<Long> roleIds,
			boolean synToActiviti) throws ServiceException, Exception {
//		  String userId = ObjectUtils.toString(user.getId());
//		  
//	        // 保存系统用户
//	        accountManager.saveEntity(user);
//	 
//	        // 同步数据到Activiti Identify模块
//	        if (synToActiviti) {
//	            UserQuery userQuery = identityService.createUserQuery();
//	            List<org.activiti.engine.identity.user> activitiUsers = userQuery.userId(userId).list();
//	            
//	            if (activitiUsers.size() == 1) {
//	                updateActivitiData(user, roleIds, activitiUsers.get(0));
//	            } else if (activitiUsers.size() > 1) {
//	                String errorMsg = "发现重复用户：id=" + userId;
//	                logger.error(errorMsg);
//	                throw new RuntimeException(errorMsg);
//	            } else {
//	                newActivitiUser(user, roleIds);
//	            }
//	        }
			
	}

	@Override
	public void delete(Long userId, boolean synToActiviti)
			throws ServiceException, Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void synAllUserAndRoleToActiviti() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllActivitiIdentifyData() throws Exception {
		// TODO Auto-generated method stub

	}
	
	
	/**
     * 添加工作流用户以及角色
     * @param user      用户对象{@link User}
     * @param roleIds   用户拥有的角色ID集合
     */
    private void newActivitiUser(User user, List<Long> roleIds) {
        String userId = user.getId().toString();
 
        // 添加用户
        saveActivitiUser(user);
 
        // 添加membership
        addMembershipToIdentify(roleIds, userId);
    }
 
    /**
     * 添加一个用户到Activiti {@link org.activiti.engine.identity.User}
     * @param user  用户对象, {@link User}
     */
    private void saveActivitiUser(User user) {
        String userId = user.getId().toString();
        org.activiti.engine.identity.User activitiUser = identityService.newUser(userId);
        cloneAndSaveActivitiUser(user, activitiUser);
        logger.debug("add activiti user: {}", ToStringBuilder.reflectionToString(activitiUser));
    }
 
    /**
     * 添加Activiti Identify的用户于组关系
     * @param roleIds   角色ID集合
     * @param userId    用户ID
     */
    private void addMembershipToIdentify(List<Long> roleIds, String userId) {
//        for (Long roleId : roleIds) {
//            Role role = roleManager.getEntity(roleId);
//            logger.debug("add role to activit: {}", role);
//            identityService.createMembership(userId, role.getEnName());
//        }
    }
 
    /**
     * 更新工作流用户以及角色
     * @param user          用户对象{@link User}
     * @param roleIds       用户拥有的角色ID集合
     * @param activitiUser  Activiti引擎的用户对象，{@link org.activiti.engine.identity.User}
     */
    private void updateActivitiData(User user, List<Long> roleIds, org.activiti.engine.identity.User activitiUser) {
 
        String userId = user.getId().toString();
 
        // 更新用户主体信息
        cloneAndSaveActivitiUser(user, activitiUser);
 
        // 删除用户的membership
        List<Group> activitiGroups = identityService.createGroupQuery().groupMember(userId).list();
        for (Group group : activitiGroups) {
            logger.debug("delete group from activit: {}", ToStringBuilder.reflectionToString(group));
            identityService.deleteMembership(userId, group.getId());
        }
 
        // 添加membership
        addMembershipToIdentify(roleIds, userId);
    }
 
    /**
     * 使用系统用户对象属性设置到Activiti User对象中
     * @param user          系统用户对象
     * @param activitiUser  Activiti User
     */
    private void cloneAndSaveActivitiUser(User user, org.activiti.engine.identity.User activitiUser) {
        activitiUser.setFirstName(user.getName());
        activitiUser.setLastName(StringUtils.EMPTY);
        activitiUser.setPassword(StringUtils.EMPTY);
        activitiUser.setEmail(user.getEmail());
        identityService.saveUser(activitiUser);
    }
	

}
