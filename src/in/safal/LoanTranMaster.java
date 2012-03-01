package in.safal;

import java.util.List;
import java.util.ArrayList;

/*
create table loan_tran
(
   loan_tran_code number(10) primary key,
   loan_code number(7) references loan_master(loan_code),
   tran_date date,
   tran_amount number(15,2),
   narration varchar2(50)
)


*/


public class LoanTranMaster
 {
     private int loantranCode=0;
     private int loanCode=0;
     private String tranDate="";
     private int tranAmount=0;
     private String narration="";
    

    public LoanTranMaster() {}

 
    public LoanTranMaster(int loanTranCode)
    {
      this.loantranCode=loantranCode;
    }
 
    public LoanTranMaster(int loantranCode,
                         int loanCode,
                         String tranDate,
                         int tranAmount,
                         String narration)
                        
    {
     this.loantranCode=loantranCode;
     this.loanCode=loanCode;
     this.tranDate=tranDate;
     this.tranAmount=tranAmount;
     this.narration=narration;
     
     }

    public void setloantranCode(int loantranCode)
    {
      this.loantranCode=loantranCode;
    }

    public int getloantranCode()
    {
     return loantranCode;
     }
 
    public void setloanCode(int loanCode)
    {
      this.loanCode=loanCode;
    }

    public int getloanCode()
    {
     return loanCode;
    }
 
    public void settranDate(String tranDate)
    {

      this.tranDate=tranDate;
     }
 
     public String gettranDate()
     {
      return tranDate;
     } 
 
     public void settranAmount(int tranAmount)
     {
       this.tranAmount=tranAmount;
     }

     public int gettranAmount()
     {
       return tranAmount;
     }
      
  
     public void setnarration(String narration)
     {
       this.narration=narration;
     }

     public String getnarration()
     {
       return narration;
     }
     
    

    public String toString()
    {
      return "LoanTranMaster [loantranCode=" + loantranCode + ", loanCode=" + loanCode + ", tranDate=" + tranDate 
                            + ",tranAmount=" + tranAmount + ", narration=" + narration + "]";

    }

 
    

    
        //Database logic

        public boolean addLoanTran()
         {
            try{
               
              
              loantranCode =Db.newLoanTranCode();     
             
              Db x=new Db("insert into loan_tran values (?,?,?,?,?)");
              x.getPs().setInt(1,loantranCode);
              x.getPs().setInt(2,loanCode);
              x.getPs().setString(3,tranDate);
              x.getPs().setInt(4,tranAmount);
              x.getPs().setString(5,narration);

             
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }


       public boolean updateLoanTran()
         {
            try{
              Db x=new Db("update loan_tran set loan_code=?,tran_date=?,tran_amount=?,narration=?  where loan_tran_code=?");
              x.getPs().setInt(1,loantranCode);
              x.getPs().setInt(2,loanCode);
              x.getPs().setString(3,tranDate);
              x.getPs().setInt(4,tranAmount);
              x.getPs().setString(5,narration);
              
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

      public boolean deleteLoanTran()
         {
            try{
              Db x=new Db("delete from loan_tran where loan_tran_code=?");
              x.getPs().setInt(1,loantranCode);
              x.execute();
              return true;
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public boolean fetchLoanTran()
         {
            try{
              Db x=new Db("select * from loan_tran where loan_tran_code=?");
              x.getPs().setInt(1,loantranCode);

              Object []r=x.row();
              if(r!=null) 
               {   
                 loantranCode=Integer.parseInt(r[0].toString());
                 loanCode=Integer.parseInt(r[1].toString()); 
                 tranDate=r[2].toString();
                 tranAmount=Integer.parseInt(r[3].toString());
                 narration=r[4].toString();
  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<LoanTranMaster> getLoanTran()
       {
          List<LoanTranMaster> list=new ArrayList<LoanTranMaster>();
          try{
             Db x=new Db("select * from loan_tran");
             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    LoanTranMaster loantran=new LoanTranMaster();
 
                    loantran.setloantranCode(Integer.parseInt(r[0].toString()));
                    loantran.setloanCode(Integer.parseInt(r[1].toString()));
                    loantran.settranDate(r[2].toString());
                    loantran.settranAmount(Integer.parseInt(r[3].toString()));
                    loantran.setnarration(r[4].toString());
                    
                    list.add(loantran);
                 }
          }catch(Exception ex){
               System.err.println(ex);
          } 
          return list; 
       }

  }
  