package in.safal;

public class Login {
    private String username;
    private String password;
    private String question;
    private String answer;
	public Login() {
		super();
	}
	public Login(String username) {
		super();
		this.username = username;
	}
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Login(String username, String password, String question,
			String answer) {
		super();
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
	public boolean validLogin()
	{
		try{
			Db x=new Db("select username from login where username=? and password=?");
			x.getPs().setString(1,username);
			x.getPs().setString(2, password);
			Object c=x.scalar();
			if(c!=null)
				return true;
			
		}catch(Exception ex){
			System.err.println(ex);
		}
		return false;
	}
	
	public boolean changePassword(String newpass)
	{
		try {
			if(validLogin())
			{
			 Db x=new Db("update login set password=? where username=?");
			 x.getPs().setString(1, newpass);
			 x.getPs().setString(2,username);
			 x.execute();
			 return true;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}
    
	public String  recoverPassword()
	{
		try {
			if(validLogin())
			{
			 Db x=new Db("select password from  login where username=? and question=? and answer=?");

			 x.getPs().setString(1,username);
			 x.getPs().setString(2,question);
			 x.getPs().setString(3,answer);
			 Object c=x.scalar();
			 if(c!=null)
			   return c.toString();
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
}
