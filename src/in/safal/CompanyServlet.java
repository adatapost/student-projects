package in.safal;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*

 create table company_master
 (
 cmp_code varchar2(5) primary key,
 cmp_name varchar2(100),
 cmp_address varchar2(200),
 cmp_city varchar2(30),
 cmp_state varchar2(20),
 cmp_pin varchar2(6)
 )
 */

public class CompanyServlet extends HttpServlet

{
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
     request.setAttribute("company",in.safal.CompanyMaster.getCompanyMasters());
     request.getRequestDispatcher("/admin/companymaster.jsp")
                                 .forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {
       
       String cmd=request.getParameter("cmd");
       String file="/admin/companymaster.jsp";
       if(cmd.equals("Save"))
       {
             in.safal.CompanyMaster b=new in.safal.CompanyMaster();
              b.setCmpCode(request.getParameter("cmpCode"));
              b.setCmpName(request.getParameter("cmpName"));
              b.setCmpAddress(request.getParameter("cmpAddress"));
              b.setCmpCity(request.getParameter("cmpCity"));
              b.setCmpState(request.getParameter("cmpState"));
              b.setCmpPin(request.getParameter("cmpPin"));
              b.addCompanyMaster();
        }

        else
        if(cmd.equals("Select"))
           {
              in.safal.CompanyMaster b=new in.safal.CompanyMaster();
              b.setCmpCode(request.getParameter("cmpCode"));
              b.fetchCompanyMaster();
              request.setAttribute("single",b);
             }
        else
        if(cmd.equals("Delete"))
           {
 
             }
       else
            if(cmd.equals("Update"))
              {
 
               
              }

            request.setAttribute("bank",in.safal.CompanyMaster.getCompanyMasters());
            request.getRequestDispatcher(file)  
                        .forward(request,response);
       }
 }
