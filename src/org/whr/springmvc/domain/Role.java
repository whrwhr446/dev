package org.whr.springmvc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.util.comparator.InvertibleComparator;

@Entity
@Table(name="role")
public class Role implements Serializable {
	private int id;
	private String name;
	private Set<Privilege> privileges = new HashSet<Privilege>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="role_privilege",joinColumns={@JoinColumn(name="rid")},inverseJoinColumns={@JoinColumn(name="pid")})
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
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
	private String prescription;
	private Set<User> user = new HashSet<User>();
	@ManyToMany(mappedBy="roles",cascade=CascadeType.REMOVE)
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
}
