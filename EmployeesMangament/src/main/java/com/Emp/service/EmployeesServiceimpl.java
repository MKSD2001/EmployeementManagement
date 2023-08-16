package com.Emp.service;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import com.Emp.entity.Helper;
import com.Emp.model.EmployeesDTO;

public class EmployeesServiceimpl implements EmployeesService {
	
	private static final org.jboss.logging.Logger logger = org.jboss.logging.Logger
			.getLogger(EmployeesServiceimpl.class);
	/// employees
	
	

	@Override
	public EmployeesDTO createEmployee(EmployeesDTO employee) {
		try (Session session = Helper.getSession()) {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			session.clear();

			logger.info("Employee created: " + employee.toString() + " and creation time is " + new java.util.Date());

			return employee;
		} catch (HibernateException h) {
			System.out.println("The Hibernate error is " + h);
			logger.error("Exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The error is " + e);
		}
		return null;
	}

	@Override
	public EmployeesDTO readEmployee(int employeeId) {
		try (Session session = Helper.getSession()) {
			EmployeesDTO employee = (EmployeesDTO) session.get(EmployeesDTO.class, employeeId);

			if (employee != null) {
				logger.info("Employee read: " + employee.toString());
			} else {
				logger.info("Employee not found with ID: " + employeeId);
			}

			return employee;
		} catch (HibernateException h) {
			System.out.println("The Hibernate error is " + h);
			logger.error("Exception happened: " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The error is " + e);
		}
		return null;
	}

	@Override
	public EmployeesDTO updateEmployee(int employeeId, EmployeesDTO updatedemployee) {

		try (Session session = Helper.getSession()) {
			EmployeesDTO emp = (EmployeesDTO) session.load(EmployeesDTO.class, employeeId);
                
		  	emp.setName(updatedemployee.getName());
			emp.setPosition(updatedemployee.getPosition());
			emp.setSalary(updatedemployee.getSalary());
			emp.setManager(updatedemployee.getManager());
			session.beginTransaction();
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
			logger.info("account updated  " + emp.toString() + " and time is " + new java.util.Date());
			return emp;

		} catch (HibernateException he) {
			System.out.println("the hibernate error is: " + he);
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("the hibernate error is: " + e);
		}
		return null;
	}

	@Override
	public void deleteEmployee(int employeeId) {

		try (Session session = Helper.getSession()) {
			EmployeesDTO empdelete = (EmployeesDTO) session.load(EmployeesDTO.class, employeeId);
			session.beginTransaction();

			int input = JOptionPane.showConfirmDialog(null, "do you want to delete?",
					"select what you want to delete or not?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				session.delete(empdelete);

				JOptionPane.showMessageDialog(null, "Object is deleted!!!!...");
				logger.info(employeeId + " employee details deleted " + " and the time is " + new java.util.Date());

			} else
				JOptionPane.showMessageDialog(null, "User want to retain it...");
			session.getTransaction().commit();

		} catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
			logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception h) {
			System.out.println("the general error is " + h);
		}

	}
	

}
