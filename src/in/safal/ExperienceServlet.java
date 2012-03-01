package in.safal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*

create table experience
(
  exp_id number(5) primary key,
  emp_code number(5) references employee(emp_code),
  cmp_name varchar2(50),
  from_date date,
  to_date date,
  desig varchar2(15)
)

*/

public class ExperienceServlet extends HttpServlet
 
{
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
     request.setAttribute("Exper",in.safal.ExperienceMaster.getExperience());
     request.getRequestDispatcher("/admin/experience.jsp")
                                 .forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {

       String cmd=request.getParameter("cmd");
       String file="/admin/experience.jsp";
    if(cmd.equals("Save"))
       {
           in.safal.ExperienceMaster Exper =new in.safal.ExperienceMaster();
           Exper.setexpid(Integer.parseInt(request.getParameter("expid")));
           Exper.setempCode(Integer.parseInt(request.getParameter("empCode")));
           Exper.setcmpname(request.getParameter("cmpname"));
           Exper.setfromdate(request.getParameter("fromdate"));
           Exper.settodate(request.getParameter("todate"));
           Exper.setdesig(request.getParameter("desig"));
           Exper.addExper();
          
       }

     else
   if(cmd.equals("Select"))
       {
         in.safal.ExperienceMaster Exper =new in.safal.ExperienceMaster();
         Exper.setexpid(Integer.parseInt(request.getParameter("expid")));
         Exper.fetchExper();   
         request.setAttribute("single",Exper);
       }
      else
      if(cmd.equals("Delete"))
       {
 
       }
     else
     if(cmd.equals("Update"))
       {
 
               
       }
       
          request.setAttribute("Exper",in.safal.ExperienceMaster.getExperience());
           request.getRequestDispatcher(file)  
                        .forward(request,response);
    
    }
 }
      
