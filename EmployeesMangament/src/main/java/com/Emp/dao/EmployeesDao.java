package com.Emp.dao;

import com.Emp.entity.Employees;

public interface EmployeesDao {

	Employees createEmployee(Employees employee);
	Employees readEmployee(int employeeId);
	Employees updateEmployee(int employeeId, Employees updatedemployee);
	void deleteEmployee(int employeeId);
		
	
}
