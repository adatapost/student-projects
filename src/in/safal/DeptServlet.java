package in.safal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 create table dept
 (
 dept_code number(2) primary key,
 dept_name varchar2(30)
 )
 */

public class DeptServlet extends HttpServlet

{
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
     request.setAttribute("dept",in.safal.Dept.getDepts());
     request.getRequestDispatcher("/admin/departement.jsp")
                                 .forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {
       
       String cmd=request.getParameter("cmd");
       String file="/admin/departement.jsp";
       if(cmd.equals("Save"))
       {
           
           String DeptName=request.getParameter("deptName");
           Dept d=new Dept(0,DeptName); 

            if(d.addDept())  
              {
                file="/admin/departement.jsp";
               }
            
           }
        else
        if(cmd.equals("Select"))
           {
              int deptCode=Integer.parseInt(request.getParameter("deptCode"));
              Dept d=new Dept(deptCode);
              d.fetchDept();
              request.setAttribute("single",d);
             }
        else
        if(cmd.equals("Delete"))
           {
              int deptCode=Integer.parseInt(request.getParameter("deptCode"));
              Dept d=new Dept(deptCode);
              d.deleteDept();
               
             }
       else
            if(cmd.equals("Update"))
              {
               int deptCode=Integer.parseInt(request.getParameter("deptCode"));
               String deptName=request.getParameter("deptName");
               Dept d=new Dept(deptCode,deptName);
               d.updateDept();
               
              }

            request.setAttribute("dept",in.safal.Dept.getDepts());
            request.getRequestDispatcher(file)  
                        .forward(request,response);
       }
 }



       
     