package com.fdmgroup.model;

import javax.persistence.*;

@Table(name="SOLOPROJECT_USER")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "SOLOPROJECT_USER_SEQ")
	int id;
	
	@Column (name = "username")
	String username;
	
	@Column (name = "password")
	String password;
	
	@Column (name = "firstname")
	String firstname;
	
	@Column (name = "lastname")
	String lastname;
	
	@Column (name = "emailaddress")
	String emailAddress;
	
	
	//User to address is a many to one unidirectional mapping.
	//@ManyToOne
	//@JoinColumn(name = "address_id")
	//Address address;
	
	@Column(name = "address_id")
	int addressid;
	
	@Enumerated(EnumType.STRING)
	UserTypes userType;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String firstname, String lastname, String emailAddress,
			int addressid, UserTypes userType) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		
		this.emailAddress = emailAddress;
		this.addressid = addressid;
		this.userType = userType;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;	
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;	
	}


	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;	
	}


    public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	//Note: this is an ENUM.
	public String getUserType() {
		return userType.name();
	}

	public void setUserType(String userTypeStr) {
		UserTypes uType = UserTypes.valueOf(userTypeStr);
		this.userType = uType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressid;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (addressid != other.addressid)
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userType != other.userType)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", emailAddress=" + emailAddress + ", addressid=" + addressid
				+ ", userType=" + userType + "]";
	}
}
