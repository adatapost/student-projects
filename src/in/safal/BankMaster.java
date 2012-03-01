package in.safal;

import java.util.ArrayList;
import java.util.List;

/*
 create table bank_master
 (
 bank_code varchar2(5) primary key,
 bank_name varchar2(50) not null,
 bank_address varchar2(200) not null,
 bank_city varchar2(20),
 bank_phone varchar2(20),
 bank_branch varchar2(40)
 )

 */

public class BankMaster {
	private String bankCode = "";
	private String bankName = "";
	private String bankAddress = "";
	private String bankCity = "";
	private String bankPhone = "";
	private String bankBranch = "";

	public BankMaster() {
	}

	public BankMaster(String bankCode) {
		this.bankCode = bankCode;
	}

	public BankMaster(String bankCode, String bankName, String bankAddress,
			String bankCity, String bankPhone, String bankBranch) {
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.bankCity = bankCity;
		this.bankPhone = bankPhone;
		this.bankBranch = bankBranch;
	}

	// Getter/setter
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}

	public String getBankPhone() {
		return bankPhone;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	@Override
	public String toString() {
		return "BankMaster [bankCode=" + bankCode + ", bankName=" + bankName
				+ ", bankAddress=" + bankAddress + ", bankCity=" + bankCity
				+ ", bankPhone=" + bankPhone + ", bankBranch=" + bankBranch
				+ "]";
	}

	public boolean findByBankCode()
	{
		try {
			Db x=new Db("select bank_code from bank_master where bank_code=?");
			x.getPs().setString(1,bankCode);
			return x.scalar()!=null;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public boolean addBankMaster()
	{
		try {
			Db x=new Db("insert into bank_master values (?,?,?,?,?,?)");
			x.getPs().setString(1,bankCode);
			x.getPs().setString(2, bankName);
			x.getPs().setString(3, bankAddress);
			x.getPs().setString(4, bankCity);
			x.getPs().setString(5, bankPhone);
			x.getPs().setString(6, bankBranch);
			x.execute();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}	
	public boolean updateBankMaster()
	{
		try {
			Db x=new Db("update bank_master set bank_name=?,bank_address=?,bank_city=?,bank_phone=?,bank_branch=? where bank_code=?");
			x.getPs().setString(1, bankName);
			x.getPs().setString(2, bankAddress);
			x.getPs().setString(3, bankCity);
			x.getPs().setString(4, bankPhone);
			x.getPs().setString(5, bankBranch);
			x.getPs().setString(6,bankCode);

			x.execute();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public boolean deleteBankMaster()
	{
		try {
			Db x=new Db("delete from bank_master where bank_code=?");
			x.getPs().setString(1,bankCode);
			x.execute();
			return true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public boolean fetchBankMaster()
	{
		try {
			Db x=new Db("select * from bank_master where bank_code=?");
			x.getPs().setString(1,bankCode);
			Object []r=x.row();
			if(r!=null)
			{
			    bankCode=r[0].toString();
			    bankName=r[1].toString();
			    bankAddress=r[2].toString();
			    bankCity=r[3].toString();
			    bankPhone=r[4].toString();
			    bankBranch=r[5].toString();
				return true;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
	public static List<BankMaster> getBankMasters()
	{
		List<BankMaster> list=new ArrayList<BankMaster>(); 
		try {
			Db x=new Db("select * from bank_master order by bank_code");

            List<Object[]> result=x.rows();
			for(Object []r:result)
			{
				BankMaster b=new BankMaster(r[0].toString(),r[1].toString(),r[2].toString(),r[3].toString(),r[4].toString(),r[5].toString());
				list.add(b);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return list;
	}
}