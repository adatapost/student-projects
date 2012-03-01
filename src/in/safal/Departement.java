package in.safal;


/*
 create table dept
 (
 dept_code number(2) primary key,
 dept_name varchar2(30)
 )

*/
     public class Departement
     { 

	private int deptCode = 0;
	private String deptName = "";

	public Departement() {}

	public Departement(int deptCode, String deptName) 
        {
	   this.deptCode = deptCode;
	   this.deptName = deptName;
	}

	public Departement(int deptCode) 
        {
		this.deptCode = deptCode;
	}

        public void setDeptCode(int deptCode) 
       {
		this.deptCode = deptCode;
	}

	public int getDeptCode() 
       {
		return deptCode;
	}


        public void setDeptName(String deptName) 
        {
		this.deptName = deptName;
	}
 
	public String getDeptName() 
        {
		return deptName;
	}

	
        public String toString()
        {
		return "Departement [deptCode=" + deptCode + ", deptName=" + deptName + "]";
	}

    }