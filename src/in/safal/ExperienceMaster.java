package in.safal;

import java.util.List;
import java.util.ArrayList;

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

public class ExperienceMaster
 {
     private int expid=0;
     private int empCode=0;
     private String cmpname="";
     private String fromdate="";
     private String todate="";
     private String desig="";
    

    public ExperienceMaster() {}

 
    public ExperienceMaster(int expid)
    {
      this.expid=expid;
    }
 
    public ExperienceMaster(int expid,
                         int empCode,
                         String cmpname,
                         String fromdate,
                         String todate,
                         String desig)
                        
    {
     this.expid=expid;
     this.empCode=empCode;
     this.cmpname=cmpname;
     this.fromdate=fromdate;
     this.todate=todate;
     this.desig=desig;
     
     
     }

    public void setexpid(int expid)
    {
      this.expid=expid;
    }

    public int getexpid()
    {
     return expid;
     }
 
    public void setempCode(int empCode)
    {
      this.empCode=empCode;
    }

    public int getempCode()
    {
     return empCode;
    }
 
    public void setcmpname(String cmpname)
    {

      this.cmpname=cmpname;
     }
 
     public String getcmpname()
     {
      return cmpname;
     } 
 
     public void setfromdate(String fromdate)
     {
       this.fromdate=fromdate;
     }

     public String getfromdate()
     {
       return fromdate;
     }
      
  
     public void settodate(String todate)
     {
       this.todate=todate;
     }

     public String gettodate()
     {
       return todate;
     }
     
       public void setdesig(String desig)
     {
       this.desig=desig;
     }

     public String getdesig()
     {
       return desig;
     }
     
    

    public String toString()
    {
      return "ExperienceMaster [expid=" + expid + ", empCode=" + empCode + ", cmpname=" + cmpname 
                            + ",fromdate=" + fromdate + ",todate=" + todate + ",desig=" + desig + "]";

    }

 


   
        //Database logic

        public boolean addExper()
         {
            try{
               
              
              expid =Db.newExpId();     
             
              Db x=new Db("insert into experience values (?,?,?,?,?,?)");
              x.getPs().setInt(1,expid);
              x.getPs().setInt(2,empCode);
              x.getPs().setString(3,cmpname);
              x.getPs().setString(4,fromdate);
              x.getPs().setString(5,todate);
              x.getPs().setString(6,desig);

             
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }


       public boolean updateExper()
         {
            try{
              Db x=new Db("update experience set emp_code=?,cmp_name=?,from_date=?,to_date=?,desig=? where exp_id=?");
              x.getPs().setInt(1,expid);
              x.getPs().setInt(2,empCode);
              x.getPs().setString(3,cmpname);
              x.getPs().setString(4,fromdate);
              x.getPs().setString(5,todate);
              x.getPs().setString(6,desig);
 
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

      public boolean deleteExper()
         {
            try{
              Db x=new Db("delete from experience where expid=?");
              x.getPs().setInt(1,expid);
              x.execute();
              return true;
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public boolean fetchExper()
         {
            try{
              Db x=new Db("select * from experience where expid=?");
              x.getPs().setInt(1,expid);

              Object []r=x.row();
              if(r!=null) 
               {   
                 empCode=Integer.parseInt(r[0].toString());
                 cmpname=r[1].toString();
                 fromdate=r[2].toString();
                 todate=r[3].toString();
                 desig=r[4].toString();
  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<ExperienceMaster> getExperience()
       {
          List<ExperienceMaster> list=new ArrayList<ExperienceMaster>();
          try{
             Db x=new Db("select * from experience");
             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    ExperienceMaster Exper=new ExperienceMaster();
 
                    Exper.setexpid(Integer.parseInt(r[0].toString()));
                    Exper.setempCode(Integer.parseInt(r[1].toString()));
                    Exper.setcmpname(r[2].toString());
                    Exper.setfromdate(r[3].toString());
                    Exper.settodate(r[4].toString());
                    Exper.setdesig(r[5].toString()); 
                    list.add(Exper);
                 }
          }catch(Exception ex){
               System.err.println(ex);
          } 
          return list; 
       }

}
  