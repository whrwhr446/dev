package org.whr.springmvc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable {
	private int id;
	private String name;
	private Department department;
	private Set<Role> roles = new HashSet<Role>();
	private String loginame;
	private String email;
	private String password;
//	private Set<Article> articles = new HashSet<Article>();
//	@OneToMany(mappedBy="author")		
//	public Set<Article> getArticles() {
//		return articles;
//	}
//	public void setArticles(Set<Article> articles) {
//		this.articles = articles;
//	}
	public boolean hasPrivilege(String name){
		if("admin".equals(loginame)) return true;
		for(Role r: roles){
			for(Privilege p : r.getPrivileges()){
				if(p.getName().equals(name)) return true;
			}
		}
		return false;
	}
	public boolean hasPrivilegeUrl(String url){
		
		return false;
	}
	public String getLoginame() {
		return loginame;
	}
	public void setLoginame(String loginame) {
		this.loginame = loginame;
	}
	private String gender;
	private String phoneNumber;
	private String prescription;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="departmentid")
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="role_user",joinColumns={@JoinColumn(name="uid")},inverseJoinColumns={@JoinColumn(name="rid")})
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	

	

}
