package in.safal;

import java.util.List;
import java.util.ArrayList;

/*  create table designation
 (
 dg_code number(2) primary key,
 dg_name varchar2(30)
 )
  
 */
public class Designation 
       {
	
           private int dgCode;
           private String dgName;

	   public Designation() {}
      
           public Designation(int dgCode)
           {
		
		this.dgCode = dgCode;
	   }

	   public Designation(int dgCode, String dgName) 
           {
	    this.dgCode = dgCode;
	    this.dgName = dgName;
	   }

          public void setDgCode(int dgCode) 
           {
	    this.dgCode = dgCode;
	   }

	  public int getDgCode()
          {
	   return dgCode;
	  }

           public void setDgName(String dgName)
          {
		this.dgName = dgName;
	  }

	  public String getDgName() 
           {
	   return dgName;
	   }

	
	  public String toString()  
          {
		return "Designation [dgCode=" + dgCode + ", dgName=" + dgName + "]";

	  }

      //database logic
 
     public boolean addDesignation()
     {
        try
         {
           dgCode=Db.newDgCode();
         
           Db x=new Db("insert into designation values (?,?)");
           x.getPs().setInt(1,dgCode);
           x.getPs().setString(2,dgName);

           x.execute();
           return true;
         }
       catch(Exception ex)  
         {
          return false;
         }
     }

   public boolean updateDesignation()
     {
        try
         {
          Db x=new Db("update designation set dg_Name=? where dg_Code=?");
          x.getPs().setString(1,dgName);
          x.getPs().setInt(2,dgCode);
          x.execute();
          return true;
         }
        catch(Exception ex)
         {
          System.err.println(ex);
         }
          return false;
     }


   public boolean deleteDesignation()
    {
       try
        {
         Db x=new Db("delete from designation where dg_Code=?");
         x.getPs().setInt(1,dgCode);
         x.execute();
         return true;
        }
      catch(Exception ex)
        {
         System.err.println(ex);
        }
         return false;
    }

  public boolean fetchDesignation()
    {
      try
       {
         Db x=new Db("select * from designation where dg_Code=?");
         x.getPs().setInt(1,dgCode);

         Object []r=x.row();
         if(r!=null)  
         {
           dgName=r[1].toString();
           return true;
         }
       }
      catch(Exception ex)   
         {
          System.err.println(ex);
         }
           return false;
    }

     public static List<Designation> getDesigs()
       {
         List<Designation> list=new ArrayList<Designation>();
          try
          {
             Db x=new Db("select * from  Designation");
             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                     Designation desig=new Designation();
                     desig.setDgCode(Integer.parseInt(r[0].toString()));
                     desig.setDgName(r[1].toString());
                     list.add(desig);
                 }
          }
             catch(Exception ex)
            {
               System.err.println(ex);
            } 
              return list; 
       }

}

  