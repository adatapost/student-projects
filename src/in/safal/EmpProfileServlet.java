package in.safal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


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



public class EmpProfileServlet extends HttpServlet
 
{
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
     request.setAttribute("Empprofile",in.safal.EmployeeProfile.getEmployeeProfile());
     request.getRequestDispatcher("/admin/employeeprofile.jsp")
                                 .forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {
       
       String cmd=request.getParameter("cmd");
       String file="/admin/employeeprofile.jsp";
    if(cmd.equals("Save"))
       {
           in.safal.EmployeeProfile Empprofile =new in.safal.EmployeeProfile();
           Empprofile.setprofileCode(Integer.parseInt(request.getParameter("profileCode")));
           Empprofile.setempCode(Integer.parseInt(request.getParameter("empCode")));
           Empprofile.setdgCode(Integer.parseInt(request.getParameter("dgCode")));
           Empprofile.setdeptCode(Integer.parseInt(request.getParameter("deptCode")));
           Empprofile.setstartDate(request.getParameter("startDate"));
           Empprofile.setendDate(request.getParameter("endDate"));
           Empprofile.setbasicSalary(Integer.parseInt(request.getParameter("basicSalary")));
           Empprofile.addEmployeeProfile();
          
       }

     else
   if(cmd.equals("Select"))
       {
         in.safal.EmployeeProfile Empprofile =new in.safal.EmployeeProfile();
         Empprofile.setprofileCode(Integer.parseInt(request.getParameter("profileCode")));
         Empprofile.fetchEmployeeProfile();   
         request.setAttribute("single",Empprofile);
       }
      else
      if(cmd.equals("Delete"))
       {
 
       }
     else
     if(cmd.equals("Update"))
       {
 
               
       }
       
          request.setAttribute("Empprofile",in.safal.EmployeeProfile.getEmployeeProfile());
           request.getRequestDispatcher(file)  
                        .forward(request,response);
    
    }
 }