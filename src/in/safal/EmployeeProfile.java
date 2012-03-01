package in.safal;

 
import java.util.List;
import java.util.ArrayList;

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

public class EmployeeProfile
 {
     private int profileCode=0;
     private int empCode=0;
     private int dgCode=0;
     private int deptCode=0;
     private String startDate="";
     private String endDate="";
     private int basicSalary=0;

    public EmployeeProfile() {}

 
    public EmployeeProfile(int profileCode)
    {
      this.profileCode=profileCode;
    }
 
    public EmployeeProfile(int profileCode,
                         int empCode,
                         int dgCode,
                         int deptCode,
                         String startDate,
                         String endDate,
                         int basicSalary)
    {
     this.profileCode=profileCode;
     this.empCode=empCode;
     this.dgCode=dgCode;
     this.deptCode=deptCode;
     this.startDate=startDate;
     this.endDate=endDate;
     this.basicSalary=basicSalary;  
     }

    public void setprofileCode(int profileCode)
    {
      this.profileCode=profileCode;
    }

    public int getprofileCode()
    {
     return profileCode;
     }
 
    public void setempCode(int empCode)
    {
      this.empCode=empCode;
    }
    public int getempCode()
    {
     return empCode;
    }
 
    public void setdgCode(int dgCode)
    {

      this.dgCode=dgCode;
     }
 
     public int getdgCode()
     {
      return dgCode;
     } 
 
     public void setdeptCode(int deptCode)
     {
       this.deptCode=deptCode;
     }

     public int getdeptCode()
     {
       return deptCode;
     }
      
  
     public void setstartDate(String startDate)
     {
       this.startDate=startDate;
     }

     public String getstartDate()
     {
       return startDate;
     }

     public void setendDate(String endDate)
     {
       this.endDate=endDate;
     }

     public String getendDate()
     {
       return endDate;
     }
     
     public void setbasicSalary(int basicSalary)      
     {
      this.basicSalary=basicSalary;
     }

     public int getbasicSalary()
     {
      return basicSalary;
     }

    public String toString()
    {
      return "EmployeeProfile [profileCode=" + profileCode + ", empCode=" + empCode + ", dgCode=" + dgCode 
                            + ",deptCode=" + deptCode + ", startDate=" + startDate + ", endDate=" + endDate +", basicSalary=" + basicSalary + "]";

    }

 



   //Database logic

        public boolean addEmployeeProfile()
         {
            try{
               
              
              profileCode =Db.newProfileCode();     
             
              Db x=new Db("insert into employee_profile values (?,?,?,?,?,?,?)");
              x.getPs().setInt(1,profileCode);
              x.getPs().setInt(2,empCode);
              x.getPs().setInt(3,dgCode);
              x.getPs().setInt(4,deptCode);
              x.getPs().setString(5,startDate);  
              x.getPs().setString(6,endDate);
              x.getPs().setInt(7,basicSalary);
             
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }


       public boolean updateEmployeeProfile()
         {
            try{
              Db x=new Db("update employee_profile set emp_code=?,dg_code=?,dept_code=?,start_date=?,end_date=?,basic_salary=? where profile_code=?");
               
              x.getPs().setInt(1,empCode);
              x.getPs().setInt(2,dgCode);
              x.getPs().setInt(3,deptCode);
              x.getPs().setString(4,startDate);  
              x.getPs().setString(5,endDate);
              x.getPs().setInt(6,basicSalary);
              x.getPs().setInt(7,profileCode);
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

      public boolean deleteEmployeeProfile()
         {
            try{
              Db x=new Db("delete from employee_profile where profile_code=?");
              x.getPs().setInt(1,profileCode);
              x.execute();
              return true;
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public boolean fetchEmployeeProfile()
         {
            try{
              Db x=new Db("select * from employee_profile where profile_code=?");
              x.getPs().setInt(1,profileCode);

              Object []r=x.row();
              if(r!=null) 
               {   
                 profileCode=Integer.parseInt(r[0].toString());
                 empCode=Integer.parseInt(r[1].toString()); 
                 dgCode=Integer.parseInt(r[2].toString()); 
                 deptCode=Integer.parseInt(r[3].toString()); 
                 startDate=r[4].toString();
                 endDate=r[5].toString();
                 basicSalary=Integer.parseInt(r[6].toString());

  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<EmployeeProfile> getEmployeeProfile()
       {
          List<EmployeeProfile> list=new ArrayList<EmployeeProfile>();
          try{
             Db x=new Db("select * from employee_profile");
             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    EmployeeProfile Empprofile=new EmployeeProfile();
 
                    Empprofile.setprofileCode(Integer.parseInt(r[0].toString()));
                    Empprofile.setempCode(Integer.parseInt(r[1].toString())); 
                    Empprofile.setdgCode(Integer.parseInt(r[2].toString()));
                    Empprofile.setdeptCode(Integer.parseInt(r[3].toString())); 
                    Empprofile.setstartDate(r[4].toString());
                    Empprofile.setendDate(r[5].toString());
                    Empprofile.setbasicSalary(Integer.parseInt(r[6].toString()));
                    
                    
                    list.add(Empprofile);
                 }
          }catch(Exception ex){
               System.err.println(ex);
          } 
          return list; 
       }

  }
  
                             
                           