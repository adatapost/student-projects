package in.safal;

import java.util.List;
import java.util.ArrayList;


/*
create table loan_master
(
   loan_code number(7) primary key,
   profile_code number(7) references employee_profile(profile_code),
   loan_date date,
   loan_amount number(15,2),
   inst_amount number(15,2) 
)
*/

public class LoanMaster
 {
     private int loanCode=0;
     private int profileCode=0;
     private String loanDate="";
     private int loanAmount=0;
     private int instAmount=0;
    

    public LoanMaster() 
    {}
 
    public LoanMaster(int loanCode)
    {
      this.loanCode=loanCode;
    }
 
    public LoanMaster(int loanCode,
                         int profileCode,
                         String loanDate,
                         int loanAmount,
                         int instAmount)
                        
    {
     this.loanCode=loanCode;
     this.profileCode=profileCode;
     this.loanDate=loanDate;
     this.loanAmount=loanAmount;
     this.instAmount=instAmount;
     
     }

    public void setloanCode(int loanCode)
    {
      this.loanCode=loanCode;
    }

    public int getloanCode()
    {
     return loanCode;
     }
 
    public void setprofileCode(int profileCode)
    {
      this.profileCode=profileCode;
    }

    public int getprofileCode()
    {
     return profileCode;
    }
 
    public void setloanDate(String loanDate)
    {

      this.loanDate=loanDate;
     }
 
     public String getloanDate()
     {
      return loanDate;
     } 
 
     public void setloanAmount(int loanAmount)
     {
       this.loanAmount=loanAmount;
     }

     public int getloanAmount()
     {
       return loanAmount;
     }
      
  
     public void setinstAmount(int instAmount)
     {
       this.instAmount=instAmount;
     }

     public int getinstAmount()
     {
       return instAmount;
     }
     
    

    public String toString()
    {
      return "LoanMaster [loanCode=" + loanCode + ", profileCode=" + profileCode + ", loanDate=" + loanDate 
                            + ",loanAmount=" + loanAmount + ", instAmount=" + instAmount + "]";

    }

 

   
  
        //Database logic

        public boolean addLoan()
         {
            try{
               
              
              loanCode =Db.newLoanCode();     
             
              Db x=new Db("insert into loan_master values (?,?,?,?,?)");
              x.getPs().setInt(1,loanCode);
              x.getPs().setInt(2,profileCode);
              x.getPs().setString(3,loanDate);
              x.getPs().setInt(4,loanAmount);
              x.getPs().setInt(5,instAmount);

             
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }


       public boolean updateLoan()
         {
            try{
              Db x=new Db("update loan_master set profile_code=?,loan_date=?,loan_amount=?,inst_amount=?  where loan_code=?");
              x.getPs().setInt(1,loanCode);
              x.getPs().setInt(2,profileCode);
              x.getPs().setString(3,loanDate);
              x.getPs().setInt(4,loanAmount);
              x.getPs().setInt(5,instAmount);
              
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

      public boolean deleteLoan()
         {
            try{
              Db x=new Db("delete from loan_master where loan_code=?");
              x.getPs().setInt(1,loanCode);
              x.execute();
              return true;
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public boolean fetchLoan()
         {
            try{
              Db x=new Db("select * from loan_master where loan_code=?");
              x.getPs().setInt(1,loanCode);

              Object []r=x.row();
              if(r!=null) 
               {   
                 loanCode=Integer.parseInt(r[0].toString());
                 profileCode=Integer.parseInt(r[1].toString()); 
                 loanDate=r[2].toString();
                 loanAmount=Integer.parseInt(r[3].toString());
                 instAmount=Integer.parseInt(r[4].toString());

  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<LoanMaster> getLoan()
       {
          List<LoanMaster> list=new ArrayList<LoanMaster>();
          try{
             Db x=new Db("select * from loan_tran");
             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    LoanMaster loan=new LoanMaster();
 
                    loan.setloanCode(Integer.parseInt(r[0].toString()));
                    loan.setprofileCode(Integer.parseInt(r[1].toString()));
                    loan.setloanDate(r[2].toString());
                    loan.setloanAmount(Integer.parseInt(r[3].toString()));
                    loan.setinstAmount(Integer.parseInt(r[4].toString()));

                    
                    list.add(loan);
                 }
          }catch(Exception ex){
               System.err.println(ex);
          } 
          return list; 
       }

  }
  
                             
                           
     