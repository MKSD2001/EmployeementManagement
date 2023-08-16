package com.Emp.service;

import java.util.List;

import com.Emp.entity.Attendances;
import com.Emp.model.AttendancesDTO;


public interface AttendancesService{

	AttendancesDTO markAttendance(AttendancesDTO attendance);
	List<AttendancesDTO> readAttendances(int employeeId);


}
