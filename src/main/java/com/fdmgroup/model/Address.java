package com.fdmgroup.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Table(name="SOLOPROJECT_ADDRESS")
@NamedQueries({
	@NamedQuery(name="Address.FindAll", query="SELECT a FROM Address a")
})
@Entity
public class Address {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
	@SequenceGenerator(name = "address_generator", sequenceName = "SOLOPROJECT_ADDRESS_SEQ")
	private int id;
	
	@Column(name = "ADDRESSLINE1")
	private String addressline1;
	
	@Column(name = "ADDRESSLINE2")
	private String addressline2;
	
	@Column(name = "POSTALCODE")
	private String postalcode;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "COUNTRY")
	private String country;
	
	//@OneToMany(mappedBy="address")
	//private Set<User> users = new HashSet<User>();
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String addressline1, String addressline2, String postalcode, String city, String country) {
		super();
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.postalcode = postalcode;
		this.city = city;
		this.country = country;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getAddressline1() {
		return addressline1;
	}

	
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	
	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	
	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressline1 == null) ? 0 : addressline1.hashCode());
		result = prime * result + ((addressline2 == null) ? 0 : addressline2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + ((postalcode == null) ? 0 : postalcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressline1 == null) {
			if (other.addressline1 != null)
				return false;
		} else if (!addressline1.equals(other.addressline1))
			return false;
		if (addressline2 == null) {
			if (other.addressline2 != null)
				return false;
		} else if (!addressline2.equals(other.addressline2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (postalcode == null) {
			if (other.postalcode != null)
				return false;
		} else if (!postalcode.equals(other.postalcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressline1=" + addressline1 + ", addressline2=" + addressline2
				+ ", postalcode=" + postalcode + ", city=" + city + ", country=" + country + "]";
	}

	
}
