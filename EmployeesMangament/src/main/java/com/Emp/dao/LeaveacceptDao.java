package com.Emp.dao;

import com.Emp.entity.Leave_accept;

public interface LeaveacceptDao {


	// Create a new leave accept by a manager
	Leave_accept createLeaveAccept(Leave_accept leaveAccept);

	Leave_accept readLeaveAccept(int leaveAcceptId );
	
	Leave_accept updateLeaveAccept(int Leave_acceptId,Leave_accept leaveAccept);

	void deleteLeaveAccept(int leaveAcceptId);

}
