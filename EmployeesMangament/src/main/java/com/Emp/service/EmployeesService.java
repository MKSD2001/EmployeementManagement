package com.Emp.service;

import com.Emp.entity.Employees;
import com.Emp.model.EmployeesDTO;

public interface EmployeesService {

	

public 	EmployeesDTO createEmployee(EmployeesDTO employee);
public 	EmployeesDTO readEmployee(int employeeId);
public 	EmployeesDTO updateEmployee(int employeeId, EmployeesDTO updatedemployee);
	void deleteEmployee(int employeeId);
}
