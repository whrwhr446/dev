package org.whr.springmvc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.springframework.core.annotation.Order;
@Entity
@Table(name="department")
public class Department implements Serializable {
	private int id;
	private String name;
	private String prescription;
	private Set<User> users = new HashSet<User>();
	private Department parent;
	private Set<Department> chilren=new HashSet<Department>();
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
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	@OneToMany(mappedBy="department")
//	@JoinColumn(name="uid" )
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@ManyToOne
	@JoinColumn(name="departmentId")
	public Department getParent() {
		return parent;
	}
	public void setParent(Department parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent" ,cascade=CascadeType.REMOVE)
	@OrderBy("id ASC")
	public Set<Department> getChilren() {
		return chilren;
	}
	public void setChilren(Set<Department> chilren) {
		this.chilren = chilren;
	}
	
}
