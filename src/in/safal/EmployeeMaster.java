package in.safal;

import java.util.List;
import java.util.ArrayList;


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

public class EmployeeMaster

{

   private int empCode=0;
   private String cmpCode="";
   private String firstName="";
   private String middleName="";
   private String lastName="";
   private String address="";
   private String city ="";
   private String state="";
   private String pin="";
   private String phone="";
   private int dgCode=0;
   private int deptCode=0;
   private String joinDate="";
   private String birthDate="";
   private String  bankCode="";
   private String  bankAccount="";
   private String pfNo="";
   private String email="";





    
   public EmployeeMaster() {}
   
   public EmployeeMaster(int empCode)
   {
      this.empCode=empCode;
   }

   public EmployeeMaster(int empCode,
                     String cmpCode,
		     String firstName,
 		     String middleName,
                     String lastName,
                     String address,
                     String city,
                     String state,
                     String pin,
                     String phone,
                     int dgCode,
                     int deptCode,
                     String joinDate,
                     String birthDate,
                     String bankCode,
                     String bankAccount,
                     String  pfNo,
                     String email)
   {
     this.empCode=empCode;
     this.cmpCode=cmpCode;
     this.firstName=firstName;
     this.middleName=middleName;
     this.lastName=lastName;
     this.address=address;
     this.city=city;
     this.pin=pin;
     this.phone=phone;
    this.dgCode=dgCode;
    this.deptCode=deptCode;
    this.joinDate=joinDate;
    this.birthDate=birthDate;
     this.bankCode=bankCode;
    this.bankAccount=bankAccount;
    this.pfNo=pfNo;
    this.email=email;
   
  
 
 
    }
   
    //getter/setter
  
    public void setEmpCode(int empCode)
    {
      this.empCode=empCode;  
    }

    public int getEmpCode()
    {
      return empCode;
     }

    public void  setCmpCode(String cmpCode)
    {
       this.cmpCode=cmpCode;
    }
 
    public String getCmpCode()
    {
     return cmpCode;
    }
    
   public void setFirstName(String firstName)
   {
     this.firstName=firstName;
   }

   public String getFirstName()
   {

     return firstName;
   }
   
   public void setMiddleName(String middleName)
   {
     this.middleName=middleName;
   }

   public String getMiddleName()
   {

     return middleName;
   }

   public void setLastName(String lastName)
   {
     this.lastName=lastName;
   }

   public String getLastName()
   {

     return lastName;
   }

    public void setAddress(String address)
   {
     this.address=address;
   }

   public String getAddress()
   {

     return address;
   }

    public void setCity(String city)
   {
     this.city=city;
   }

   public String getCity()
   {

     return city;
   }


    public void setState(String state)
   {
     this.state=state;
   }

   public String getState()
   {

     return state;
   }


   public void setPin(String pin)
   {
     this.pin=pin;
   }

   public String getPin()
   {

     return pin;
   }
   public void setPhone(String phone)
   {
     this.phone=phone;
   }

   public String getPhone()
   {

     return phone;
   }
  
   public void setDgCode(int dgCode)
    {
     this.dgCode=dgCode;
    }

    public int getDgCode()
    {

      return dgCode;
    }

    
   public void setDeptCode(int deptCode)
    {
     this.deptCode=deptCode;
    }

    public int getDeptCode()
    {

      return deptCode;
    }

   
    public void setJoinDate(String joinDate)
     {
        this.joinDate=joinDate;
     }
       public String getJoinDate()
      {
         return joinDate;
      }

     public void setBirthDate(String birthDate)
     {
        this.birthDate=birthDate;
     }
       public String getBirthDate()
      {
         return birthDate;
      }

       public void setBankCode(String bankCode)
     {
        this.bankCode=bankCode;
     }
 
       public String getBankCode()
      {
         return bankCode;
      }


      public void setBankAccount(String bankAccount)
     {
        this.bankAccount=bankAccount;
     }
       public String getBankAccount()
      {
         return bankAccount;
      }


     public void setPfNo(String pfNo)
     {
        this.pfNo=pfNo;
     }
       public String getPfNo()
      {
         return pfNo;
      }

     public void setEmail(String email)
     {
        this.email=email;
     }
       public String getEmail()
      {
         return email;
      }

  
     public String toString()
     {
       return "EmployeeMaster [empCode=" + empCode + ", cmpCode=" + cmpCode
			+ ", firstName=" + firstName + ", middleName=" + middleName
                        + ", lastName=" + lastName + ", address=" + address
                        + ", city=" + city + ", pin=" + pin +",phone=" + phone
                        + ", dgCode=" + dgCode + ", deptCode=" + deptCode  
                        + ", joinDate=" + joinDate + ", birthDate=" + birthDate  
			+ ", bankCode=" + bankCode + ", bankAccount=" + bankAccount + ", pfNo=" + pfNo+ ", email=" + email +"]";
     }   

     

