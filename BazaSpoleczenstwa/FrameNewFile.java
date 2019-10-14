package fat;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameNewFile extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JLabel jLabel = new JLabel("Wybierz Typ Pliku");
	private JComboBox comboBox = new JComboBox(BazaTypow.typyKlas);
	private JButton but = new JButton("Stworz szkielet");
	
	public FrameNewFile(Gui gui) {
		super("New Object");
		setLayout(new FlowLayout());
		
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) 	//persona
				{
					JFrame  framka = new JFrame("Persona");
					Container cont = new Container();
					ArrayList<SmartBox> arrSmart = new ArrayList<SmartBox>();
					for (int i = 0; i < Persona.jakDuzoZmiennych(); i++) {
						arrSmart.add(new SmartBox(Persona.getTitleOfVar(i), "1"));
					}
					for (SmartBox smartBox : arrSmart) {
						cont.add(smartBox);
					}
					JButton buter = new JButton("Utwórz");
					buter.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							int n = JOptionPane.showConfirmDialog(		//0-tak 1-nie
								    null,
								    "Jesteœ Pewien swojego wyboru?",
								    "Pytanie",
								    JOptionPane.YES_NO_OPTION);
							
							if(n==0) 
							{
								Persona personTemp = new Persona(arrSmart.get(0).getValue(), arrSmart.get(1).getValue(),
									arrSmart.get(2).getValue(), arrSmart.get(3).getValue(), arrSmart.get(4).getValue(),
									arrSmart.get(5).getValue(),arrSmart.get(6).getValue(),arrSmart.get(7).getValue());
								gui.addPerson(personTemp);//yes
							}
							if(n==1) ;
							
							framka.setVisible(false);
							
						}
					});
					cont.add(buter);
					cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
					framka.add(cont);
					framka.pack();
					framka.setVisible(true);
					framka.repaint();
				}
				if(comboBox.getSelectedIndex() == 1) 	//spoleczenstwo
				{
					JFrame  framka = new JFrame("Spoleczeñstwo");
					Container cont = new Container();
					ArrayList<SmartBox> arrSmart = new ArrayList<SmartBox>();
					for (int i = 0; i < Spoleczenstwo.jakDuzoZmiennych(); i++) {
						arrSmart.add(new SmartBox(Spoleczenstwo.getTitleOfVar(i), "1"));
					}
					for (SmartBox smartBox : arrSmart) {
						cont.add(smartBox);
					}
					JButton buter = new JButton("Utwórz");
					buter.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							Spoleczenstwo spolTemp = new Spoleczenstwo(arrSmart.get(0).getValue(), arrSmart.get(1).getValue(),
									arrSmart.get(2).getValue(), arrSmart.get(3).getValue(), arrSmart.get(4).getValue(),
									arrSmart.get(5).getValue());
							gui.addSpoleczenstwo(spolTemp);
							framka.setVisible(false);
							
						}
					});
					cont.add(buter);
					cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
					framka.add(cont);
					framka.pack();
					framka.setVisible(true);
					framka.repaint();
				}
				
			}
		});
		
		add(jLabel);
		add(comboBox);
		add(but);
		pack();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		repaint();
		requestFocusInWindow();	
	}

	static private ArrayList<SmartBox> arrSmart;
	public static  void RamkaEdycjiPersony(Persona pers)
	{
		 Persona persona = null;
		

		JFrame  framka = new JFrame("Persona");
		Container cont = new Container();
		arrSmart = new ArrayList<SmartBox>();
		for (int i = 1; i < Persona.jakDuzoZmiennych(); i++) {
			arrSmart.add(new SmartBox(Persona.getTitleOfVar(i), pers.getDataString()[i]));
		}
		for (SmartBox smartBox : arrSmart) {
			cont.add(smartBox);
		}
		JButton buter = new JButton("Zapisz");
		buter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(		//0-tak 1-nie
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				
				if(n==0)  editPerson(pers);//yes
				if(n==1) ;
				
				
				framka.setVisible(false);
			
				
			}
		});
	

		cont.add(buter);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		framka.add(cont);
		framka.pack();
		framka.setVisible(true);
		framka.repaint();

		//framka.dispose();
	}
	
	private static void editPerson(Persona pers)
	{
		try {
			pers.setName(arrSmart.get(0).getValue());
		pers.setSurname(arrSmart.get(1).getValue());
		pers.setWiek(Integer.parseInt(arrSmart.get(2).getValue()));
		pers.setPesel(Integer.parseInt(arrSmart.get(3).getValue()));
		pers.setZarobki(arrSmart.get(4).getValue());
		pers.setIdZawodu( arrSmart.get(5).getValue());
		pers.setIdWyksztalcenia(arrSmart.get(6).getValue());
		pers.reloadTableModel();
		} catch (Exception e) {
			//System.out.print("error edycji  "+e);
			JOptionPane.showMessageDialog( null, "Podano zle dane");
		}
		
	}
}
