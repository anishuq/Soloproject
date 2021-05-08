package com.fdmgroup.model;

import javax.persistence.*;


@Entity
@Table(name="SOLOPROJECT_EMPLOYEE")
@NamedQueries({
	@NamedQuery(name = "Employee.findByID", query="SELECT e FROM Employee e WHERE e.id = :id"),
	@NamedQuery(name="Employee.FindAll", query="SELECT e FROM Employee e"),
})
public class Employee extends User{
	
	@Column(name = "salary")
	private int salary;

	public Employee() {
		super();
	}
	
    public Employee(String username, String password, String firstname, String lastname, String emailAddress,
			int addressid, UserTypes userType, int salary) {
		super(username, password, firstname, lastname, emailAddress,
				addressid, userType);
		this.salary = salary;
	}
    
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (salary != other.salary)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", id=" + id + ", emailAddress=" + emailAddress + ", address="
				+ addressid + ", " + " userType=" + userType + "]";
	}

}
