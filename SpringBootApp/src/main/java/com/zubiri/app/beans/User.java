package com.zubiri.app.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String username;

	private String password;

	@Nullable
	private String role;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Authority> authorityes;
	
	@Column(unique = true)
	private String correo;
	
	@Column(unique = true)
	private String dni;

	public User() {
	}

	public User(String username, String password, String dNI, String correo, String role) {
		super();
		this.username = username;
		this.password = password;
		this.dni = dNI;
		this.role = role;
		this.correo = correo;
	}

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

	public List<Authority> getAuthority() {
		return authorityes;
	}

	public void setAuthority(List<Authority> authority) {
		this.authorityes = authority;
	}

	public String getRole() {
		return role;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Authority> getAuthorityes() {
		return authorityes;
	}

	public void setAuthorityes(List<Authority> authorityes) {
		this.authorityes = authorityes;
	}

}
