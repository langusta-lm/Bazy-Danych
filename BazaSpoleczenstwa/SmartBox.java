package fat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SmartBox extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel name = new JLabel();
	private JTextField value = new JTextField();
	
	public SmartBox(String name, String value) {
		setLayout(new FlowLayout());
		
		this.name.setText(name);
		this.name.setPreferredSize(new Dimension(100, 20));
		this.value.setText(value);
		this.value.setPreferredSize(new Dimension(100,20));
		add(this.name);
		add(this.value);
		
	}


	public String getName() {
		try {
			return this.value.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	public String getNameOfName() {
		try {
			return this.name.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	public String getValue() {
		try {
			//return Double.parseDouble(value.getText());
			return this.value.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "error";
	}
	public void setValue(String name) {
		try {
			this.value.setText(name);
		} catch (Exception e) {
			System.out.println("name "+" smartBox-setValue "+e);
		}
		
	}

}
