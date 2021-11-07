package io.ailtonbsj.projeto1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.ailtonbsj.projeto1.StatusRole;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private StatusRole status;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	List<Functionality> functionalities;
	
	public Role() {
	}
	public Role(String name, StatusRole status, List<Functionality> functionalities) {
		super();
		this.name = name;
		this.status = status;
		this.functionalities = functionalities;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StatusRole getStatus() {
		return status;
	}
	public void setStatus(StatusRole status) {
		this.status = status;
	}
	public List<Functionality> getFunctionalities() {
		return functionalities;
	}
	public void setFunctionalities(List<Functionality> functionalities) {
		this.functionalities = functionalities;
	}
	
	@Override
	public String toString() {
		return name + "{" + functionalities + "}";
		//return "Role [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
}
