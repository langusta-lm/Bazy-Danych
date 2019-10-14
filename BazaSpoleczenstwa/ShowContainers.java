package fat;

import java.util.ArrayList;
import java.util.Vector;

public class ShowContainers {
	private ArrayList<Persona> arrOfPersons = new ArrayList<Persona>();
	private ArrayList<Spoleczenstwo> arrOfSpoleczenstwos = new ArrayList<Spoleczenstwo>();
	private ArrayList<Zawod> arrOfZawods = new ArrayList<Zawod>();
	private ArrayList<Wyksztalcenie> arrOfWyksztalcenies = new ArrayList<Wyksztalcenie>();
	
	public void addSpoleczenstwo(Spoleczenstwo spol)
	{
		arrOfSpoleczenstwos.add(spol);
	}
	
	public void addPersona(Persona person)
	{
		arrOfPersons.add(person);
	}
	
	public Spoleczenstwo getSpolByName(String name)
	{
		for (Spoleczenstwo spol : arrOfSpoleczenstwos) {
			if (spol.getNazwa().equals(name))
			{
				//System.out.println("sunia");
				return spol;
			}
				
			
		}
		return null;
	}
	public Spoleczenstwo getSpolById(int ID)
	{
		for (Spoleczenstwo spol : arrOfSpoleczenstwos) {
			if (spol.getId() == ID)
			{
				//System.out.println("sunia");
				return spol;
			}
				
			
		}
		return null;
	}
	public Persona getPersByName(String name)
	{
		for (Persona temp : arrOfPersons) {
			
			if (temp.getName().equals(name))
			{
				//System.out.println("sunia");
				return temp;
			}
				
			
		}
		return null;
	}
	public void findPersonEndEdit(Persona oldPerson, Persona newPerson)
	{
		for (Spoleczenstwo spol : arrOfSpoleczenstwos) {
			spol.updateOnePerson(oldPerson, newPerson);
			
		}
	}
	public Object[] getStringOfPersons()
	{
		Object[] str = new String[arrOfPersons.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = arrOfPersons.get(i).getName();
		}
		return str;
	}
	public Object[] getStringOfSpoleczenstwo()
	{
		
		Object[] str = new String[arrOfSpoleczenstwos.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = arrOfSpoleczenstwos.get(i).getNazwa();
		}
		return str;
	}
	
	public Persona getPersonByIndex(int index)
	{
		return arrOfPersons.get(index);
	}
	public Persona getPersonFromSpoleczenstwaByName(String name)
	{
		Persona temp = null;
		for (Spoleczenstwo spol : arrOfSpoleczenstwos) {
			
			temp = spol.getPersonByName(name);
			if (temp != null) return temp;
		}
		return null;
	}
	public Spoleczenstwo getSpoleczenstwoByIndex (int index)
	{
		return arrOfSpoleczenstwos.get(index);
	}
	
	public ShowContainers() 
	{
		// TODO Auto-generated constructor stub
	}
	
	
	public void deletePersonByName(String name)
	{
		for (Spoleczenstwo spol : arrOfSpoleczenstwos) {
			
			if(spol.getPersonByName(name) != null)
				spol.remowePersonById(spol.getPersonByName(name).getId());
		}
	}
	public void deleteSpoleByName(String name)
	{
		for (int i=0; i< arrOfSpoleczenstwos.size(); i++) {
			
			if(arrOfSpoleczenstwos.get(i).getNazwa().equals(name))
				arrOfSpoleczenstwos.remove(i);
		}
	}
	
	
	public Spoleczenstwo getSpolByIndex (int index)
	{
		return this.arrOfSpoleczenstwos.get(index);
	}

	public ArrayList<Spoleczenstwo> getArrOfSpoleczenstwos() {
		return arrOfSpoleczenstwos;
	}

	public ArrayList<Persona> getArrOfPersons() {
		return arrOfPersons;
	}
}
