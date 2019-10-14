package fat;

import java.io.Serializable;

public class Accounts implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private char[] passchar;
	private String login;
	private int priority;
	private boolean loged=false;
	private String info="jakieœ info";
	
	
	public Accounts(String log, String pass, int priori) {
		setLogin(log);
		setPassword(pass);
		setPriority(priori);
	}

	public String getPassword() {
		String temp = "";
		
		for(int i=0; i< passchar.length; i++)
		{
			char tempchar1 = (char) passchar[i];
			temp += (char) ((int)tempchar1 -2);
			
		}
		
		return temp;
	}

	public void setPassword(String password) {
		
		int howlong = password.length();
		
		passchar = new char[howlong];
		
		for(int i=0; i<howlong; i++)
		{
			char tempo = password.charAt(i);
			char tempchar = (char) ((int) tempo + 2);
			this.passchar[i] = tempchar ;

		}

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isLoged() {
		return loged;
	}

	public void setLoged(boolean loged) {
		this.loged = loged;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		
		return "\nlogin: " + this.login + "\nPiority: " + this.priority + 
				"\nIs Loged: " + this.isLoged() + "\nInfo: " + this.info;
	}
}
