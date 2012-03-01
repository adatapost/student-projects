package in.safal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
create table employee_profile
(
   profile_code  number(7) primary key,
   emp_code number(5) references employee(emp_code),
   dg_code number(2) references designation(dg_code),
   dept_code number(2) references dept(dept_code),
   start_date date,
   end_date date,
   basic_salary number(15,2) 
)

*/
public class EmployeeProfileServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       request.setAttribute("emp",in.safal.EmployeeMaster.getEmp());
	       request.setAttribute("desig",in.safal.Designation.getDesigs());   
	       request.setAttribute("dept",in.safal.Dept.getDepts());
	       request.setAttribute("profile",in.safal.EmployeeProfile.getEmployeeProfile());
	       request.getRequestDispatcher("/admin/profile.jsp")
	                                 .forward(request,response);
	  
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	       request.setAttribute("emp",in.safal.EmployeeMaster.getEmp());
	       request.setAttribute("desig",in.safal.Designation.getDesigs());   
	       request.setAttribute("dept",in.safal.Dept.getDepts());
	       request.setAttribute("profile",in.safal.EmployeeProfile.getEmployeeProfile());
	       request.getRequestDispatcher("/admin/profile.jsp")
	                                 .forward(request,response);

	}

}
