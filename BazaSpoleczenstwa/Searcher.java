package fat;

import java.util.ArrayList;

public class Searcher {

	public Searcher() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static ArrayList<Persona> findPersonsById (ArrayList<Persona> WhereIMustFind, String minid, String maxid)
	{
		int minId, maxId;
		if (minid != null)  minId = Integer.parseInt(minid);
		else minId = 0;
		if (maxid != null) maxId =Integer.parseInt(maxid);
		else maxId = 0;
		
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getId() >= minId && persona.getId() <= maxId)
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	
	public static ArrayList<Persona> findPersonsByName (ArrayList<Persona> WhereIMustFind, String imie)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getName().equals(imie))
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	
	public static ArrayList<Persona> findPersonsBySurname (ArrayList<Persona> WhereIMustFind, String surname)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getSurname().equals(surname))
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	
	public static ArrayList<Persona> findPersonsByWiek (ArrayList<Persona> WhereIMustFind, int minWiek, int maxWiek)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getWiek() >= minWiek && persona.getWiek() <= maxWiek)
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	
	public static ArrayList<Persona> findPersonsByPesel (ArrayList<Persona> WhereIMustFind, int minPesel, int maxPesel)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getPesel() >= minPesel && persona.getPesel() <= maxPesel)
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	
	public static ArrayList<Persona> findPersonsByZarobki (ArrayList<Persona> WhereIMustFind, int minZarobki, int maxZarobki)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getZarobki() >= minZarobki && persona.getZarobki() <= maxZarobki)
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	public static ArrayList<Persona> findPersonsByidZawodu (ArrayList<Persona> WhereIMustFind, int minZarobki, int maxZarobki)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getIdZawodu() >= minZarobki && persona.getIdZawodu() <= maxZarobki)
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	public static ArrayList<Persona> findPersonsByidWyksztalcenia (ArrayList<Persona> WhereIMustFind, int minZarobki, int maxZarobki)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		for (Persona persona : WhereIMustFind) {
			if (persona.getIdWyksztalcenia() >= minZarobki && persona.getIdWyksztalcenia() <= maxZarobki)
			{
				temp.add(persona);
			}	
		}
		return temp;
	}
	
	
	
}
