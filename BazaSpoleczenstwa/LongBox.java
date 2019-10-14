package fat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class LongBox extends SmartBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField valueMax = new JTextField();
	private JCheckBox checkBox = new JCheckBox();
	
	public LongBox(String Name, String ValueMin, String ValueMax) {
		super(Name, ValueMin);
		setPreferredSize(new Dimension(100,30));
		setLayout(new FlowLayout());
		
		try {
			this.valueMax.setText(ValueMax);
			this.valueMax.setPreferredSize(new Dimension(50,20));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		add(this.valueMax);
		add(checkBox);
	}
	
	public LongBox() {
		super("nazwa","wartoœæ min");
		this.valueMax.setText("wartoœæ max");
		this.valueMax.setPreferredSize(new Dimension(50,15));
		add(this.valueMax, BorderLayout.EAST);
		
	}
	public String getValueMax()
	{
		try {
			return valueMax.getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public boolean getIsChecked()
	{
		try {
			return this.checkBox.isSelected();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
