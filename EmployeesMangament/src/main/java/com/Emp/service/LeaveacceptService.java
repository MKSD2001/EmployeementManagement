package com.Emp.service;

import com.Emp.model.Leave_acceptDTO;

public interface LeaveacceptService {
	

	// Create a new leave accept by a manager
	Leave_acceptDTO createLeaveAccept(Leave_acceptDTO leaveAccept);

	Leave_acceptDTO readLeaveAccept(int leaveAcceptId );
	
	Leave_acceptDTO updateLeaveAccept(int Leave_acceptId,Leave_acceptDTO leaveAccept);

	void deleteLeaveAccept(int leaveAcceptId);

}
