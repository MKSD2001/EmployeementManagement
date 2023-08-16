package com.Emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =false ,name = "EmployeeID")
	private int employeeId;

	@Column(nullable =false,name = "Name")
	private String name;

	@Column(nullable=false,name = "Position")
	private String position;

	@ManyToOne
	@JoinColumn(name = "ManagerID")
	private Managers  manager;

	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", name=" + name + ", position=" + position + ", manager="
				+ manager + ", salary=" + salary + "]";
	}

	@Column(nullable =false,name = "Salary")
	private double salary;

	public Employees() {

	}

	public Employees(int employeeId, String name, String position, Managers manager, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.position = position;
		this.manager = manager;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Managers getManager() {
		return manager;
	}

	public void setManager(Managers manager) {
		this.manager = manager;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
