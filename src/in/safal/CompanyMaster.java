package in.safal;

import java.util.ArrayList;
import java.util.List;

/*

 create table company_master
 (
 cmp_code varchar2(5) primary key,
 cmp_name varchar2(100),
 cmp_address varchar2(200),
 cmp_city varchar2(30),
 cmp_state varchar2(20),
 cmp_pin varchar2(6)
 )
 */
public class CompanyMaster {
	private String cmpCode = "";
	private String cmpName = "";
	private String cmpAddress = "";
	private String cmpCity = "";
	private String cmpState = "";
	private String cmpPin = "";

	public CompanyMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyMaster(String cmpCode) {
		super();
		this.cmpCode = cmpCode;
	}

	public CompanyMaster(String cmpCode, String cmpName, String cmpAddress,
			String cmpCity, String cmpState, String cmpPin) {
		super();
		this.cmpCode = cmpCode;
		this.cmpName = cmpName;
		this.cmpAddress = cmpAddress;
		this.cmpCity = cmpCity;
		this.cmpState = cmpState;
		this.cmpPin = cmpPin;
	}

	public String getCmpCode() {
		return cmpCode;
	}

	public void setCmpCode(String cmpCode) {
		this.cmpCode = cmpCode;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getCmpAddress() {
		return cmpAddress;
	}

	public void setCmpAddress(String cmpAddress) {
		this.cmpAddress = cmpAddress;
	}

	public String getCmpCity() {
		return cmpCity;
	}

	public void setCmpCity(String cmpCity) {
		this.cmpCity = cmpCity;
	}

	public String getCmpState() {
		return cmpState;
	}

	public void setCmpState(String cmpState) {
		this.cmpState = cmpState;
	}

	public String getCmpPin() {
		return cmpPin;
	}

	public void setCmpPin(String cmpPin) {
		this.cmpPin = cmpPin;
	}

	@Override
	public String toString() {
		return "CompanyMaster [cmpCode=" + cmpCode + ", cmpName=" + cmpName
				+ ", cmpAddress=" + cmpAddress + ", cmpCity=" + cmpCity
				+ ", cmpState=" + cmpState + ", cmpPin=" + cmpPin + "]";
	}
    
	public boolean findByCompanyCode()
	{
		try {
			Db x=new Db("select cmp_code from company_master where cmp_code=?");
			x.getPs().setString(1, cmpCode);
			return x.scalar()!=null;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public boolean addCompanyMaster()
	{
		try {
			Db x=new Db("insert into company_master values (?,?,?,?,?,?)");
			x.getPs().setString(1, cmpCode);
			x.getPs().setString(2, cmpName);
			x.getPs().setString(3, cmpAddress);
			x.getPs().setString(4, cmpCity);
			x.getPs().setString(5, cmpState);
			x.getPs().setString(6, cmpPin);
			
			x.execute();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public boolean fetchCompanyMaster()
	{
		try {
			Db x=new Db("select * from company_master where cmp_code=?");
			x.getPs().setString(1, cmpCode);
			Object []r=x.row();
			if(r!=null)
			{
				cmpCode=r[0].toString();
				cmpName=r[1].toString();
				cmpAddress=r[2].toString();
				cmpCity=r[3].toString();
				cmpState=r[4].toString();
				cmpPin=r[5].toString();
				return true;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public static List<CompanyMaster> getCompanyMasters()
	{
		ArrayList<CompanyMaster> list=new ArrayList<CompanyMaster>();
		try {
			Db x=new Db("select * from company_master");
			List<Object[]> result=x.rows();
			
			for(Object []r:result)
			{
				CompanyMaster c=new CompanyMaster(r[0].toString(),r[1].toString(),r[2].toString(),r[3].toString(),r[4].toString(),r[5].toString());
				list.add(c);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return list;
	}
}
