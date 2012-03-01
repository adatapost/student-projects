package in.safal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{
   public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                           throws IOException,ServletException
    {
     request.getRequestDispatcher("/login.jsp")
            .forward(request,response);
    }

   public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
                           throws IOException, ServletException
   {
         String cmd=request.getParameter("cmd");
         String file="/login.jsp"; 
         if(cmd.equals("Login"))
           {
             String username=request.getParameter("username");
             String password=request.getParameter("password");
             Login log=new Login(username,password);

             if(log.validLogin())
                {
                   file="/admin/index.jsp";
                 }
            }
          request.getRequestDispatcher(file)
                 .forward(request,response);
   }
 
}