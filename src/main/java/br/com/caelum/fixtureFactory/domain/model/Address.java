package br.com.caelum.fixtureFactory.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	private Long id;
	private State state;
	private City city;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	@ManyToOne
	public State getState() {
		return state;
	}
	@ManyToOne
	public City getCity() {
		return city;
	}
	public String getStreet() {
		return street;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	private String street;

}
