package in.safal;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Db
{
    private static String driver="oracle.jdbc.OracleDriver";
    private static String url="jdbc:oracle:thin:@localhost";
    private static String username="payroll";
    private static String password="payroll";

    static{
       try{
          Class.forName(driver);
       }catch(Exception ex){
            System.err.println(ex);
       }
    }

    public static Connection getCn() throws Exception
     {
       return DriverManager.getConnection(url,username,password);
      }


      private PreparedStatement ps;

     //Constructor

     public Db(String sql) {
        try{
           ps=getCn().prepareStatement(sql);           
       }catch(Exception ex){
          System.err.println(ex);
       }
     }

      public PreparedStatement getPs() throws Exception
       {
            return ps;
        }
      public void execute() //insert/delete/update
       {
            try {
                ps.executeUpdate();
            }catch(Exception ex){
                System.err.println(ex);
            }finally{
               try{
                if(ps.getConnection()!=null)
                   ps.getConnection().close();
                }catch(Exception ex) {
                   System.err.println(ex);
                }
               try{
                if(ps!=null)
                   ps.close();
                }catch(Exception ex){
                   System.err.println(ex);
                }
           }
        }
    public Object scalar() //to fetch single value
       {
            ResultSet rs=null;
            Object s=null;
            try {
                rs=ps.executeQuery();
               
                if(rs.next())
                  {
                   s=rs.getObject(1);
                  }
            }catch(Exception ex){
                System.err.println(ex);
            }finally{
               try{
                  if(rs!=null)
                     rs.close();
               }catch(Exception ex) {
                  System.err.println(ex);
               }
               try{
                if(ps.getConnection()!=null)
                   ps.getConnection().close();
                }catch(Exception ex) {
                   System.err.println(ex);
                }
               try{
                if(ps!=null)
                   ps.close();
                }catch(Exception ex){
                   System.err.println(ex);
                }
           }
           return s;
        }

      public Object[] row() //to fetch single value
       {
            ResultSet rs=null;
            Object []s=null;
            try {
                rs=ps.executeQuery();
                int cols=rs.getMetaData().getColumnCount();

                if(rs.next())
                 {
                   s=new Object[cols];
                   for(int i=1;i<=cols;i++)
                   {
                	   Object c=rs.getObject(i);
                	   if(c==null)
                		   c="";
                       s[i-1]=c;
                   }
                  }
            }catch(Exception ex){
                System.err.println(ex);
            }finally{
               try{
                  if(rs!=null)
                     rs.close();
               }catch(Exception ex) {
                  System.err.println(ex);
               }
               try{
                if(ps.getConnection()!=null)
                   ps.getConnection().close();
                }catch(Exception ex) {
                   System.err.println(ex);
                }
               try{
                if(ps!=null)
                   ps.close();
                }catch(Exception ex){
                   System.err.println(ex);
                }
           }
           return s;
        }
      public List<Object[]> rows() //to rows
       {
            ResultSet rs=null;
            List<Object[]> list=new ArrayList<Object[]>();
            try {
                rs=ps.executeQuery();
                int cols=rs.getMetaData().getColumnCount();
                while(rs.next())
                 {
                   Object []s=new Object[cols];
                   for(int i=1;i<=cols;i++)
                   {
                	   Object c=rs.getObject(i);
                	   if(c==null)
                		   c="";
                       s[i-1]=c;
                   }

                   list.add(s);
                  }
            }catch(Exception ex){
                System.err.println(ex);
            }finally{
               try{
                  if(rs!=null)
                     rs.close();
               }catch(Exception ex) {
                  System.err.println(ex);
               }
               try{
                if(ps.getConnection()!=null)
                   ps.getConnection().close();
                }catch(Exception ex) {
                   System.err.println(ex);
                }
               try{
                if(ps!=null)
                   ps.close();
                }catch(Exception ex){
                   System.err.println(ex);
                }
           }
           return list;
        }

      //Sequences
     public static int newDeptCode()
       {
           Object c=new Db("select dept_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentDeptCode()
       {
           Object c=new Db("select dept_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       }  

   public static int newDgCode()
       {
           Object c=new Db("select designation_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentDgCode()
       {
           Object c=new Db("select designation_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       }  


   public static int newEmpCode()
       {
           Object c=new Db("select employee_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentEmpCode()
       {
           Object c=new Db("select employee_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       }  

   public static int newProfileCode()
       {
           Object c=new Db("select employee_profile_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentProfileCode()
       {
           Object c=new Db("select employee_profile_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       }  

   public static int newLoanCode()
       {
           Object c=new Db("select loan_master_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentLoanCode()
       {
           Object c=new Db("select loan_master_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       }  

   public static int newLoanTranCode()
       {
           Object c=new Db("select loan_tran_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentLoanTranCode()
       {
           Object c=new Db("select loan_tran_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       }  

      
   public static int newAttCode()
       {
           Object c=new Db("select attendance_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentAttCode()
       {
           Object c=new Db("select attendance_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 

   public static int newSalaryId()
       {
           Object c=new Db("select salary_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentSalaryId()
       {
           Object c=new Db("select salary_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 

   public static int newExpId()
       {
           Object c=new Db("select experience_seq.nextval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 
    public static int currentExpId()
       {
           Object c=new Db("select experience_seq.currval from dual").scalar();
           return Integer.parseInt(c.toString()); 
       } 

 

 }