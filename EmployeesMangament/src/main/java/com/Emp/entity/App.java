package com.Emp.entity;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Emp.daoimpl.Attendancesimpl;
import com.Emp.daoimpl.Managersimpl;
import com.Emp.daoimpl.employeesimpl;
import com.Emp.daoimpl.leaveacceptimpl;
import com.Emp.daoimpl.leaverequestimpl;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		employeesimpl employeeManagement = new employeesimpl();
		Managersimpl  employeeManagement1 = new Managersimpl();
		leaveacceptimpl employeeManagement2= new leaveacceptimpl();
		leaverequestimpl employeeManagement3 = new leaverequestimpl();
		Attendancesimpl employeeManagement4 = new Attendancesimpl();
		


		Leave_request leavereq = new Leave_request();
		Managers manager = new Managers();
		// manager.setManagerId(3);
		Employees employee = new Employees();
          
		System.out.print(" Enter the option 1 is add + "
				+ "employee option 2 update employee"+ 
				"option 3 view the employee" +
				"option 4  delete the  employee  " + 
				"  option 5 raise a leave request"+
				"option 6 accepted the leave request"+"option 7 view a status"+
				"option 8 mark a attendance"+"option 9 is view a attendance");

		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		sc.nextLine(); // Consume newline

		switch (input) {

		case 1:
			System.out.println("enter employee name");
			String input2 = sc.nextLine();
			employee.setName(input2);
			System.out.println("enter the manager id ");
			int input3 = sc.nextInt();

			manager.setManagerId(input3);
			employee.setManager(manager);
			System.out.println("enter the salary ");
			double input4 = sc.nextDouble();
			employee.setSalary(input4);
			sc.nextLine();
			System.out.println("enter the position");
			String input5 = sc.nextLine();
			employee.setPosition(input5);

			employeeManagement.createEmployee(employee);
			System.out.println("sucessfully created ");

			break;

		case 2:
			System.out.println("enter employee name");
			String input01 = sc.nextLine();
			employee.setName(input01);
			System.out.println("enter the manager id ");
			int input02 = sc.nextInt();

			manager.setManagerId(input02);
			employee.setManager(manager);
			System.out.println("enter the salary ");
			double input03 = sc.nextDouble();
			employee.setSalary(input03);
			sc.nextLine();
			System.out.println("enter the position");
			String input04 = sc.nextLine();
			employee.setPosition(input04);

			System.out.println("enter the employee id only no accepted  ");
			int input05 = sc.nextInt();

			employeeManagement.updateEmployee(input05, employee);

			System.out.println("sucessfully created ");
			break;

		case 3:

			System.out.println("enter the employee id ");
			int reademp = sc.nextInt();
			employeeManagement.readEmployee(reademp);
			break;

		case 4:
			System.out.println(" enter the employee id ");

			int empid = sc.nextInt();

			employeeManagement.deleteEmployee(empid);
			break;

		case 5:
			System.out.println("enter the employee id ");
			int empids = sc.nextInt();
			Employees employee5 = employeeManagement.readEmployee(empids);

			Leave_request leaveRequest = new Leave_request();
			leaveRequest.setEmployee(employee5);

			sc.nextLine();

			System.out.println(" enter the reason");
			String reason = sc.nextLine();
			leavereq.setReason(reason);

			System.out.println("Enter from date (format: dd-MM-yyyy): ");
			String inputDate = sc.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				Date date = dateFormat.parse(inputDate);

				// Leave_request leavereq = new Leave_request();
				leavereq.setDateFrom(date);

				// ... Set other attributes and perform further operations with leavereq
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
			}

			System.out.println("Enter the To date (format: dd-MM-yyyy): ");
			String inputDate2 = sc.nextLine();
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");

			try {
				Date date = dateFormat2.parse(inputDate2);

				// Leave_request leavereq = new Leave_request();
				leavereq.setDateTo(date);

				// ... Set other attributes and perform further operations with leavereq
			} catch (ParseException e) {
				System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
			}

			employeeManagement3.createLeaveRequest(leavereq);
			System.out.println("sucessfully created ");
			break;

		case 6:

			System.out.println("Enter the manager id ");
			int managerId = sc.nextInt();
			Managers managers = employeeManagement1.readManager(managerId);

			System.out.println("Enter the leave request id ");
			int leaveRequestId = sc.nextInt();
			Leave_request leaveReq = employeeManagement3.readLeaveRequest(leaveRequestId);

			Leave_accept leaveAccept = new Leave_accept();
			leaveAccept.setManager(managers);
			leaveAccept.setLeaveRequest(leaveReq);
			// System.out.println((leavereq.getEmployee()));
			System.out.println(leaveReq.getReason());

			sc.nextLine();

			System.out.println("Enter the status (Accepted/Rejected): ");
			String status = sc.nextLine();
			leaveAccept.setStatus(status);

			employeeManagement2.createLeaveAccept(leaveAccept);
			System.out.println("Leave request accepted/rejected successfully.");
			break;

		case 7:
			System.out.println("Enter the Leave Request ID: ");
		    int requestId = sc.nextInt();
		    Leave_accept leaveAccepts = employeeManagement2.readLeaveAccept(requestId);
		    if (leaveAccepts != null) {
		        System.out.println("Leave Accept Status: " + leaveAccepts.getStatus());
		    } else {
		        System.out.println("Leave accept not found.");
		    }
		    break;

		case 8:

			Attendances markatten = new Attendances();
			System.out.println("Enter the EmployeeID: ");
			int employeeId = sc.nextInt();

			Employees employeess = employeeManagement.readEmployee(employeeId);

			markatten.setEmployee(employeess);

			Date currentDate = new Date();
			markatten.setDate(currentDate);

			System.out.println("Enter the Time In (HH:mm:ss): ");
			String timeInStr = sc.next();
			markatten.setTimeIn(Time.valueOf(timeInStr));

			System.out.println("Enter the Time Out (HH:mm:ss): ");
			String timeOutStr = sc.next();
			markatten.setTimeOut(Time.valueOf(timeOutStr));

			employeeManagement4.markAttendance(markatten);
			System.out.println("Attendance marked successfully.");
			break;
		case 9:
			
			System.out.println("Enter the employee ID: ");
             int empId = sc.nextInt();
             List<Attendances> attendancesList = employeeManagement4.readAttendances(empId);
             for (Attendances att : attendancesList) {
                 System.out.println(att);
             }
             break;

         default:
             System.out.println("Invalid option.");
     }
			

	}
}

