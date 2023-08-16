package com.Emp.service;

import com.Emp.model.Leave_requestDTO;

public interface LeaverequestService {

	
	// leave request by an employee
			Leave_requestDTO createLeaveRequest(Leave_requestDTO leaveRequest);

			Leave_requestDTO readLeaveRequest(int leaveRequestId);

			Leave_requestDTO updateLeaveRequest(int leaverequestId,Leave_requestDTO leaveRequest);

			void deleteLeaveRequest(int leaveRequestId);

}
