package fat;

import java.awt.print.PrinterException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Wydruk extends JFrame{

	
	String[] columns = new String[] {
            "Id", "Name", "Hourly Rate", "Part Time"
        };
	Object[][] data = new Object[][] {
            {1, "John", 40.0, false },
            {2, "Rambo", 70.0, false },
            {3, "Zorro", 60.0, true },
        };
        
        
	public JTable table= new JTable(data, columns);
	
	
	public  void druknijJTable()
	{
		try {
			table.print();
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  Wydruk()
    {
        //headers for the table
        
         
        //actual data for the table in a 2d array
        
        //create table with data
         
         
        //add the table to the frame
        this.add(new JScrollPane(table));
         
        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }

}
