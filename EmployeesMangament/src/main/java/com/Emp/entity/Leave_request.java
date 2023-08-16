package com.Emp.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Leave_Request")
public class Leave_request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LeaveRequestID")
    private int leaveRequestId;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employees employee;

    @Column(name = "Date_From")
    private Date dateFrom;

    @Column(name = "Date_To")
    private Date dateTo;

    @Column(name = "Reason")
    private String reason;
	
   
	public Leave_request() {
		
	}


	public Leave_request(int leaveRequestId, Employees employee, Date dateFrom, Date dateTo, String reason ) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.employee = employee;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.reason = reason;
		//this.status = status;
	}

	

	


	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
    
	//public String getStatus() {
	    //return status;
	//}
    
	@Override
	public String toString() {
		return "Leave_request [leaveRequestId=" + leaveRequestId + ", employee=" + employee + ", dateFrom=" + dateFrom
				+ ", dateTo=" + dateTo + ", reason=" + reason + "]";
	}
    

}