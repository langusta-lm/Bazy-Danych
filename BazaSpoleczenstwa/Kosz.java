package fat;

import java.util.ArrayList;

public class Kosz {
	private static ArrayList<Persona> arrOfPersons = new ArrayList<Persona>();
	private static ArrayList<Spoleczenstwo> arrOfSpoleczenstwos = new ArrayList<Spoleczenstwo>();
	private static ArrayList<Zawod> arrOfZawods = new ArrayList<Zawod>();
	private static ArrayList<Wyksztalcenie> arrOfWyksztalcenies = new ArrayList<Wyksztalcenie>();
	
	public static void toTrash(Persona temp)
	{
		arrOfPersons.add(temp);
	}
	public static void toTrash(Spoleczenstwo temp)
	{
		arrOfSpoleczenstwos.add(temp);
	}
	public static void toTrash(Zawod temp)
	{
		arrOfZawods.add(temp);
	}
	public static void toTrash(Wyksztalcenie temp)
	{
		arrOfWyksztalcenies.add(temp);
	}

	
	public static Persona getPersonByIndex(int index)
	{
		Persona temp=null;
		
		try {
			temp = arrOfPersons.get(index);
			arrOfPersons.remove(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return temp;
	}
	public static Spoleczenstwo getSpoleczenstwoByIndex(int index)
	{
		Spoleczenstwo temp=null;
		
		try {
			temp = arrOfSpoleczenstwos.get(index);
			arrOfSpoleczenstwos.remove(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return temp;
	}
	public static Zawod getZawodByIndex(int index)
	{
		Zawod temp=null;
		
		try {
			temp = arrOfZawods.get(index);
			arrOfZawods.remove(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return temp;
	}
	public static Wyksztalcenie getWyksztalcenieByIndex(int index)
	{
		Wyksztalcenie temp=null;
		
		try {
			temp = arrOfWyksztalcenies.get(index);
			arrOfWyksztalcenies.remove(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return temp;
	}
	
	@Override
	public String toString() 
	{
		String temp ="";
		
		temp += "\nTrashOfPersons: ";
		for (Persona var : arrOfPersons) {
			temp += "\nId: " + var.getId();
		}
		temp += "\nTrashOfSpoleczenstwo: ";
		for (Spoleczenstwo var : arrOfSpoleczenstwos) {
			temp += "\nId: " +  var.getId();
		}
		temp += "\nTrashOfZawod: ";
		for (Zawod var : arrOfZawods) {
			temp += "\nId: " + var.getId();
		}
		temp += "\nTrashOfWyksztalcenie: ";
		for (Wyksztalcenie var : arrOfWyksztalcenies) {
			temp += "\nId: " + var.getId();
		}
		
		
		return temp;
	}
	
	public int getSizeOfKosz()
	{
		return arrOfPersons.size()+arrOfSpoleczenstwos.size()+arrOfZawods.size()+arrOfWyksztalcenies.size();
	}
	
	
	
}
