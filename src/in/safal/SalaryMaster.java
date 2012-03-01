package in.safal;
 
import java.util.List;
import java.util.ArrayList;

/*
create table salary
(
  salaryid number(10) primary key,
  salarydate date,
  profile_code number(7) references employee_profile(profile_code),
  da number(15),
  hra number(15),
  ma number(15),
  ptax number(15),
  leave_dedu number(15),
  overtime number(15),
  pf_amount number(15),
  other_allow number(15),
  other_dedu number(15)
)
*/

public class SalaryMaster
 {
     private int salaryid=0;
     private String salarydate="";
     private int  profileCode=0;
     private int da=0;
     private int  hra=0;
     private int ma=0;
     private int ptax=0;
     private int leaveDedu=0;
     private int overtime=0;
     private int pfAmount=0;
     private int otherAllow=0;
     private int otherDedu=0;

    public SalaryMaster() {}

 
    public SalaryMaster(int salaryid)
    {
      this.salaryid=salaryid;
    }
 
    public SalaryMaster(int salaryid,
                         String salarydate,
                         int profileCode,
                         int da,
                         int hra,
                         int ma,
                         int ptax,
                         int leaveDedu,
                         int overtime,
                         int pfAmount,
                         int otherAllow,
                         int otherDedu)
    {
     this.salaryid=salaryid;
     this.salarydate=salarydate;
     this.profileCode=profileCode;
     this.da=da;
     this.hra=hra;
     this.ma=ma;
     this.ptax=ptax;
     this.leaveDedu=leaveDedu;
     this.overtime=overtime;   
     this.pfAmount=pfAmount;
     this.otherAllow=otherAllow;
     this.otherDedu=otherDedu;  
     }

    public void setsalaryid(int salaryid)
    {
      this.salaryid=salaryid;
    }

    public int getsalaryid()
    {
     return salaryid;
     }
 
    public void setsalarydate(String salarydate)
    {
      this.salarydate=salarydate;
    }
    public String getsalarydate()
    {
     return salarydate;
    }
 
    public void setprofileCode(int profileCode)
    {

      this.profileCode=profileCode;
     }
 
     public int getprofileCode()
     {
      return profileCode;
     } 
 
     public void setda(int da)
     {
       this.da=da;
     }

     public int getda()
     {
       return da;
     }
      
  
       public void sethra(int hra)
     {
       this.hra=hra;
     }

     public int gethra()
     {
       return hra;
     }
      
  

      public void setma(int ma)
     {
       this.ma=ma;
     }

     public int getma()
     {
       return ma;
     }
      
  
    public void setptax(int ptax)
     {
       this.ptax=ptax;
     }

     public int getptax()
     {
       return ptax;
     }
      
  
     public void setleaveDedu(int leaveDedu)
     {
       this.leaveDedu=leaveDedu;
     }

     public int getleaveDedu()
     {
       return leaveDedu;
     }
      
  

    public void setovertime(int overtime)
     {
       this.overtime=overtime;
     }

     public int getovertime()
     {
       return overtime;
     }
      
    
     public void setpfAmount(int pfAmount)
     {
       this.pfAmount=pfAmount;
     }

     public int getpfAmount()
     {
       return pfAmount;
     }

     public void setotherAllow(int otherAllow)
     {
       this.otherAllow=otherAllow;
     }

     public int getotherAllow()
     {
       return otherAllow;
     }
     
     public void setotherDedu(int otherDedu)      
     {
      this.otherDedu=otherDedu;
     }

     public int getotherDedu()
     {
      return otherDedu;
     }

    public String toString()
    {
      return "SalaryMaster [salaryid=" + salaryid + ",salarydate=" + salarydate + ",profileCode=" + profileCode + ", da=" + da 
                            + ",hra=" + hra + ", ma=" + ma + ", ptax=" + ptax + ", leaveDedu=" + leaveDedu + ", overtime=" + overtime 
                            +" , pfAmount=" + pfAmount + " ,otherAllow=" + otherAllow + ",otherDedu=" + otherDedu+ "]";

    }
 
    
 
     
        //Database logic

        public boolean addsal()
         {
            try{
               
              
              salaryid =Db.newSalaryId();     
             
              Db x=new Db("insert into salary values (?,?,?,?,?,?,?,?,?,?,?,?)");
              x.getPs().setInt(1,salaryid);
              x.getPs().setString(2,salarydate);
              x.getPs().setInt(3,profileCode);
              x.getPs().setInt(4,da);
              x.getPs().setInt(5,hra);
              x.getPs().setInt(6,ma);
              x.getPs().setInt(7,ptax);
              x.getPs().setInt(8,leaveDedu);
              x.getPs().setInt(9,overtime);
              x.getPs().setInt(10,pfAmount);
              x.getPs().setInt(11,otherAllow);
              x.getPs().setInt(12,otherDedu);
              


             
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }


       public boolean updatesal()
         {
            try{
              Db x=new Db("update salary set salaryid=?,salarydate=?,profile_code=?,da=?,hra=?,ma=?,ptax=?,leave_dedu=?,overtime=?,pf_amount=?,other_allow=?,other_dedu=? where salaryid=?");
              x.getPs().setInt(1,salaryid);
              x.getPs().setString(2,salarydate);
              x.getPs().setInt(3,profileCode);
              x.getPs().setInt(4,da);
              x.getPs().setInt(5,hra);
              x.getPs().setInt(6,ma);
              x.getPs().setInt(7,ptax);
              x.getPs().setInt(8,leaveDedu);
              x.getPs().setInt(9,overtime);
              x.getPs().setInt(10,pfAmount);
              x.getPs().setInt(11,otherAllow);
              x.getPs().setInt(12,otherDedu);
             
 
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

      public boolean deletesal()
         {
            try{
              Db x=new Db("delete from salary where salaryid=?");
              x.getPs().setInt(1,salaryid);
              x.execute();
              return true;
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public boolean fetchsal()
         {
            try{
              Db x=new Db("select * from salary where salaryid=?");
              x.getPs().setInt(1,salaryid);

              Object []r=x.row();
              if(r!=null) 
               {   
                 salaryid=Integer.parseInt(r[0].toString());
                 salarydate=r[1].toString();
                 profileCode=Integer.parseInt(r[2].toString());
                 da=Integer.parseInt(r[3].toString());
                 hra=Integer.parseInt(r[4].toString());
                 ma=Integer.parseInt(r[5].toString());
                 ptax=Integer.parseInt(r[6].toString());
                 leaveDedu=Integer.parseInt(r[7].toString());
                 overtime=Integer.parseInt(r[8].toString());
                 pfAmount=Integer.parseInt(r[9].toString());
                 otherAllow=Integer.parseInt(r[10].toString());
                 otherDedu=Integer.parseInt(r[11].toString());     
  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<SalaryMaster> getSal()
       {
          List<SalaryMaster> list=new ArrayList<SalaryMaster>();
          try{
             Db x=new Db("select * from salary");
             List<Object[]>result=x.rows();
             
             for(Object []r:result)
                {
                    SalaryMaster sal=new SalaryMaster();
 
                    sal.setsalaryid(Integer.parseInt(r[0].toString()));
                    sal.setsalarydate(r[1].toString());
                    sal.setprofileCode(Integer.parseInt(r[2].toString()));
                    sal.setda(Integer.parseInt(r[3].toString()));
                    sal.sethra(Integer.parseInt(r[4].toString()));
                    sal.setma(Integer.parseInt(r[5].toString()));
                    sal.setptax(Integer.parseInt(r[6].toString()));
                    sal.setleaveDedu(Integer.parseInt(r[7].toString()));
                    sal.setovertime(Integer.parseInt(r[8].toString()));
                    sal.setpfAmount(Integer.parseInt(r[9].toString()));
                    sal.setotherAllow(Integer.parseInt(r[10].toString()));
                    sal.setotherDedu(Integer.parseInt(r[11].toString()));          
                    list.add(sal);
                 }
          }catch(Exception ex){
               System.err.println(ex);
          } 
          return list; 
       }

  }
  
                             