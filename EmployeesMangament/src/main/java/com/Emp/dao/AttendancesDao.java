package com.Emp.dao;

import java.util.List;

import com.Emp.entity.Attendances;

public interface AttendancesDao  {
	//attendances

		Attendances markAttendance(Attendances attendance);
		List<Attendances> readAttendances(int employeeId);

}
