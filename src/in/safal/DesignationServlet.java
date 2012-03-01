package in.safal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*  create table designation
 (
 dg_code number(2) primary key,
 dg_name varchar2(30)
 )
  
 */

public class DesignationServlet extends HttpServlet

{
   @Override
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
     
     request.setAttribute("desig",Designation.getDesigs());
     request.getRequestDispatcher("/admin/designation.jsp")
                                 .forward(request,response);
    }


    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {
       
       String cmd=request.getParameter("cmd");
       String file="/admin/designation.jsp";
       if(cmd.equals("Save"))
       {
           String DgName=request.getParameter("dgName");
           Designation d=new Designation(0,DgName); 

            if(d.addDesignation())  
              {
                file="/admin/designation.jsp";
               }
        }
        else
        if(cmd.equals("Select"))
           {
              int dgCode=Integer.parseInt(request.getParameter("dgCode"));
              Designation d=new Designation(dgCode);
              d.fetchDesignation();
              request.setAttribute("single",d);
             }
        else
        if(cmd.equals("Delete"))
           {
              int dgCode=Integer.parseInt(request.getParameter("dgCode"));
              Designation d=new Designation(dgCode);
              d.deleteDesignation();
               
             }
       else
        if(cmd.equals("Update"))
           {
              int dgCode=Integer.parseInt(request.getParameter("dgCode"));
String dgName=request.getParameter("dgName");
              Designation d=new Designation(dgCode,dgName);
              d.updateDesignation();
               
             }
        request.setAttribute("desig",Designation.getDesigs());
        request.getRequestDispatcher(file)  
                      .forward(request,response);
       }
   

 }



       
     