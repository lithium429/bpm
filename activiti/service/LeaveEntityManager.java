package com.xz.project.activiti.service;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xz.project.activiti.pojo.oa.LeaveJpaEntity;

/**
 * 请假实体JPA 实体管理器
 * @author: Henry Yan
 */
@Service
public class LeaveEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public LeaveJpaEntity newLeave(DelegateExecution execution) {
        LeaveJpaEntity leave = new LeaveJpaEntity();
        leave.setProcessInstanceId(execution.getProcessInstanceId());
        leave.setUserId(execution.getVariable("applyUserId").toString());
        leave.setStartTime((Date) execution.getVariable("startTime"));
        leave.setEndTime((Date) execution.getVariable("endTime"));
        leave.setLeaveType(execution.getVariable("leaveType").toString());
        leave.setReason(execution.getVariable("reason").toString());
        leave.setApplyTime(new Date());
        entityManager.persist(leave);
        return leave;
    }

    @Transactional
    public void save(LeaveJpaEntity leave) {
        entityManager.persist(leave);
    }

    public LeaveJpaEntity getLeave(Long id) {
        return entityManager.find(LeaveJpaEntity.class, id);
    }

}