package fat;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Management {

	private static final int MINPRIORITYTOADDNEWSPOLECZENTWO = 1;
	private static final int MINPRIORITYTOADDNEWPERSON = 1;
	private static final int MINPRIORITYTOEDITNEWPERSON = 1;
	private static final int MINPRIORITYTODELETE = 1;
	private static final int MINPRIORITYTOADDOTHERACCOUNTS = 1;
	private static final int EdytujZaznaczonaBaze = 1;
	private static final int ShowGroup = 1;
	private static final int butAddPersonToSpoleczenstwo = 1;
	private static final int butSaveEdites = 1;
	private static final int EditSpolVars = 1;
	private static final int butDeleteSelectedPersonFromSpol = 1;
	private static final int deletePersonByName = 1;
	private static final int UsunObiekt = 1;
	private static final int MINPRIORITYTOCHANGEPASSWORD = 2;
	
	
	private Login loginBase;
	private String pass="";
	
	public Management(Login log, String password) {
		this.loginBase = log;
		this.pass = password;
	}
	
	
	
	
	public  boolean canIEdytujZaznaczonaBaze(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>EdytujZaznaczonaBaze) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		
		return false;
	}
	public  boolean canIbutShowGroup(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>ShowGroup) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		
		return false;
	}
	public  boolean canIbutAddPersonToSpoleczenstwo(Accounts acc)
	{
		if(acc != null)
		{
				if(acc.isLoged() && acc.getPriority()>butAddPersonToSpoleczenstwo) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

	
		return false;
	}
	public  boolean canIbutSaveEdites(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>butSaveEdites) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		
		return false;
	}
	public  boolean canIEditSpolVars(Accounts acc)
	{
		if(acc != null)
		{
				if(acc.isLoged() && acc.getPriority()>EditSpolVars) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

	
		return false;
	}
	public  boolean canIbutDeleteSelectedPersonFromSpol(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>butDeleteSelectedPersonFromSpol) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		return false;
	}
	
	public  boolean canIdeletePersonByName(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>deletePersonByName) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		
		return false;
	}
	
	public  boolean canIUsunObiekt(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>UsunObiekt) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		
		return false;
	}
	
	
	public static boolean canIMakeNewSpoleczentwo(Accounts acc)
	{
		if(acc != null)
		{
			if(acc.isLoged() && acc.getPriority()>MINPRIORITYTOADDNEWSPOLECZENTWO) return true;
		}else  JOptionPane.showMessageDialog( null, "Brak Dostêpu");

		
		return false;
	}
	public static void addNewPersonToSpoleczenstwo(Accounts acc, Spoleczenstwo spol, Persona pers)
	{
		if(acc.isLoged() && acc.getPriority()>MINPRIORITYTOADDNEWPERSON) spol.addPersona(pers);;
		
		
	}
	
	public static void editPersonInSpoleczenstwo(Accounts acc,Spoleczenstwo spol, int whoId,  Persona newPerson)
	{
		if(acc.isLoged() && acc.getPriority()>MINPRIORITYTOEDITNEWPERSON) spol.updateOnePerson(whoId, newPerson);;
		
		
	}
	
	public static boolean canIDeleteSomething(Accounts acc)
	{
		if(acc.isLoged() && acc.getPriority()>MINPRIORITYTODELETE) return true;
		return false;
	}
	public static boolean canIDchangePass(Accounts acc)
	{
		if(acc.isLoged() && acc.getPriority()>MINPRIORITYTOCHANGEPASSWORD) return true;
		return false;
	}
	public void addNewAccount(Accounts acc, String newLogin, String newPassword, String priority)
	{
		if(acc.isLoged() && acc.getPriority()>MINPRIORITYTOADDOTHERACCOUNTS) 
			if(!makeAccount(newLogin,newPassword,priority)) 
				System.out.println("failure in adding new account");
	}
	
	
	private boolean makeAccount(String newLogin, String newPassword, String priority)
	{
		try {
			this.loginBase.addNewAccount(newLogin, newPassword, priority);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean CanIDoSomething()
	{
		 String name = JOptionPane.showInputDialog("Podaj has³o dostêpu...");
		 if(name.equals(pass)) return true;
		 else return false;
	}
	
}