   //Database logic

        public boolean addEmp()
         {
            try{
              empCode =Db.newEmpCode();     
              Db x=new Db("insert into employee values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              x.getPs().setInt(1,empCode);
              x.getPs().setString(2,cmpCode);
              x.getPs().setString(3,firstName);
              x.getPs().setString(4,middleName);
              x.getPs().setString(5,lastName);
              x.getPs().setString(6,address);
              x.getPs().setString(7,city);
              x.getPs().setString(8,state);
              x.getPs().setString(9,pin);
              x.getPs().setString(10,phone);
              x.getPs().setInt(11,dgCode);
              x.getPs().setInt(12,deptCode);
              x.getPs().setString(13,joinDate);
              x.getPs().setString(14,birthDate);
              x.getPs().setString(15,bankCode);
              x.getPs().setString(16,bankAccount);
              x.getPs().setString(17,pfNo);
              x.getPs().setString(18,email);
    
              x.execute();
              return true;

            }
              catch(Exception ex)
             {
               System.err.println(ex);
             }
              return false;
          }


       public boolean updateEmp()
         {
            try{
              Db x=new Db("update employee set cmp_code=?,first_name=?,middle_name=?,last_name=?,address=?,city=?,state=?,pin=?,phone=?,dg_code=?,dept_code=?,join_date=?,birth_date=?,bank_code=?,bank_account=?,pf_no=?,email=? where emp_code=?");
              
              x.getPs().setString(1,cmpCode);
              x.getPs().setString(2,firstName);
              x.getPs().setString(3,middleName);
              x.getPs().setString(4,lastName);
              x.getPs().setString(5,address);
              x.getPs().setString(6,city);
              x.getPs().setString(7,state);
              x.getPs().setString(8,pin);
              x.getPs().setString(9,phone);
              x.getPs().setInt(10,dgCode);
              x.getPs().setInt(11,deptCode);
              x.getPs().setString(12,joinDate);
              x.getPs().setString(13,birthDate);
              x.getPs().setString(14,bankCode);
              x.getPs().setString(15,bankAccount);
              x.getPs().setString(16,pfNo);
              x.getPs().setString(17,email);
              x.getPs().setInt(18,empCode);
 
              x.execute();
              return true;

            }
              catch(Exception ex)
             {
               System.err.println(ex);
             }
              return false;
          }

      public boolean deleteEmp()
         {
            try{
              Db x=new Db("delete from employee where emp_code=?");
              x.getPs().setInt(1,empCode);
              x.execute();
              return true;
 
              }
              catch(Exception ex)
              {
               System.err.println(ex);
              }
               return false;
          }

     public boolean fetchEmp()
         {
            try{
              Db x=new Db("select * from employee where emp_code=?");
              x.getPs().setInt(1,empCode);

              Object []r=x.row();
              if(r!=null) 
               {   
                 empCode=Integer.parseInt(r[0].toString());
                 cmpCode=r[1].toString();
                 firstName=r[2].toString();
                 middleName=r[3].toString();
                 lastName=r[4].toString();
                 address=r[5].toString();
                 city=r[6].toString();
                 state=r[7].toString();
                 pin=r[8].toString();
                 phone=r[9].toString();
                 dgCode=Integer.parseInt(r[10].toString());
                 deptCode=Integer.parseInt(r[11].toString());
                 joinDate=r[12].toString();
                 birthDate=r[13].toString();
                 bankCode=r[14].toString();
                 bankAccount=r[15].toString();
                 pfNo=r[16].toString();
                 email=r[17].toString();
  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<EmployeeMaster> getEmp()
       {
         List<EmployeeMaster> list=new ArrayList<EmployeeMaster>();
         
          try{
             Db x=new Db("select * from employee");

             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    EmployeeMaster emp=new EmployeeMaster();
 
                    emp.setEmpCode(Integer.parseInt(r[0].toString()));
                    emp.setCmpCode(r[1].toString());
                    emp.setFirstName(r[2].toString());
                    emp.setMiddleName(r[3].toString());
                    emp.setLastName(r[4].toString());
                    emp.setAddress(r[5].toString());
                    emp.setCity(r[6].toString());
                    emp.setState(r[7].toString());
                    emp.setPin(r[8].toString());
                    emp.setPhone(r[9].toString());
                    emp.setDgCode(Integer.parseInt(r[10].toString()));
                    emp.setDeptCode(Integer.parseInt(r[11].toString()));  
                    emp.setJoinDate(r[12].toString());
                    emp.setBirthDate(r[13].toString());
                    emp.setBankCode(r[14].toString());
                    emp.setBankAccount(r[15].toString());
                    emp.setPfNo(r[16].toString());
                    emp.setEmail(r[17].toString());      
                    list.add(emp);
                 }
          }
             catch(Exception ex)
             {
               System.err.println(ex);
             } 
              return list; 
       }

   }
                             