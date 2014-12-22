package org.whr.springmvc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="privilege")
public class Privilege {
	private int id;
	private String url;
	private Privilege parent;
	private Set<Privilege> children= new HashSet<Privilege>();
	public Privilege() {
		// TODO Auto-generated constructor stub
	}
	public Privilege(String url, Privilege parent, String name) {
		this.url = url;
		this.parent = parent;
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="parentid")
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	@OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private String name;
	private String prescription;
	private Set<Role> roles = new HashSet<Role>();
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
	@ManyToMany(mappedBy="privileges")
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
