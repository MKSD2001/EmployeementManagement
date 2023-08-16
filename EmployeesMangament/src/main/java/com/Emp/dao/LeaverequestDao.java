package com.Emp.dao;

import com.Emp.entity.Leave_request;

public interface LeaverequestDao {
	
	// leave request by an employee
		Leave_request createLeaveRequest(Leave_request leaveRequest);

		Leave_request readLeaveRequest(int leaveRequestId);

		Leave_request updateLeaveRequest(int leaverequestId,Leave_request leaveRequest);

		void deleteLeaveRequest(int leaveRequestId);


}
