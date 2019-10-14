package fat;

import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
	static public int leftLimit = 97; 				// 'a'
	static public int rightLimit = 122; 			// 'z'
	
	
	public static void setLeftLimit(int leftLimit) {
		RandomGenerator.leftLimit = leftLimit;
	}
	public static void setRightLimit(int rightLimit) {
		RandomGenerator.rightLimit = rightLimit;
	}
    static public String GetRandomString(int howLongString, int minLongString) {
	    Random random = new Random();
	    int strLenght = getRandomInt(howLongString, minLongString);
	    StringBuilder buffer = new StringBuilder(strLenght);
	    for (int i = 0; i < strLenght; i++) {
	    	try {
				int randomLimitedInt = leftLimit + (int)  (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
	        
			} catch (Exception e) {
			}
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
	}

	static public int getRandomInt(int range, int MinValue)
	{
		return (int) (Math.random() * range + MinValue);
	}
	
	
	static public double getRandomDouble(int range, int MinValue)
	{
		return (double) (Math.random() * range + MinValue);
	}
	
	
	public RandomGenerator(char minLitera, char maxLitera, int dlugoscStringa) {
		setLeftLimit((int) minLitera);
		setRightLimit((int) maxLitera);
		
	}
	
	
	public RandomGenerator() {
		
	}

	static public ArrayList<Persona> getRandomArrayOfPersons(long count)
	{
		ArrayList<Persona> randomPersons = new ArrayList<Persona>();
		
		for(int index=0; index<count; index++)
		{
			randomPersons.add(getRandomPerson());
		}
		return randomPersons;
	}
	
	static public Persona getRandomPerson()
	{
		return new Persona(0, 
				GetRandomString(4,3), 
				GetRandomString(4,3), 
				getRandomInt(199999999, 800000000), 
				getRandomDouble(1000, 8000),
				getRandomInt(BazaTypow.zawody.length-1,0),
				getRandomInt(BazaTypow.Wyksztalcenia.length-1,0)
				);
	}
	
	static public Spoleczenstwo getRandomSpoleczenstwo()
	{
		Spoleczenstwo grupaLudzi = new Spoleczenstwo(0,
				GetRandomString(7, 4),
				GetRandomString(7, 4),
				GetRandomString(7, 4),
				GetRandomString(7, 4),
				getRandomInt(BazaTypow.stopienRozwojuSpoleczenstwa.length-1,0),
				getRandomInt(BazaTypow.formySpoleczenstwaI.length-1,0));
		grupaLudzi.AutomatedSettlerOfRandomPerson(getRandomInt(100, 30));
		return grupaLudzi;
	}
	
	
	
}
