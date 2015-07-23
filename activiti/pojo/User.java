package com.xz.project.activiti.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the ACT_ID_USER database table.
 */

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	private String email;
	private String first;
	private String last;
	private String password;
	private List<Group> actIdGroups;

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// bi-directional many-to-many association to Group
	public List<Group> getActIdGroups() {
		return this.actIdGroups;
	}

	public void setActIdGroups(List<Group> actIdGroups) {
		this.actIdGroups = actIdGroups;
	}

}