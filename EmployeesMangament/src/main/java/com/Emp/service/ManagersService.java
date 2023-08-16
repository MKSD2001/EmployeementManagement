package com.Emp.service;

import com.Emp.model.ManagersDTO;

public interface ManagersService {

	

	// mangers
		ManagersDTO createManager(ManagersDTO manager);

		ManagersDTO readManager(int managerId);

		ManagersDTO updateManager(int ManagerId,ManagersDTO manager);

		void deleteManager(int managerId);
}
