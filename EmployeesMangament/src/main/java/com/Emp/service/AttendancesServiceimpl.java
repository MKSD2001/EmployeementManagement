package com.Emp.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Emp.entity.Helper;
import com.Emp.model.AttendancesDTO;

public class AttendancesServiceimpl implements AttendancesService{
	
	
	private static final org.jboss.logging.Logger logger = org.jboss.logging.Logger
			.getLogger(AttendancesServiceimpl.class);
	// attendances
		@Override
		public AttendancesDTO markAttendance(AttendancesDTO attendance) {
			
			try(Session session = Helper.getSession()){
				// creating a new Account object
							session.beginTransaction();
							session.save(attendance);
							// java object saved to the database
							session.getTransaction().commit();
							session.clear();

				logger.info("new account created " + attendance.toString() + " and creation time is " + new java.util.Date());

							return attendance;
							
						} catch (HibernateException h) {
							System.out.println("The hibernate error is " + h);
							logger.error("exception happened " + h.toString() + " and error creation time is " + new java.util.Date());
						} catch (Exception e) {
							System.out.println("the error is " + e);

						}
						return null;
				
				
			}
		
		@Override
		public List<AttendancesDTO> readAttendances(int employeeId) {
		    try (Session session = Helper.getSession()) {
		        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		        CriteriaQuery<AttendancesDTO> criteriaQuery = criteriaBuilder.createQuery(AttendancesDTO.class);
		        Root<AttendancesDTO> root = criteriaQuery.from(AttendancesDTO.class);

		        criteriaQuery.select(root)
		            .where(criteriaBuilder.equal(root.get("employee").get("employeeId"), employeeId));

		        List<AttendancesDTO> attendancesList =  session.createQuery(criteriaQuery).getResultList();

		        for (AttendancesDTO att : attendancesList) {
		            logger.info("Attendance details read: " + att.toString() + " and time is " + new java.util.Date());
		        }

		        return attendancesList;
		    } catch (HibernateException h) {
		        System.out.println("The error is " + h);
		        logger.error("Exception happened: " + h.toString() + " and error creation time is " + new java.util.Date());
		    } catch (Exception e) {
		        System.out.println("The general error is " + e);
		    }
		    return Collections.emptyList(); // Return an empty list instead of null

}
		
	
}
