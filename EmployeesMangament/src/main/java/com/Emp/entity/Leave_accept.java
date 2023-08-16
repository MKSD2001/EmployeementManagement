package com.Emp.entity;

import javax.persistence.*;



@Entity
@Table(name = "Leave_Accept")
public class Leave_accept {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable =false,name = "LeaveAcceptID")
	    private int leaveAcceptId;

	    @ManyToOne
	    @JoinColumn(name = "ManagerID")
	    private Managers manager;

	    @ManyToOne
	    @JoinColumn(name = "LeaveRequestID")
	    private Leave_request leaveRequest;

	    @Column(name = "Status")
	    private String status;

	   
	    @Override
		public String toString() {
			return "Leave_accept [leaveAcceptId=" + leaveAcceptId + ", manager=" + manager + ", leaveRequest="
					+ leaveRequest + ", status=" + status + "]";
		}
		public Leave_accept() {
	    	
	    }
		public Leave_accept(int leaveAcceptId, Managers manager, Leave_request leaveRequest, String status) {
			super();
			this.leaveAcceptId = leaveAcceptId;
			this.manager = manager;
			this.leaveRequest = leaveRequest;
			this.status = status;
		}

		public int getLeaveAcceptId() {
			return leaveAcceptId;
		}

		public void setLeaveAcceptId(int leaveAcceptId) {
			this.leaveAcceptId = leaveAcceptId;
		}

		public Managers getManager() {
			return manager;
		}

		public void setManager(Managers manager) {
			this.manager = manager;
		}

		public Leave_request getLeaveRequest() {
			return leaveRequest;
		}

		public void setLeaveRequest(Leave_request leaveRequest) {
			this.leaveRequest = leaveRequest;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
 
	
	
	

}
