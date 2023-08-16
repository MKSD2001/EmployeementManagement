package com.Emp.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Emp.dao.ManagersDao;
import com.Emp.entity.Helper;
import com.Emp.entity.Managers;
import com.Emp.exception.GlobalException;

public class Managersimpl implements ManagersDao{
	
	private static final org.jboss.logging.Logger logger = org.jboss.logging.Logger
			.getLogger(Managersimpl.class);
	@Override
	public Managers createManager(Managers manager) {

		try (Session session = Helper.getSession()) {
			session.beginTransaction();
			session.save(manager);
			session.getTransaction().commit();
			session.clear();

			logger.info("Employee created: " + manager.toString() + " and creation time is " + new java.util.Date());

			return manager;
		} catch (HibernateException h) {
			System.out.println("The Hibernate error is " + h);
			logger.error("Exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The error is " + e);
		}
		return null;

	}

	@Override
	public Managers readManager(int managerId) {
		try (Session session = Helper.getSession()) {
			Managers reademployee = (Managers) session.get(Managers.class, managerId);

			if (reademployee != null) {
				logger.info("Employee read: " + reademployee.toString());
			} else {
				logger.info("Employee not found with ID: " + managerId);
			}

			return reademployee;
		} catch (HibernateException h) {
			System.out.println("The Hibernate error is " + h);
			logger.error("Exception happened: " + h.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("The error is " + e);
		}
		return null;
	}

	@Override
	public Managers updateManager(int managerId, Managers manager) {

		try (Session session = Helper.getSession()) {
			Managers man = (Managers) session.load(Managers.class, managerId);

			man.setName(manager.getName());
			man.setPosition(manager.getPosition());

			session.beginTransaction();
			session.saveOrUpdate(man);
			session.getTransaction().commit();
			logger.info("account updated  " + man.toString() + " and time is " + new java.util.Date());
			return man;

		} catch (HibernateException he) {
			System.out.println("the hibernate error is: " + he);
			logger.error("exception happened " + he.toString() + " and error creation time is " + new java.util.Date());
		} catch (Exception e) {
			System.out.println("the hibernate error is: " + e);
		}
		return null;
	}

	@Override
	public void deleteManager(int managerId) {

		try (Session session = Helper.getSession()) {
			Managers mandelete = (Managers) session.load(Managers.class, managerId);
			session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "do you want to delete?",
					"select what you want to delete or not?", JOptionPane.YES_NO_OPTION);
			if (input == 0) {
				session.delete(mandelete);
				JOptionPane.showMessageDialog(null, "Object is deleted!!!!...");
				logger.info(managerId + " employee details deleted " + " and the time is " + new java.util.Date());

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
	private void handleException(String message, Throwable throwable) throws GlobalException {
        logger.error(message, throwable);
        throw new GlobalException(message); // Throw GlobalException
    }

    private void handleException(String message, Exception exception) throws GlobalException {
        logger.error(message, exception);
        throw new GlobalException(message); // Throw GlobalException
    }

}
