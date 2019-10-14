package fat;

import java.io.Serializable;

import javax.swing.table.DefaultTableModel;

public class Persona  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Id=0;
	private String name="null";
	private String surname="null";
	private int wiek=0;
	private int pesel=0;
	private double zarobki=0;
	private int idZawodu=0;
	private int idWyksztalcenia=0;
	private static int iloscZmiennych =8;
	public  String type = "persona";
	private DefaultTableModel tableModel;
	
	private void initTableModel ()
	{
		tableModel = new DefaultTableModel(this.getTitles(), 0);
		tableModel.addRow(getData(true));
	}
	public DefaultTableModel getTableModel ()
	{
		tableModel = new DefaultTableModel(this.getTitles(), 0);
		tableModel.addRow(getData(true));
		return tableModel;
	}
	
	public void reloadTableModel ()
	{
		int index = tableModel.getRowCount();
		while (index > 0)
		{
			tableModel.removeRow(index-1);
			index--;
		}

		
		tableModel.addRow(this.getData(true));
		
	}
	
	public static String getTitleOfVar(int index)
	{
		switch (index) {
		case 0:
			return "Id";
			
		case 1:
			return "name";
			
		case 2:
			return "surname";
			
		case 3:
			return "wiek";
			
		case 4:
			return "pesel";

		case 5:
			return "zarobki";
			
		case 6:
			return "idZawodu";
			
		case 7:
			return "idWyksztalcenia";
		
		default:
			
			return "";
	}}
	public Persona() {
		setId(1);
		setName("imie");
		setSurname("nazwisko");
		setWiek(1);
		setPesel(1);
		setZarobki(1);
		setIdZawodu(1);
		setIdWyksztalcenia(1);
		this.initTableModel();
	}
	public Persona(Persona pers) {
		setId(pers.getId());
		setName(pers.getName());
		setSurname(pers.getSurname());
		setWiek(pers.getWiek());
		setPesel(pers.getPesel());
		setZarobki(pers.getZarobki());
		setIdZawodu(pers.getIdZawodu());
		setIdWyksztalcenia(pers.getIdWyksztalcenia());
		this.initTableModel();
	}
	public Persona (int id, String name, String surname, int pesel, double zarobki, int idZawodu, int idWyksztalcenia)
	{
		setId(id);
		setName(name);
		setSurname(surname);
		setWiek(2019 - (1900 +(pesel /10000000)));
		setPesel(pesel);
		setZarobki(zarobki);
		setIdZawodu(idZawodu);
		setIdWyksztalcenia(idWyksztalcenia);
		
		this.initTableModel();
	}
	
	public Persona(String value, String value2, String value3, String value4, String value5, String value6,
			String value7, String value8) {
		
		setId(Integer.parseInt( value));
		setName(value2);
		setSurname(value3);
		setWiek(2019 - (1900 +(Integer.parseInt(value5) /10000000)));
		setPesel(Integer.parseInt(value5));
		setZarobki(Double.parseDouble(value6));
		setIdZawodu(Integer.parseInt(value7));
		setIdWyksztalcenia(Integer.parseInt(value8));
	}
	public Object getValueOf (int index)
	{
		switch (index) {
		case 0:
			return getId();
			
		case 1:
			return getName();
			
		case 2:
			return getSurname();
			
		case 3:
			return getWiek();
			
		case 4:
			return getPesel();

		case 5:
			return getZarobki();
		
		default:
			
			return null;
		}
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String cap = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.name = cap;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		String cap = surname.substring(0, 1).toUpperCase() + surname.substring(1);
		this.surname = cap;
	}
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}
	public int getPesel() {
		return pesel;
	}
	public void setPesel(int pesel) {
		this.pesel = pesel;
	}
	public double getZarobki() {
		return zarobki;
	}
	public void setZarobki(double zarobki) {
		this.zarobki = zarobki;
	}
	public void setZarobki(String zarobki) {
		this.zarobki = Double.parseDouble(zarobki);
	}
	
	
	public static String[] getTitles()
	{
		String tab[] = {"Id","Imie","Nazwisko","Wiek","Pesel","Zarobki","ID Zawodu", "ID Wyksztalcenia" };
		return tab;
	}
	@Override
	public String toString() {
		return "\nid: "+this.Id+ "\nimie: "+this.name + "\nnazwisko: "+this.surname + 
				"\nwiek: "+this.wiek + "\npesel: "+this.pesel + "\nzarobki: "+this.zarobki+
				"\nID Zawodu: "+this.getIdZawodu()+"\nID Wyksztalcenia: "+this.getIdWyksztalcenia();
	}
	
	public Object[] getData(boolean Powiazac)
	{
		if(Powiazac)
		{
			Object tab[] = {this.getId(), 
					this.getName(),
					this.getSurname(),
					this.getWiek(),
					this.getPesel(),
					this.getZarobki(),
					BazaTypow.zawody[this.getIdZawodu()],
					BazaTypow.Wyksztalcenia[this.getIdWyksztalcenia()]};

			return tab;
		}else
		{
			Object tab[] = {this.getId(), 
						this.getName(),
						this.getSurname(),
						this.getWiek(),
						this.getPesel(),
						this.getZarobki(),
						this.getIdZawodu(),
						this.getIdWyksztalcenia()};

			return tab;
		}
		
		
	}
	
	public String[] getDataString()
	{
		String tab[] = {Integer.toString(this.getId()), 
						this.getName(),
						this.getSurname(),
						Integer.toString(this.getWiek()),
						Integer.toString(this.getPesel()),
						Double.toString(this.getZarobki()),
						Integer.toString(this.getIdZawodu()),
						Integer.toString(this.getIdWyksztalcenia())};
		return tab;
	}
	public Object[][] getDataa()
	{
		Object tab[][] = {{this.getId(), 
						this.getName(),
						this.getSurname(),
						this.getWiek(),
						this.getPesel(),
						this.getZarobki(),
						this.getIdZawodu(),
						this.getIdWyksztalcenia()},{}};
		return tab;
	}
	public int getIdZawodu() {
		return idZawodu;
	}

	public void setIdZawodu(int idZawodu) {
		this.idZawodu = idZawodu;
	}
	public void setIdZawodu(String idZawodu) {
		this.idZawodu = Integer.parseInt(idZawodu);
	}
	public int getIdWyksztalcenia() {
		return idWyksztalcenia;
	}

	public void setIdWyksztalcenia(int idWyksztalcenia) {
		this.idWyksztalcenia = idWyksztalcenia;
	}
	public void setIdWyksztalcenia(String idWyksztalcenia) {
		this.idWyksztalcenia =Integer.parseInt(idWyksztalcenia);
	}
	public static int jakDuzoZmiennych()
	{
		return iloscZmiennych;
	}
}
