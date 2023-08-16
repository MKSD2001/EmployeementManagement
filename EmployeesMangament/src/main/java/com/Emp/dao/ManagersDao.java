package com.Emp.dao;

import com.Emp.entity.Managers;

public interface ManagersDao {

	
	// mangers
		Managers createManager(Managers manager);

		Managers readManager(int managerId);

		Managers updateManager(int ManagerId,Managers manager);

		void deleteManager(int managerId);
		
}
