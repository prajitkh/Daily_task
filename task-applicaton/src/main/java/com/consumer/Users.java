package com.consumer;

import java.io.Serializable;

import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
public class Users implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
