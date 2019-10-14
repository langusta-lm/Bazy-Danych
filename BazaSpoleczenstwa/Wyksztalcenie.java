package fat;

public class Wyksztalcenie {
	private int id = 0;
	private String nazwa = "";
	private String[] tablica = {"podstawowe","gimnazjalne","zasadnicze","œrednie","wy¿sze"};
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getTablica() {
		return tablica;
	}
	public void setTablica(String[] tablica) {
		this.tablica = tablica;
	}

}
