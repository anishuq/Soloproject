package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="SOLOPROJECT_STUDENT")
@NamedQueries({
	@NamedQuery(name = "Student.findByID", query="SELECT s FROM Student s WHERE s.id = :id"),
	@NamedQuery(name="Student.FindAll", query="SELECT s FROM Student s"),
})
public class Student extends User{
	
//in the student-course many-to-many relationship 
//student side is the OWNER. 
@ManyToMany
private List<Course> courses;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, String firstname, String lastname, String emailAddress,
			int addressid, UserTypes userType) {
		super(username, password, firstname, lastname, emailAddress, addressid, userType);
		// TODO Auto-generated constructor stub
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [courses=" + courses + ", username=" + username + ", password="
				+ password + ", firstname=" + firstname + ", lastname=" + lastname + ", id=" + id + ", emailAddress="
				+ emailAddress + ", address=" + addressid + "]";
	}
}
