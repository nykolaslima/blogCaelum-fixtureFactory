package br.com.caelum.fixtureFactory.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	private Long id;
	private String username;
	private Address address;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	@OneToOne
	public Address getAddress() {
		return address;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
