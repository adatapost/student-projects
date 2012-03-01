package in.safal;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/*
 create table bank_master
 (
 bank_code varchar2(5) primary key,
 bank_name varchar2(50) not null,
 bank_address varchar2(200) not null,
 bank_city varchar2(20),
 bank_phone varchar2(20),
 bank_branch varchar2(40)
 )

 */
public class BankMasterServlet extends HttpServlet

{
   public void doGet(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
   {
     request.setAttribute("bank",in.safal.BankMaster.getBankMasters());
     request.getRequestDispatcher("/admin/bankmaster.jsp")
                                 .forward(request,response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                       throws IOException ,ServletException
     {
       
       String cmd=request.getParameter("cmd");
       String file="/admin/bankmaster.jsp";
       if(cmd.equals("Save"))
       {
             in.safal.BankMaster b=new in.safal.BankMaster();
             b.setBankCode(request.getParameter("bankCode"));
             b.setBankName(request.getParameter("bankName"));
             b.setBankAddress(request.getParameter("bankAddress"));
             b.setBankCity(request.getParameter("bankCity"));
             b.setBankPhone(request.getParameter("bankPhone"));
             b.setBankBranch(request.getParameter("bankBranch"));
             b.addBankMaster();
        }

        else
        if(cmd.equals("Select"))
           {
              in.safal.BankMaster b=new in.safal.BankMaster();
              b.setBankCode(request.getParameter("bankCode"));
              b.fetchBankMaster();
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

            request.setAttribute("bank",in.safal.BankMaster.getBankMasters());
            request.getRequestDispatcher(file)  
                        .forward(request,response);
       }
 }
