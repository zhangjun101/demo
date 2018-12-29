package com.system.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String userName;    //
	
	private String email;      //
	
	private String passWord;    //
	
	private Date createTime;    //创建时间
	
	private Date modifyTime;    //修改时间
	
	private Long createUser;    //创建人id
	
	private Long modifyUser;    //修改人id
	
	private Long deptId;		//部门id
	
	
	// 下面是数据库不存在的字段
	private Dept dept;          //部门对象
	
	
	
	
	public User() {
		super();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	
	
	

	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getModifyTime() {
		return modifyTime;
	}


	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}


	public Long getCreateUser() {
		return createUser;
	}


	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}


	public Long getModifyUser() {
		return modifyUser;
	}


	public void setModifyUser(Long modifyUser) {
		this.modifyUser = modifyUser;
	}


	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email
				+ ", passWord=" + passWord + ", deptId=" + deptId + "]";
	}

	
}
