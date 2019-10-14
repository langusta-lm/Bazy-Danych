package fat;

import java.io.IOException;
import java.util.Comparator;



public class ComparPersons implements Comparator<Persona>
{
	private int index;
	
	public ComparPersons(int index) {
		this.index = index;
	}

	@Override
	public int compare(Persona arg0, Persona arg1) {
		switch (index) {
		case 0:
			return  arg0.getId() -  arg1.getId();
		case 1:
			return arg0.getName().compareTo(arg1.getName());
			
		case 2:
			return arg0.getSurname().compareTo(arg1.getSurname());
			
		case 3:
			return  arg0.getWiek() -  arg1.getWiek();
			
		case 4:
			return  arg0.getPesel() -  arg1.getPesel();

		case 5:
			return  ( (int) arg0.getZarobki() -  (int)arg1.getZarobki() );
		
		default:
			
			return 0;
		}
		
	}
}
