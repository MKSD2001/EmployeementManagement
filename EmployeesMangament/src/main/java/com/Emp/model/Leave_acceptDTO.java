package com.Emp.model;


import javax.persistence.*;

import com.Emp.model.ManagersDTO.*;



@Entity
@Table(name = "Leave_Accept")
public class Leave_acceptDTO {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable =false,name = "LeaveAcceptID")
	    private int leaveAcceptId;

	    @ManyToOne
	    @JoinColumn(name = "ManagerID")
	    private ManagersDTO manager;

	    @ManyToOne
	    @JoinColumn(name = "LeaveRequestID")
	    private Leave_requestDTO leaveRequest;

	    @Column(name = "Status")
	    private String status;

	   
	    @Override
		public String toString() {
			return "Leave_accept [leaveAcceptId=" + leaveAcceptId + ", manager=" + manager + ", leaveRequest="
					+ leaveRequest + ", status=" + status + "]";
		}
		public Leave_acceptDTO() {
	    	
	    }
		public Leave_acceptDTO(int leaveAcceptId, ManagersDTO manager, Leave_requestDTO leaveRequest, String status) {
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

		public ManagersDTO getManager() {
			return manager;
		}

		public void setManager(ManagersDTO manager) {
			this.manager = manager;
		}

		public Leave_requestDTO getLeaveRequest() {
			return leaveRequest;
		}

		public void setLeaveRequest(Leave_requestDTO leaveRequest) {
			this.leaveRequest = leaveRequest;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
 
	
	
	

}