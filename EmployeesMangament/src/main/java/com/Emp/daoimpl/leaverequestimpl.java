package com.Emp.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Emp.dao.LeaverequestDao;
import com.Emp.entity.Helper;
import com.Emp.entity.Leave_request;
import com.Emp.exception.GlobalException;

public class leaverequestimpl implements LeaverequestDao {

	private static final org.jboss.logging.Logger logger = org.jboss.logging.Logger
			.getLogger(leaverequestimpl.class);
	/// employees
	
	@Override
	public Leave_request createLeaveRequest(Leave_request leaveRequest) {

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
	public Leave_request readLeaveRequest(int leaveRequestId)

	{
		try (Session session = Helper.getSession()) {
			Leave_request view = (Leave_request) session.get(Leave_request.class, leaveRequestId);

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
	public Leave_request updateLeaveRequest(int leaverequestId, Leave_request leaveRequest) {

		try (Session session = Helper.getSession()) {

			Leave_request leave = (Leave_request) session.load(Leave_request.class, leaverequestId);

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
			Leave_request deleteleave = (Leave_request) session.load(Leave_request.class, leaveRequestId);

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
     
     private void handleException(String message, Throwable throwable) throws GlobalException {
         logger.error(message, throwable);
         throw new GlobalException(message); // Throw GlobalException
     }

     private void handleException(String message, Exception exception) throws GlobalException {
         logger.error(message, exception);
         throw new GlobalException(message); // Throw GlobalException
     }
}
