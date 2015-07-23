package com.xz.project.activiti.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.xz.project.activiti.pojo.oa.Leave;


@Component
public interface LeaveDao extends CrudRepository<Leave, Long> {
}
