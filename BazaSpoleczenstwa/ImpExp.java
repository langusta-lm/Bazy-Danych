package fat;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ImpExp {
	private static String PASSWORD = "";
	
	
	public ImpExp(String setPassword) {
		this.PASSWORD = setPassword;
	}
	
	@SuppressWarnings("finally")
	public ArrayList<Persona> ReadPersonsFromFile( String filepath)
	{
		String name = JOptionPane.showInputDialog("Podaj has這 dost瘼u...");
		 if(name.equals(this.PASSWORD))
		{
			Persona temp =null;
			ArrayList<Persona> tempArr = new ArrayList<Persona>();
			try 
			{
				FileInputStream fileOut = new FileInputStream(filepath);
				ObjectInputStream objectIn = new ObjectInputStream(fileOut);
				try 
				{
					while(true)
					{
						temp =  (Persona) objectIn.readObject();
						tempArr.add(temp);
					}
				
				} finally 
				{
					return tempArr;
				} 
			
			} catch (Exception e) 
			{
				System.out.println("error wczytywania pers: "+e);
			}
			
			System.out.println("The Object  was succesfully readen to a file");
			
		} else System.out.println("bad password");
	return null;
	}
	
	public  void WritePersonsToFile( ArrayList<Persona> arrayToWrite, String filepath) {
	 
		String name = JOptionPane.showInputDialog("Podaj has這 dost瘼u...");
		 if(name.equals(this.PASSWORD))
		{
			try {
	 
				FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
				for (Persona persona : arrayToWrite) 
				{
					objectOut.writeObject(persona);
				}
			
				objectOut.close();
			
			} catch (Exception ex) {
	            ex.printStackTrace();
			}
			System.out.println("The Object  was succesfully written to a file");
		}else System.out.println("bad password");
		
	}
	public  void WritePersonaToFile( Persona ToWrite, String filepath) {
		 
		String name = JOptionPane.showInputDialog("Podaj has這 dost瘼u...");
		 if(name.equals(this.PASSWORD))
		{
			try {
	 
				FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
				
					objectOut.writeObject(ToWrite);
				
			
				objectOut.close();
			
			} catch (Exception ex) {
	            ex.printStackTrace();
			}
			System.out.println("The Object  was succesfully written to a file");
		}else System.out.println("bad password");
		
	}
	public  void WriteSpoleczenstwoToFile( Spoleczenstwo ToWrite, String filepath) {
		 
		String name = JOptionPane.showInputDialog("Podaj has這 dost瘼u...");
		 if(name.equals(this.PASSWORD))
		{
			try {
	 
				FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
				objectOut.writeObject(ToWrite);
				
			
				objectOut.close();
			
			} catch (Exception ex) {
	            ex.printStackTrace();
			}
			System.out.println("The Object  was succesfully written to a file");
		}else 
			System.out.println("bad password");
		
	}
	
	public void WritePersSpolsToFile (ArrayList<Persona> arrPers, ArrayList<Spoleczenstwo> arrSpol, String filepath) 
	{
		int sizePers = arrPers.size();
		int sizeSpol = arrSpol.size();
		
		String name = JOptionPane.showInputDialog("Podaj has這 dost瘼u...");
		 if(name.equals(this.PASSWORD))
		{
			try {
	 
				FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			
				//objectOut.writeObject(sizePers);
				//objectOut.writeObject(sizeSpol);
			
				for (Persona temp : arrPers) 
				{
					try {
						objectOut.writeObject(temp);
						System.out.println(temp);
					} catch (Exception e) {
						System.out.println("person    "+e);
					}
					
				}
				for (Spoleczenstwo temp1 : arrSpol) 
				{
					try {
						objectOut.writeObject(temp1);
						System.out.println(temp1);
					} catch (Exception e) {
						System.out.println("spopl   "+e);
					}
					
				}
				
				
				objectOut.close();
			
			} catch (Exception ex) {
	            ex.printStackTrace();
			}
			System.out.println("The Object  was succesfully written to a file");
		}else 
			System.out.println("bad password");
		
		
	}
	
	public void ReadPersSpolsToFile (Gui gui, String filepath)
	{
		String name = JOptionPane.showInputDialog("Podaj has這 dost瘼u...");
		 if(name.equals(this.PASSWORD))
		{
			Persona temp =null;
			int sizePers=0;
			int sizeSpol=0;
			ArrayList<Persona> tempPers = new ArrayList<Persona>();
			ArrayList<Spoleczenstwo> tempSpol = new ArrayList<Spoleczenstwo>();
			Object tempObj = new Object();
			try 
			{
				FileInputStream fileOut = new FileInputStream(filepath);
				ObjectInputStream objectIn = new ObjectInputStream(fileOut);
				try 
				{
					while(true)
					{
						tempObj = objectIn.readObject();
						if(tempObj.getClass() == Persona.class)
						{
							tempPers.add((Persona) tempObj);
						}
						if(tempObj.getClass() == Spoleczenstwo.class)
						{
							tempSpol.add((Spoleczenstwo) tempObj);
						}
						
						
					}
				
				} catch (Exception e) {
					System.out.println("persoSpol   "+e);
				}
				/*try 
				{
					while(true)
					{
						tempSpol.add((Spoleczenstwo) objectIn.readObject());
					}
				
				} catch (Exception e) {
					System.out.println("spopl   "+e);
				}*/
				
			
			} catch (Exception e) 
			{
				System.out.println("error wczytywania : "+e);
			}
			
			
			
			for (Persona pers : tempPers) {
				gui.addPerson(pers);
				//System.out.println("pers" + pers);
			}
			for (Spoleczenstwo spol : tempSpol) {
				gui.addSpoleczenstwo(spol);
				System.out.println("spol" + spol);
			}
			System.out.println("The Object  was succesfully readen to a file");
			
		} else System.out.println("bad password");

		
		
		
	}
	
	
	
}
