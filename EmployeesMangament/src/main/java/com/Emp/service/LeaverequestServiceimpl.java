package com.Emp.service;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Emp.entity.Helper;
import com.Emp.model.Leave_requestDTO;



public class LeaverequestServiceimpl implements LeaverequestService {
	
	private static final org.jboss.logging.Logger logger = org.jboss.logging.Logger
			.getLogger(LeaverequestServiceimpl.class);
	/// employees
	
	@Override
	public Leave_requestDTO createLeaveRequest(Leave_requestDTO leaveRequest) {

		try (Session session = Helper.getSession()) {
			session.beginTransaction();
			session.save(leaveRequest);
			session.getTransaction().commit();
			session.clear();

			logger.info(
					"Employee created: " + leaveRequest.toString() + " and creation time is " + new java.util.Date());

			return leaveRequest;
		} catch (HibernateException h) {
			System.out.println("The Hibernate error is " + h);
			logger.error("Exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The error is " + e);
		}
		return null;
	}

	@Override
	public Leave_requestDTO readLeaveRequest(int leaveRequestId)

	{
		try (Session session = Helper.getSession()) {
			Leave_requestDTO view = (Leave_requestDTO) session.get(Leave_requestDTO.class, leaveRequestId);

			if (view != null) {
				logger.info("Employee read: " + view.toString());
			} else {
				logger.info("Employee not found with ID: " + leaveRequestId);
			}

			return view;
		} catch (HibernateException h) {
			System.out.println("The Hibernate error is " + h);
			logger.error("Exception happened: " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The error is " + e);
		}
		return null;
	}
     @Override
	public Leave_requestDTO updateLeaveRequest(int leaverequestId, Leave_requestDTO leaveRequest) {

		try (Session session = Helper.getSession()) {

			Leave_requestDTO leave = (Leave_requestDTO) session.load(Leave_requestDTO.class, leaverequestId);

			leave.setEmployee(leaveRequest.getEmployee());
			leave.setDateFrom(leaveRequest.getDateFrom());
			leave.setDateTo(leaveRequest.getDateTo());
			leave.setReason(leaveRequest.getReason());
			session.beginTransaction();
			session.saveOrUpdate(leave);
			session.getTransaction().commit();
			logger.info("leave request  updated  " + leave.toString() + " and time is " + new java.util.Date());
			return leaveRequest;
		} catch (HibernateException he) {
			System.out.println("the hibernate error is: " + he);
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("the hibernate error is: " + e);
		}
		return null;

	}
     @Override
	public void deleteLeaveRequest(int leaveRequestId) {

		try (Session session = Helper.getSession()) 
		{
			Leave_requestDTO deleteleave = (Leave_requestDTO) session.load(Leave_requestDTO.class, leaveRequestId);

			session.beginTransaction();

			int input = JOptionPane.showConfirmDialog(null, "do you want to delete ",
					"select what you want to delete or not?", JOptionPane.YES_NO_OPTION);
			if (input == 0)
			{
				session.delete(deleteleave);
				JOptionPane.showMessageDialog(null, "Object is deleted!!!!...");
				logger.info(deleteleave + " account deleted " + " and the time is " + new java.util.Date());

			} else 
			{
				JOptionPane.showMessageDialog(null, "User want to retain it...");
			   session.getTransaction().commit();
			}
		}

		 catch (HibernateException h) {
			System.out.println("the hibernate error is " + h);
			logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception h) {
			System.out.println("the general error is " + h);
		}

	

	}
     

}
