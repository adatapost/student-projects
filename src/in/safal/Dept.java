package in.safal;

import java.util.List;
import java.util.ArrayList;
/*
 * create table dept
 (
 dept_code number(2) primary key,
 dept_name varchar2(30)
 )

 
 */
public class Dept {
	@Override
	public String toString() {
		return "Dept [deptCode=" + deptCode + ", deptName=" + deptName + "]";
	}

	private int deptCode = 0;
	private String deptName = "";

	public Dept() {
	}

	public Dept(int deptCode, String deptName) {
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	public Dept(int deptCode) {
		this.deptCode = deptCode;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


        //Database logic

        public boolean addDept()
         {
            try{
              deptCode=Db.newDeptCode();

              Db x=new Db("insert into dept values (?,?)");
              x.getPs().setInt(1,deptCode);
              x.getPs().setString(2,deptName);

              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }


       public boolean updateDept()
         {
            try{
              Db x=new Db("update dept set dept_name=? where dept_code=?");
              x.getPs().setString(1,deptName);
              x.getPs().setInt(2,deptCode);
              x.execute();
              return true;

            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

      public boolean deleteDept()
         {
            try{
              Db x=new Db("delete from dept where dept_code=?");
              x.getPs().setInt(1,deptCode);
              x.execute();
              return true;
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public boolean fetchDept()
         {
            try{
              Db x=new Db("select * from dept where dept_code=?");
              x.getPs().setInt(1,deptCode);

              Object []r=x.row();
              if(r!=null) {   
                 deptName=r[1].toString();
                 return true;
              }
            }catch(Exception ex){
               System.err.println(ex);
            }
            return false;
          }

     public static List<Dept> getDepts()
       {
          List<Dept> list=new ArrayList<Dept>();
          try{
             Db x=new Db("select * from dept order by dept_code");
             List<Object[]> result=x.rows();
             
             for(Object []r:result)
                {
                    Dept d=new Dept();
                    d.setDeptCode(Integer.parseInt(r[0].toString()));
                    d.setDeptName(r[1].toString());
                    list.add(d);
                 }
          }catch(Exception ex){
               System.err.println(ex);
          } 
          return list; 
       }

}
