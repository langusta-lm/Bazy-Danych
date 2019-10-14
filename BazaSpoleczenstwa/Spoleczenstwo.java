package fat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
public class Spoleczenstwo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> pojemnik = new ArrayList<Persona>();
	private int id=0;
	private String Nazwa;
	private String narodowosc;
	private String wyznanie;
	private String typ;
	private int stopienRozwoju;
	private int formaSpoleczenstwa;
	public String type = "spoleczenstwo";
	private static int ilosczmiennych = 6;
	private DefaultTableModel tableModel;
	
	public static String getTitleOfVar(int i) {
		switch (i) {
		case 0:
			return "Nazwa";
			
		case 1:
			return "narodowosc";
			
		case 2:
			return "wyznanie";
			
		case 3:
			return "typ";
			
		case 4:
			return "stopienRozwoju";

		case 5:
			return "formaSpoleczenstwa";
		
		default:
			
			return "";
	}
	}
	private void initTableModel ()
	{
		tableModel = new DefaultTableModel(this.getNamesPojemnik(), 0);
		
	}
	
	public DefaultTableModel getTableModel ()
	{
		return tableModel;
	}
	public boolean addPersona(Persona person)
	{
		for (Persona persona : pojemnik) {
			if (persona.equals(person)) {
				System.out.println("ta osoba juz istnieje");
				JOptionPane.showInternalMessageDialog(null, "Ta osoba ju¿ istnieje w tym kontenerze");
				return false;
			}
		}
		int id =0;
		/*
		this.pojemnik.add(person);
		tableModel.addRow(person.getData());
		releaseId();
		/**//*
		if(pojemnik.size() > 0) id = this.pojemnik.get(pojemnik.size()-1).getId();
		try {
			person.setId(pojemnik.get(pojemnik.size()).getId()+1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(pojemnik.size() < 1) person.setId(1);
		//for (int i = 0; i < pojemnik.size(); i++) {
		//	if (pojemnik.get(i).getId() == person.getId() ) person.setId(person.getId()+1);
		//}*/
		this.pojemnik.add(person);
		tableModel.addRow(person.getData(true));
		releaseId();
		return true;
	}
	
	
	public void reloadTableModel ()
	{
		int index = tableModel.getRowCount();
		while (index > 0)
		{
			tableModel.removeRow(index-1);
			index--;
		}

		for (Persona persona : pojemnik) {
			tableModel.addRow(persona.getData(true));
		}
	}
	private void releaseId()
	{
		for (int i = 0; i < this.pojemnik.size(); i++) {
			this.pojemnik.get(i).setId(i);
		}
		reloadTableModel();
	}
	
	public Persona getPersonOnIndex (int index)
	{
		try {
			return pojemnik.get(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Persona getPersonById (int id)
	{
		for (Persona persona : pojemnik) {
			if (persona.getId() == id) return persona;
		}
		return null;
	}
	public Persona getPersonByName (String name)
	{
		for (Persona persona : pojemnik) {
			if (persona.getName().equals(name)) return persona;
		}
		return null;
	}
	
	
	public ArrayList<Persona> getPersonsFromSpoleczenstwo()
	{
		return this.pojemnik;
	}
	
	public int getSizeOfSpoleczenstwo()
	{
		return (int) this.pojemnik.size();
	}
	
	public void updateOnePerson (int whoId, Persona newPerson)
	{
		for (int i = 0; i < this.pojemnik.size(); i++) {
			if (pojemnik.get(i).getId() == whoId)
			{
				pojemnik.set(i, newPerson);
			}
		}
		System.out.println(this.pojemnik.size());
	}
	
	public void updateOnePerson (Persona oldPerson, Persona newPerson)
	{
		System.out.println(oldPerson + "  dd  "+ newPerson);
		for (int i = 0; i < this.pojemnik.size(); i++) {
			if (pojemnik.get(i).equals(oldPerson))
			{
				System.out.println("udalo sie zaktualizwoac");
				
				pojemnik.set(i, newPerson);
				reloadTableModel();
			}
		}
		//
	}
	
	public void remowePersonById(int whoId)
	{
		for (int i = 0; i < this.pojemnik.size(); i++) {
			if (pojemnik.get(i).getId() == whoId)
			{
				pojemnik.remove(i);
				break;
			}
		} 
		
		
		releaseId();	
		//reloadTableModel();
	}
	


	public Object[][] getDataPojemnik ()
	{
		Object[][] data = new Object[this.pojemnik.size()][pojemnik.get(0).getData(true).length];
		for (int i = 0; i < this.pojemnik.size(); i++) {
			 data[i] = pojemnik.get(i).getData(true);
		}
		
		 return data;
	}
	
	public DefaultTableModel getData(boolean pow)
	{
		DefaultTableModel tableModel = new DefaultTableModel(getTitles(), 0);
	
		if(pow)
		{
			tableModel.addRow( new Object[] {this.getId(), 
					this.getNazwa(),this.getNarodowosc(), 
					this.getWyznanie(), this.getTyp(), 
					BazaTypow.stopienRozwojuSpoleczenstwa[this.getStopienRozwoju()], 
					BazaTypow.formySpoleczenstwaI[this.getFormaSpoleczenstwa()]});
		}
		else
		{
			tableModel.addRow( new Object[] {this.getId(), 
					this.getNazwa(),this.getNarodowosc(), 
					this.getWyznanie(), this.getTyp(), 
					this.getStopienRozwoju(), this.getFormaSpoleczenstwa()});
		}
		
		
		
		return tableModel;
	}
	
	public Spoleczenstwo(int id, String nazwa, String narodowosc, String wyznanie, String typ, int stRozw, int forSpole) {
		this.initTableModel();
		setId(id);
		setNazwa(nazwa);
		setNarodowosc(narodowosc);
		setWyznanie(wyznanie);
		setTyp(typ);
		setStopienRozwoju(stRozw);
		setFormaSpoleczenstwa(forSpole);
	}
	public Spoleczenstwo(String value, String value2, String value3, String value4, String value5, String value6) {
		this.initTableModel();
		setNazwa(value);
		setNarodowosc(value2);
		setWyznanie(value3);
		setTyp(value4);
		setStopienRozwoju(Integer.parseInt(value5));
		setFormaSpoleczenstwa(Integer.parseInt(value6));
	}

	public static Object[] getTitles ()
	{
		return new Object[] {"id","Nazwa","narodowosc","wyznanie","typ","stopienRozwoju","formaSpoleczenstwa"};
	}
	public void AutomatedSettlerOfRandomPerson(int howMuchPersons)
	{
		ArrayList<Persona> temp = new ArrayList<Persona>();
		temp.addAll(RandomGenerator.getRandomArrayOfPersons(howMuchPersons));
		
		for (Persona osoba : temp) {
			addPersona(osoba);
		}
		releaseId();
	}
	
	public void addArrayOfPersons(ArrayList<Persona> arrOfNewPersons)
	{
		for (Persona persona : arrOfNewPersons) {
			addPersona(persona);
		}
	}
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	

	public Object[] getNamesPojemnik ()
	{
		return Persona.getTitles();
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}

	public String getNarodowosc() {
		return narodowosc;
	}

	public void setNarodowosc(String narodowosc) {
		this.narodowosc = narodowosc;
	}

	public String getWyznanie() {
		return wyznanie;
	}

	public void setWyznanie(String wyznanie) {
		this.wyznanie = wyznanie;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getStopienRozwoju() {
		return stopienRozwoju;
	}

	public void setStopienRozwoju(int stopienRozwoju) {
		this.stopienRozwoju = stopienRozwoju;
	}
	public void setStopienRozwoju(String stopienRozwoju) {
		
		this.stopienRozwoju = Integer.parseInt(stopienRozwoju);
	}
	

	public int getFormaSpoleczenstwa() {
		return formaSpoleczenstwa;
	}

	public void setFormaSpoleczenstwa(int formaSpoleczenstwa) {
		this.formaSpoleczenstwa = formaSpoleczenstwa;
	}
	public void setFormaSpoleczenstwa(String formaSpoleczenstwa) {
		this.formaSpoleczenstwa = Integer.parseInt(formaSpoleczenstwa);
	}
	
	
	public static int jakDuzoZmiennych() {
		
		return ilosczmiennych;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId() + this.getNarodowosc() + this.getNazwa() + this.getFormaSpoleczenstwa() +
				this.getStopienRozwoju() + this.getTyp() + this.getWyznanie() + this.getSizeOfSpoleczenstwo();
	}
}
	
	
	

