package in.safal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*

create table employee
(
   emp_code number(5) primary key,
   cmp_code varchar2(5) references company_master(cmp_code),
   first_name varchar2(20),
   middle_name varchar2(20),
   last_name varchar2(20),
   address varchar2(200),
   city varchar2(30),
   state varchar2(20),
   pin varchar2(6),
   phone varchar2(20),
   dg_code number(2) references designation(dg_code),
   dept_code number(2) references dept(dept_code),
   join_date date,
   birth_date date,
   bank_code varchar2(5) references bank_master(bank_code),
   bank_account varchar2(15),
   pf_no varchar2(10),
   email varchar2(50)
)
*/


public class EmployeeServlet extends HttpServlet
 
{
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
       request.setAttribute("emp",in.safal.EmployeeMaster.getEmp());
       request.setAttribute("bank",in.safal.BankMaster.getBankMasters());
request.setAttribute("desig",in.safal.Designation.getDesigs());   
request.setAttribute("dept",in.safal.Dept.getDepts());
request.setAttribute("cmp",in.safal.CompanyMaster.getCompanyMasters());

     request.getRequestDispatcher("/admin/employee.jsp")
                                 .forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {
       
       String cmd=request.getParameter("cmd");
       String file="/admin/employee.jsp";
       if(cmd.equals("Save"))
       {
           in.safal.EmployeeMaster emp =new in.safal.EmployeeMaster();
           
           emp.setCmpCode(request.getParameter("cmpCode"));
           emp.setFirstName(request.getParameter("firstName"));
           emp.setMiddleName(request.getParameter("middleName"));
           emp.setLastName(request.getParameter("lastName"));  
           emp.setAddress(request.getParameter("address"));
           emp.setCity(request.getParameter("city"));
           emp.setState(request.getParameter("state"));
           emp.setPin(request.getParameter("pin"));
           emp.setPhone(request.getParameter("phone")); 
           emp.setDgCode(Integer.parseInt(request.getParameter("dgCode")));
           emp.setDeptCode(Integer.parseInt(request.getParameter("deptCode")));

           String birthDate=request.getParameter("bday") + "-" + request.getParameter("bmon") + "-" + request.getParameter("byear");


           String joinDate=request.getParameter("jday") + "-" + request.getParameter("jmon") + "-" + request.getParameter("jyear");


           emp.setJoinDate(joinDate);
            emp.setBirthDate(birthDate);


           emp.setBankCode(request.getParameter("bankCode"));
           emp.setBankAccount(request.getParameter("bankAccount"));
           emp.setPfNo(request.getParameter("pfNo"));
           emp.setEmail(request.getParameter("email"));
           emp.addEmp();   
        }
        
        else
    if(cmd.equals("Select"))
       {
         in.safal.EmployeeMaster emp =new in.safal.EmployeeMaster();
         emp.setEmpCode(Integer.parseInt(request.getParameter("empCode")));
         emp.fetchEmp();   
         request.setAttribute("single",emp);
       }
      else
      if(cmd.equals("Delete"))
       {
    	  in.safal.EmployeeMaster emp =new in.safal.EmployeeMaster();
          emp.setEmpCode(Integer.parseInt(request.getParameter("empCode")));
          emp.deleteEmp(); 
       }
     else
     if(cmd.equals("Update"))
       {
    	 in.safal.EmployeeMaster emp =new in.safal.EmployeeMaster();
         emp.setEmpCode(Integer.parseInt(request.getParameter("empCode")));
         
    	 emp.setCmpCode(request.getParameter("cmpCode"));
         emp.setFirstName(request.getParameter("firstName"));
         emp.setMiddleName(request.getParameter("middleName"));
         emp.setLastName(request.getParameter("lastName"));  
         emp.setAddress(request.getParameter("address"));
         emp.setCity(request.getParameter("city"));
         emp.setState(request.getParameter("state"));
         emp.setPin(request.getParameter("pin"));
         emp.setPhone(request.getParameter("phone")); 
         emp.setDgCode(Integer.parseInt(request.getParameter("dgCode")));
         emp.setDeptCode(Integer.parseInt(request.getParameter("deptCode")));

         String birthDate=request.getParameter("bday") + "-" + request.getParameter("bmon") + "-" + request.getParameter("byear");

         String joinDate=request.getParameter("jday") + "-" + request.getParameter("jmon") + "-" + request.getParameter("jyear");
         emp.setJoinDate(joinDate);
         emp.setBirthDate(birthDate);

         emp.setBankCode(request.getParameter("bankCode"));
         emp.setBankAccount(request.getParameter("bankAccount"));
         emp.setPfNo(request.getParameter("pfNo"));
         emp.setEmail(request.getParameter("email"));
         emp.updateEmp();    
       }
      
       request.setAttribute("emp",in.safal.EmployeeMaster.getEmp());
       request.setAttribute("bank",in.safal.BankMaster.getBankMasters());
request.setAttribute("desig",in.safal.Designation.getDesigs());   
request.setAttribute("dept",in.safal.Dept.getDepts());
request.setAttribute("cmp",in.safal.CompanyMaster.getCompanyMasters());

           request.getRequestDispatcher(file)  
                        .forward(request,response);
       }
 }