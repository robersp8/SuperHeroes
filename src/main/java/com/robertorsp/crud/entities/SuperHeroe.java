package com.robertorsp.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class SuperHeroe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Superpower is mandatory")
	private String superpower;

	public SuperHeroe() {
	}

	public SuperHeroe(String name, String superpower) {
		this.name = name;
		this.superpower = superpower;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public String getName() {
		return name;
	}

	public String getSuperpower() {
		return superpower;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name=" + name + ", superpower=" + superpower + '}';
	}
}
