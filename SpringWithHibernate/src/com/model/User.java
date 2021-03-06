package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@SuppressWarnings("serial")
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "CheckUser",
	query = "select * from login where username=:username and password=:password",
        resultClass = User.class
	)
})
@Entity
											
@Table(name = "Login")
public class User implements Serializable  {


	@Id
	@GeneratedValue
	@Column(name = "id")

	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
