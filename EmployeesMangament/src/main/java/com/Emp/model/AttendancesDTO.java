package com.Emp.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "Attendance")
public class AttendancesDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AttendanceID")
	private int attendanceId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private EmployeesDTO employee;

	@Column(name = "Date")
	private Date date;

	@Column(name = "Time_In")
	private Date timeIn;

	@Column(name = "Time_Out")
	private Date timeOut;

	public AttendancesDTO() {

	}

	@Override
	public String toString() {
		return "Attendances [attendanceId=" + attendanceId + ", employee=" + employee + ", date=" + date + ", timeIn="
				+ timeIn + ", timeOut=" + timeOut + "]";
	}

	public AttendancesDTO(int attendanceId, EmployeesDTO employee, Date date, Date timeIn, Date timeOut) {
		super();
		this.attendanceId = attendanceId;
		this.employee = employee;
		this.date = date;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public EmployeesDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeesDTO employee) {
		this.employee = employee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

}
