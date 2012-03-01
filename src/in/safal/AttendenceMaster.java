package in.safal;

import java.util.List;
import java.util.ArrayList;


/*
create table attendance
(
  att_code number(10) primary key,
  profile_code number(7) references employee_profile(profile_code),
  att_date date,
  overtime_hours number(3),
  present number(2),
  absent number(2),
  weekoff number(2),
  leave number(2),
  holiday number(2),
  halfday number(2)
)

*/

   public class AttendenceMaster
    {
     private int attCode=0;
     private int profileCode=0;
     private String attdate="";
     private int overtimehours=0;
     private int present=0;
     private int absent=0;
     private int weekoff=0;
     private int leave=0;
     private int holiday=0;
     private int halfday=0;

    public AttendenceMaster() {}

 
    public AttendenceMaster(int attCode)
    {
      this.attCode=attCode;
    }
 
    public AttendenceMaster(int attCode,
                         int profileCode,
                         String attdate,
                         int overtimehours,
                         int present,
                         int absent,
                         int weekoff,
                         int leave,
                         int holiday,
                         int halfday)
    {
     this.attCode=attCode;
     this.profileCode=profileCode;
     this.attdate=attdate;
     this.overtimehours=overtimehours;
     this.present=present;
     this.absent=absent;
     this.weekoff=weekoff;
     this.leave=leave;
     this.holiday=holiday;
     this.halfday=halfday;  
     }

    public void setattCode(int attCode)
    {
      this.attCode=attCode;
    }

    public int getattCode()
    {
     return attCode;
     }
 
    public void setprofileCode(int profileCode)
    {
      this.profileCode=profileCode;
    }
    public int getprofileCode()
    {
     return profileCode;
    }
 
    public void setattdate(String attdate)
    {

      this.attdate=attdate;
     }
 
     public String getattdate()
     {
      return attdate;
     } 
 
     public void setovertimehours(int overtimehours)
     {
       this.overtimehours=overtimehours;
     }

     public int getovertimehours()
     {
       return overtimehours;
     }
      
  
     public void setpresent(int present)
     {
       this.present=present;
     }

     public int getpresent()
     {
       return present;
     }

     public void setabsent(int absent)
     {
       this.absent=absent;
     }

     public int getabsent()
     {
       return absent;
     }
     
    
     public void setweekoff(int weekoff)      
     {
      this.weekoff=weekoff;
     }

     public int getweekoff()
     {
      return weekoff;
     }
     
      public void setleave(int leave)      
     {
      this.leave=leave;
     }

     public int getleave()
     {
      return leave;
     }
    
      public void setholiday(int holiday)      
     {
      this.holiday=holiday;
     }

     public int getholiday()
     {
      return holiday;
     }
 
       public void sethalfday(int halfday)      
     {
      this.halfday=halfday;
     }

     public int gethalfday()
     {
      return halfday;
     }

    public String toString()
    {
      return "AttendenceMaster [attCode=" + attCode + ", profileCode=" + profileCode + ", attdate=" + attdate 
                            + ",overtimehours=" + overtimehours + ",present=" + present + ",absent=" + absent + ", weekoff=" 
                             + weekoff + ", leave=" + leave + ", holiday=" + holiday + ", halfday=" + halfday + "]";

    }


  
        //Database logic

        public boolean addAttend()
         {
            try{
               
              
              attCode =Db.newAttCode();     
             
              Db x=new Db("insert into attendence values (?,?,?,?,?,?,?,?,?,?)");
              x.getPs().setInt(1,attCode);
              x.getPs().setInt(2,profileCode);
              x.getPs().setString(3,attdate);
              x.getPs().setInt(4,overtimehours);
              x.getPs().setInt(5,present);
              x.getPs().setInt(6,absent);
              x.getPs().setInt(7,weekoff);
              x.getPs().setInt(8,leave);
              x.getPs().setInt(8,holiday);
              x.getPs().setInt(10,halfday);


             
              x.execute();
              return true;

            }
              catch(Exception ex)
             {
               System.err.println(ex);
             }
              return false;
          }


       public boolean updateAttend()
         {
            try{
              Db x=new Db("update attendence set profile_code=?,att_date=?,overtime_hours=?,present=? ,absent=?,weakoff=? ,leave=?,holiday=?,halfday=? where att_code=?");
              x.getPs().setInt(1,attCode);
              x.getPs().setInt(2,profileCode);
              x.getPs().setString(3,attdate);
              x.getPs().setInt(4,overtimehours);
              x.getPs().setInt(5,present);
              x.getPs().setInt(6,absent);
              x.getPs().setInt(7,weekoff);
              x.getPs().setInt(8,leave);
              x.getPs().setInt(9,holiday);
              x.getPs().setInt(10,halfday);   
 
              x.execute();
              return true;

            }
              catch(Exception ex)
             {
               System.err.println(ex);
             }
              return false;
          }

      public boolean deleteAttend()
         {
            try{
              Db x=new Db("delete from attendence where att_code=?");
              x.getPs().setInt(1,attCode);
              x.execute();
              return true;
 
              }
              catch(Exception ex)
              {
               System.err.println(ex);
              }
               return false;
          }

     public boolean fetchAttend()
         {
            try{
              Db x=new Db("select * from attendence where att_code=?");
              x.getPs().setInt(1,attCode);

              Object []r=x.row();
              if(r!=null) 
               {   
                 attCode=Integer.parseInt(r[0].toString());
                 profileCode=Integer.parseInt(r[1].toString());
                 attdate=r[2].toString();
                 overtimehours=Integer.parseInt(r[3].toString());
                 present=Integer.parseInt(r[4].toString());
                 absent=Integer.parseInt(r[5].toString());
                 weekoff=Integer.parseInt(r[6].toString());
                 leave=Integer.parseInt(r[7].toString());
                 holiday=Integer.parseInt(r[8].toString());
                 halfday=Integer.parseInt(r[9].toString());  
  
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<AttendenceMaster> getAttend()
       {
         List<AttendenceMaster> list=new ArrayList<AttendenceMaster>();
         
          try{
             Db x=new Db("select * from attendance");

             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    AttendenceMaster attd=new AttendenceMaster();
 
                    attd.setattCode(Integer.parseInt(r[0].toString()));
                    attd.setprofileCode(Integer.parseInt(r[1].toString()));
                    attd.setattdate(r[2].toString());
                    attd.setovertimehours(Integer.parseInt(r[3].toString()));
                    attd.setpresent(Integer.parseInt(r[4].toString())); 
                    attd.setabsent(Integer.parseInt(r[5].toString())); 
                    attd.setweekoff(Integer.parseInt(r[6].toString()));
                    attd.setleave(Integer.parseInt(r[7].toString()));
                    attd.setholiday(Integer.parseInt(r[8].toString()));
                    attd.sethalfday(Integer.parseInt(r[9].toString()));
                   
                    list.add(attd);
                 }
          }
             catch(Exception ex)
             {
               System.err.println(ex);
             } 
              return list; 
       }

   }
                             