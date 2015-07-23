package com.xz.project.activiti.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the ACT_ID_GROUP database table.
 */
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer rev;
	private String name;
	private String type;
	private List<User> actIdUsers;

	public Group() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getRev() {
		return rev;
	}

	public void setRev(Integer rev) {
		this.rev = rev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// bi-directional many-to-many association to User
	public List<User> getActIdUsers() {
		return this.actIdUsers;
	}

	public void setActIdUsers(List<User> actIdUsers) {
		this.actIdUsers = actIdUsers;
	}

}