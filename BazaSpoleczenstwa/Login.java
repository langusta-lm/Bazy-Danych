package fat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Login 
{
	private ArrayList<Accounts> arrOfAccounts = new ArrayList<Accounts>();
	private int hashs;
	private String filepath = "infos.cds";
	
	public Login() 
	{
		hashs = RandomGenerator.getRandomInt(2000, 4);
		File czarneOczy = new File(filepath);
		if(czarneOczy.isFile())
		{
			//System.out.println("pobieranie informacji o kontach...");
			loadInfo();
		}
		
	}
	
	public void logOut(Accounts acc)
	{
		if (acc.isLoged()) acc.setLoged(false);
		
	}
	
	public void addNewAccount(String log, String pass, String prio)
	{
		pass += hashs;
		arrOfAccounts.add(new Accounts(log, pass, Integer.parseInt(prio)));
		JOptionPane.showMessageDialog( null, "Zarejestrowano pomyœlnie ");
		System.out.println("Rejestracja powiod³a siê");
	}
	
	
	public Accounts tryLogin(String log, String pass)
	{
		for (Accounts acc : arrOfAccounts) {
			if (acc.getLogin().equals(log))
			{
				if(tryPass(acc,pass))
				{
					acc.setLoged(true);
					JOptionPane.showMessageDialog( null, "Zalogowano pomyœlnie ");
					return acc;
				}
					
				else
				{
					System.out.println("zle haslo");
				}
			}
		}
		System.out.println("nie odnaleziono loginu");
		return null;
	}
	
	private boolean tryPass(Accounts acc, String pass)
	{
		pass += hashs;
		if (acc.getPassword().equals(pass)) return true;
		return false;
	}
	
	public void saveInfo()
	{
		
		try {
			 
			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		
			objectOut.writeInt(hashs);
			for (Accounts acc : arrOfAccounts) 
			{
				objectOut.writeObject(acc);
			}
		
			objectOut.close();
		
		} catch (Exception ex) {
            ex.printStackTrace();
		}
		
		
	}
	
	public void loadInfo()
	{
		
		int hash=0;
		ArrayList<Accounts> tempArr = new ArrayList<Accounts>();
		try 
		{
			FileInputStream fileOut = new FileInputStream(filepath);
			
			ObjectInputStream objectIn = new ObjectInputStream(fileOut);
			try 
			{
				hash = objectIn.readInt();
				while(true)
				{
					tempArr.add((Accounts) objectIn.readObject());
				}
				
			} catch (Exception e) {
			//	System.out.println("wczytywania kont: "+e);
			} 
			 
		
		} catch (Exception e) 
		{
			System.out.println("error wczytywania infosu: "+e);
		}
		
		arrOfAccounts.addAll(tempArr);
		this.hashs = hash;
		
		
		
	}
	
}
