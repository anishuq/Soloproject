package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SOLOPROJECT_COURSE")
@NamedQueries({
	@NamedQuery(name = "Course.findByID", query="SELECT c FROM Course c WHERE c.id = :id"),
	@NamedQuery(name="Course.FindAll", query="SELECT c FROM Course c"),
})
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "SOLOPROJECT_COURSE_SEQ")
	private int id;
	
		
	private String coursename;
	
	
	private List<Student> students;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String coursename) {
		super();
		this.coursename = coursename;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coursename == null) ? 0 : coursename.hashCode());
		result = prime * result + id;
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		Course other = (Course) obj;
		if (coursename == null) {
			if (other.coursename != null)
				return false;
		} else if (!coursename.equals(other.coursename))
			return false;
		if (id != other.id)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", coursename=" + coursename + ", students=" + students + "]";
	}

	
}
