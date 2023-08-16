package com.Emp.daoimpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Emp.dao.LeaveacceptDao;
import com.Emp.entity.Helper;
import com.Emp.entity.Leave_accept;
import com.Emp.exception.GlobalException;

public class leaveacceptimpl implements LeaveacceptDao {

	private static final org.jboss.logging.Logger logger = org.jboss.logging.Logger
			.getLogger(leaveacceptimpl.class);
	
	// Create a new leave accept by a 
    @Override
	public Leave_accept createLeaveAccept(Leave_accept leaveAccept) {
		
    	try (Session session = Helper.getSession()){
    		
    		session.beginTransaction();
    		session.save(leaveAccept);
    		session.getTransaction().commit();
    		session.clear();
    	logger.info("leave request accepted "+leaveAccept.toString()+"accepted time is "+new java.util.Date() );	
    	
    	return leaveAccept;	
    	}
    	catch(HibernateException h) {
    		System.out.println("exception is "+h);
    		logger.error("execptio happend "+h.toString());
    		
    	}
    	catch(Exception e) {
    		System.out.println("Exception is"+e);
    		logger.error("exception happend"+e.toString());
    		
    	}
    	return null;
		
		

	}
    
    @Override
    public Leave_accept readLeaveAccept(int leaveRequestId) {
        try (Session session = Helper.getSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Leave_accept> criteriaQuery = criteriaBuilder.createQuery(Leave_accept.class);
            Root<Leave_accept> root = criteriaQuery.from(Leave_accept.class);

            criteriaQuery.select(root)
                .where(criteriaBuilder.equal(root.get("leaveRequest").get("leaveRequestId"), leaveRequestId));

            Leave_accept leaveAccept = session.createQuery(criteriaQuery).uniqueResult();

            if (leaveAccept != null) {
                logger.info("Leave accept details read: " + leaveAccept.toString() + " - " + new java.util.Date());
            } else {
                logger.info("Leave accept not found for Leave Request ID: " + leaveRequestId);
            }

            return leaveAccept;
        } catch (HibernateException h) {
            System.out.println("Exception: " + h);
            logger.error("Exception happened: " + h.toString() + " - " + new java.util.Date());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            logger.error("Exception happened: " + e.toString() + " - " + new java.util.Date());
        }
        return null;
    }

     @Override
	public Leave_accept updateLeaveAccept(int Leave_acceptId, Leave_accept leaveAccept) {
		try (Session session = Helper.getSession()){
			
		Leave_accept upleaveacc = (Leave_accept) session.load(Leave_accept.class,Leave_acceptId  );
		upleaveacc.setManager(leaveAccept.getManager());
		upleaveacc.setLeaveRequest(leaveAccept.getLeaveRequest());
		upleaveacc.setManager(leaveAccept.getManager());
		upleaveacc.setStatus(leaveAccept.getStatus());
		
		session.beginTransaction();
		session.saveOrUpdate(upleaveacc);
		session.getTransaction().commit();
		logger.info("leaveaccept sucessfully updated"+upleaveacc.toString()+"updated date is "+ new java.util.Date());
		
		
		return upleaveacc;
  }catch(HibernateException h) {
		System.out.println("exception is "+h);
		logger.error("execptio happend "+h.toString());
		
	}
	catch(Exception e) {
		System.out.println("Exception is"+e);
		logger.error("exception happend"+e.toString());
		
	}
	return null;
	
		
		
		

	}
     @Override
	public void deleteLeaveAccept(int leaveAcceptId)  {
		try (Session session = Helper.getSession()){
			
			Leave_accept delleaveacc = (Leave_accept) session.load(Leave_accept.class,leaveAcceptId);
			
			
		session.beginTransaction();
		int input = JOptionPane.showConfirmDialog(null, "do you want to delete?",
				"select what you want to delete or not?", JOptionPane.YES_NO_OPTION);
		if (input == 0) {
			session.delete(delleaveacc);
			JOptionPane.showMessageDialog(null, "Object is deleted!!!!...");
logger.info( leaveAcceptId+ " account deleted " + " and the time is " + new java.util.Date());
			
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
