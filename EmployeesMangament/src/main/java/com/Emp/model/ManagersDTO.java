package com.Emp.model;


import javax.persistence.*;

@Entity
@Table(name = "Managers")
public class ManagersDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable =false,name = "ManagerID")
	private int managerId;

	
	@Column(nullable =false,name = "Name")
	private String name;

	@Column( nullable = false,name = "Position")
	private String position;
	
	public ManagersDTO() {
		
	}

	public ManagersDTO(int managerId, String name, String position) {
		super();
		this.managerId = managerId;
		this.name = name;
		this.position = position;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
	@Override
	public String toString() {
		return "Managers [managerId=" + managerId + ", name=" + name + ", position=" + position + "]";
	}


}
