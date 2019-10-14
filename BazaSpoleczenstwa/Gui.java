package fat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel jListPanel = new JPanel();
	private JTable tableOfBaza;
	private DefaultTableModel modelBazaObiektow;
	private ShowContainers showContainer = new ShowContainers();
	private ImpExp impExp = null;
	private Login login=null;
	private Management management=null;
	private String passToDoSome = "1";
	private Accounts nowLoged = null;
	public Gui() 
	{
		super("Baza Ludzi");
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(1300,600));
		//tabbedPane.setPreferredSize(new Dimension(550,400));
		
		impExp = new ImpExp(passToDoSome);
		
		
		initJListOfObjects();
		add(jListPanel);
		init();
		initLogin();
		
		
		
		pack();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				CloseGui();
				super.windowClosing(e);
			}
		});
		setVisible(true);
		repaint();
		requestFocusInWindow();	

	}

	private void init() {
		Container butPanel = new Container();
		JButton but1 = new JButton("Otworz dane zaznaczonego obiektu");
		but1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Podaj has³o dostêpu...");
				 if(name.equals(passToDoSome))
				if(management.canIEdytujZaznaczonaBaze(nowLoged))
					try {
						butShowParamOfClass();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
		}});	
		JButton but2 = new JButton("Otworz zaznaczona baze");
		but2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(management.canIbutShowGroup(nowLoged))
					try {
						butShowGroup();
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
				
		}});	
		JButton but3 = new JButton("Dodaj persone do spo³eczeñstwa");
		but3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(management.canIbutAddPersonToSpoleczenstwo(nowLoged))
					butAddPersonToSpoleczenstwo();
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
				
		}});	
		JButton but4 = new JButton("Edytuj Persone w Spoleczenstwie");
		but4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(management.canIbutSaveEdites(nowLoged))
					try {
						butSaveEdites(null);
					} catch (Exception e2) {
						System.out.println("edycja persony w spol"+e2);
					}
					
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
					
		}});
		JButton but44 = new JButton("Edytuj Spoleczenstwo");
		but44.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(management.canIEditSpolVars(nowLoged))
				{
					try {
						int index = tableOfBaza.getSelectedRow();
					String str = (String) tableOfBaza.getValueAt(index, 0);
					EditSpolVars(str);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
				}
					
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
						
		}});
		JButton but444 = new JButton("Edytuj Persone");
		but444.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					EdytujPersonifikacje();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
					
		}});
		JButton but5 = new JButton("Usuñ Persone z Spoleczenstwa");
		but5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(management.canIbutDeleteSelectedPersonFromSpol(nowLoged))
				{
					try {
						int n = JOptionPane.showConfirmDialog(		//0-tak 1-nie
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				
						if(n==0) 	//yes
						{
							butDeleteSelectedPersonFromSpol();
						}
							if(n==1) ;
				
					} catch (Exception e2) {
						// TODO: handle exception
					}
						
					
				}
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
				
				
				
		}});
		JButton but55 = new JButton("Usuñ Persony z Spoleczenstwa");
		but55.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(management.canIdeletePersonByName(nowLoged))
				{
					int n = JOptionPane.showConfirmDialog(		//0-tak 1-nie
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				
					if(n==0) 
					{
					
					int index[] = getSelectedIndexes();
					int ecli = 0;
					try {
						for(int i=0; i< index.length; i++)						
						{
							Object obj = getThingOfRowCol(index[i]-ecli, 1);
							showContainer.deletePersonByName((String) obj);
							ecli++;
						}
					} catch (Exception e2) {
						System.out.println(e2);
					}
					
					//yes
					}
					if(n==1) ;
					
					
				}
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
				
				
		}});
		JButton but6 = new JButton("Posortuj Persony w Spoleczenstwie");
		but6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sortPersons();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
		}});	
		JButton but7 = new JButton("Wyszukiwanie");
		but7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					wyszukajIStworzWynik();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
		}});
		JButton but8 = new JButton("Usun obiekt");
		but8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(management.canIUsunObiekt(nowLoged))
				{
				try {
					int index = tableOfBaza.getSelectedRow();
					String nam = (String) tableOfBaza.getValueAt(index, 0);
					//	System.out.println(nam);showContainer.getSpolByName(nam)
					
					try {
						showContainer.deletePersonByName(nam);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					try {
						
						showContainer.deleteSpoleByName(nam);
					} catch (Exception e2) {
						// TODO: handle exception
						}
					
					
					
						modelBazaObiektow.removeRow(tableOfBaza.getSelectedRow());
					} catch (Exception e2) {
					System.out.println("Nie zaznaczono obiektu do usuniêcia");
					}
					
				}
				else  JOptionPane.showMessageDialog( null, "Brak dostêpu");
					
				
				
				
		}}); 
		JButton but9 = new JButton("Wyci¹gnij Persone"); //////////////////////////////////
		but9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					WyciagnijPersone();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
		}});
			
		
		
		
		
		butPanel.add(but1);
		butPanel.add(but2);
		butPanel.add(new JSeparator());
		butPanel.add(but3);
		butPanel.add(but5);
		butPanel.add(but55);
		
		butPanel.add(but4);
		butPanel.add(but44);
		butPanel.add(but444);
		butPanel.add(new JSeparator());
		
		butPanel.add(but6);
		butPanel.add(but7);
		butPanel.add(but8);
		butPanel.add(but9);
		butPanel.setLayout(new BoxLayout(butPanel, BoxLayout.Y_AXIS));
		add(butPanel);
		this.add(tabbedPane);
		//addNewTabbPane(null,null);				
		
		
		PopUpMenu popUpMenu = new PopUpMenu(this);
	}
	


	

	public void initJListOfObjects()
	{
		String[] title = new String[] {
	            "Nazwa", "Typ "};
		
        
		modelBazaObiektow = new DefaultTableModel(title, 0);
		
        tableOfBaza = new JTable(modelBazaObiektow);
		jListPanel.add(new JScrollPane(tableOfBaza));
	
		DefaultTableModel modelTemp = new DefaultTableModel();
		JPanel jpanel = new JPanel();
		JTable table= new JTable(modelTemp);
		jpanel.add(new JScrollPane(table));
		tabbedPane.addTab("zero", jpanel);
		tabbedPane.remove(0);
	}
	private void reloadModelBazaObiektow ()
	{
		while(0 < modelBazaObiektow.getRowCount()) {
			modelBazaObiektow.removeRow(0);
		}
		
		for(Spoleczenstwo temp : showContainer.getArrOfSpoleczenstwos())
		{
			modelBazaObiektow.addRow(new Object[] {temp.getNazwa(), "Spoleczeñstwo"});
		}
		for(Persona temp : showContainer.getArrOfPersons())
		{
			modelBazaObiektow.addRow(new Object[] {temp.getName(), "Persona"});
		}
		
	}

	public void addSpoleczenstwo (Spoleczenstwo spol)
	{
		//ArrayList<Persona> temp = new ArrayList<Persona>();
		//temp.addAll(spol.getPersonsFromSpoleczenstwo());
		
		showContainer.addSpoleczenstwo(spol);
		reloadModelBazaObiektow();
		//modelBazaObiektow.addRow(new Object[] {spol.getNazwa(),"Spoleczenstwo"});
		
	}
	
	public void addPerson (Persona pers){
		
		if(pers != null){
			showContainer.addPersona(pers);
			reloadModelBazaObiektow();
			//modelBazaObiektow.addRow(new Object[] {pers.getName(),"Persona"});
		}else 
			System.out.println("nie mo¿na dodaæ pustej persony");
	}

	public void addNewTabbPane( String titleTable,DefaultTableModel modelTemp)
	{
		JPanel pnlTab = new JPanel(new BorderLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(titleTable); //title RandomGenerator.GetRandomString(5, 2)
	
		JButton btnClose = new JButton(new ImageIcon("C:\\Users\\hp\\Desktop\\x.png"));
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tabbedPane.getSelectedIndex();
				tabbedPane.remove(index);
			}
		});
		btnClose.setPreferredSize(new Dimension(8,5));
		//lblTitle.setPreferredSize(new Dimension(35,25));
		//System.out.println(btnClose.getPreferredSize());
		pnlTab.add(btnClose, BorderLayout.EAST);
		pnlTab.add(lblTitle, BorderLayout.WEST);

		JComponent baza=null;
		try {
			 baza = makeJTable(modelTemp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if (modelTemp!=null) tabbedPane.addTab(titleTable,  null, baza,  "³okienko ³an");
		else tabbedPane.addTab("test",  null, null,  "³okienko ³an");
		
		tabbedPane.setTabComponentAt(tabbedPane.indexOfComponent(baza), pnlTab);
		
	}
	
	private JComponent makeJTable(DefaultTableModel modelTemp )//Object [][] datas, Object[] titlesColumn, int Size
	{
		JPanel jpanel = new JPanel();
		JTable table= new JTable(modelTemp);
		table.setPreferredSize(new Dimension(550,400));
		jpanel.add(new JScrollPane(table));
		
		return jpanel;
		/*String str = RandomGenerator.GetRandomString(5, 2);
		Object[] title;
		DefaultTableModel modelTemp;          //*****
		
		JTable table;
		Object[][] data = datas;
		
		title = titlesColumn; // spol.getPersonsFromSpoleczenstwo().get(0).getNames();
		modelTemp = new DefaultTableModel(title, 0);
		
		//System.out.println("adasd"+getDataFromSpol(spol));
		
		if(data != null){
			for (int i = 0; i < Size; i++) {
				try {
					modelTemp.addRow(data[i]);
				} catch (Exception e) {
					//System.out.println(i);
				}
			}
			
		}
		*/
		
	}
	
	
	
	private void druknijplis()
	{
try {
			
			
			
			int index = tableOfBaza.getSelectedRow();
			String nam = (String) tableOfBaza.getValueAt(index, 0);
			//	System.out.println(nam);showContainer.getSpolByName(nam)
			if(showContainer.getSpolByName(nam).type == "spoleczenstwo")
			{
				this.addNewTabbPane("I-"+showContainer.getSpolByName(nam).getNazwa(),
								showContainer.getSpolByName(nam).getTableModel());
			}
			
		}	 catch (Exception e) {
			// TODO: handle exception
			}
	}
	
	private void butShowGroup()
	{
		try {
			
			
			
			int index = tableOfBaza.getSelectedRow();
			String nam = (String) tableOfBaza.getValueAt(index, 0);
			//	System.out.println(nam);showContainer.getSpolByName(nam)
			if(showContainer.getSpolByName(nam).type == "spoleczenstwo")
			{
				this.addNewTabbPane("I-"+showContainer.getSpolByName(nam).getNazwa(),
								showContainer.getSpolByName(nam).getTableModel());
			}
			
		}	 catch (Exception e) {
			// TODO: handle exception
			}
	}
	
	private void butShowParamOfClass()
	{
		//try {
		int index = tableOfBaza.getSelectedRow();
		
		String	nam  = (String) tableOfBaza.getValueAt(index, 0);
		
		//out.s(showContainer.getPersByName(nam).type);
		//out.s(showContainer.getSpolByName(nam).type);
		try {
			if(showContainer.getSpolByName(nam).type == "spoleczenstwo")
		{
			this.addNewTabbPane("E-"+showContainer.getSpolByName(nam).getNazwa(),
					showContainer.getSpolByName(nam).getData(true));
		}
		} catch (Exception e) {
			System.out.println("otwieradnie E spol"+e);
		}
		try {
			 if(showContainer.getPersByName(nam).type == "persona")
		{
			showContainer.getPersByName(nam);
			this.addNewTabbPane("E-"+showContainer.getPersByName(nam).getName(),
					showContainer.getPersByName(nam).getTableModel());
			
		}
		} catch (Exception e) {
			
		}
		
		
		//} catch (Exception e) {
			//System.out.println(e);
		//}
	}
	
	private void butAddPersonToSpoleczenstwo()
	{
		Persona pers=null;
		Spoleczenstwo spol;
		JFrame framka = new JFrame("Dodaj persone do spoleczenstwa");
		JComboBox combo1 = new JComboBox(showContainer.getStringOfPersons());
		JComboBox combo2 = new JComboBox(showContainer.getStringOfSpoleczenstwo());
		JLabel lab1 = new JLabel("wybierz Persone");
		JLabel lab2 = new JLabel("wybierz Spoleczenstwo");
		Container cont = new Container();
		JButton but = new JButton("Powi¹¿");
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index1 = combo1.getSelectedIndex();
				int n = JOptionPane.showConfirmDialog(		//0-tak 1-nie
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				
				if(n==0) 
				{
					showContainer.getSpoleczenstwoByIndex(combo2.getSelectedIndex()).addPersona(showContainer.getPersonByIndex(combo1.getSelectedIndex()));
					//yes
				}
				if(n==1) ;
				
				framka.setVisible(false);
				repaint();
				revalidate();
				try {
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		cont.add(lab1);
		cont.add(combo1);
		cont.add(lab2);
		cont.add(combo2);
		cont.add(but);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		framka.add(cont);
		framka.pack();
		framka.setVisible(true);
		
	}
	
	private Persona getSelectedPersona()
	{
		Persona temp=null;
		int tabIndex = tabbedPane.getSelectedIndex();
		JPanel panel = (JPanel) tabbedPane.getComponent(tabIndex);
		JScrollPane crlpane = (JScrollPane) panel.getComponent(0);
		JViewport view = (JViewport) crlpane.getComponent(0);
		JTable model = (JTable) view.getComponent(0);
		
		String str  = (String) model.getValueAt(model.getSelectedRow(), 1);
		
		temp = showContainer.getPersByName(str);
		/*
		try {
			
			return temp;
		} catch (Exception e) {
			System.out.println(e);
		}*/
		
		
		return temp;
	}
	private void butDeleteSelectedPersonFromSpol()
	{
		Object obj = getSelectedThingOnTabbed(1);
		showContainer.deletePersonByName((String) obj);
		
	}
	private Object getSelectedThingOnTabbed (int column)
	{
		int tabIndex = tabbedPane.getSelectedIndex();
		JPanel panel = (JPanel) tabbedPane.getComponent(tabIndex);
		JScrollPane crlpane = (JScrollPane) panel.getComponent(0);
		JViewport view = (JViewport) crlpane.getComponent(0);
		JTable model = (JTable) view.getComponent(0);
		Object obj = model.getValueAt(model.getSelectedRow(), column);
		
		return obj;
	}
	private Object getThingOfRowCol (int row, int column)
	{
		int tabIndex = tabbedPane.getSelectedIndex();
		JPanel panel = (JPanel) tabbedPane.getComponent(tabIndex);
		JScrollPane crlpane = (JScrollPane) panel.getComponent(0);
		JViewport view = (JViewport) crlpane.getComponent(0);
		JTable model = (JTable) view.getComponent(0);
		Object obj = model.getValueAt(row, column);
		
		return obj;
	}
	
	private int[] getSelectedIndexes ()
	{
		int tabIndex = tabbedPane.getSelectedIndex();
		JPanel panel = (JPanel) tabbedPane.getComponent(tabIndex);
		JScrollPane crlpane = (JScrollPane) panel.getComponent(0);
		JViewport view = (JViewport) crlpane.getComponent(0);
		JTable model = (JTable) view.getComponent(0);
		return model.getSelectedRows();
	}
	
	private void butSaveEdites(String name)
	{
		Object obj;
		if (name == null) obj = getSelectedThingOnTabbed(1);
		else obj = name;
		// showContainer.getPersonFromSpoleczenstwaByName((String) obj);
		
		
		
		
		JFrame  framka = new JFrame("Persona");
		Container cont = new Container();
		ArrayList<SmartBox> arrSmart = new ArrayList<SmartBox>();
		
		Persona oldPerson = showContainer.getPersonFromSpoleczenstwaByName((String) obj);
		System.out.println(oldPerson);
		for (int i = 1; i < Persona.jakDuzoZmiennych(); i++) {
			arrSmart.add(new SmartBox(Persona.getTitleOfVar(i), oldPerson.getDataString()[i]));
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
				
				if(n==0) 
				{
					Persona newPerson = new Persona(
							"0", 
							arrSmart.get(0).getValue(),
							arrSmart.get(1).getValue(), 
							arrSmart.get(2).getValue(), 
							arrSmart.get(3).getValue(),
							arrSmart.get(4).getValue(),
							arrSmart.get(5).getValue(),
							arrSmart.get(6).getValue());
				
					showContainer.findPersonEndEdit(oldPerson, newPerson);
				}
				if(n==1) ;
				
				
				
				framka.setVisible(false);
				//framka.dispose();
				
			}
		});
	
		
		cont.add(buter);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		framka.add(cont);
		framka.pack();
		framka.setSize(new Dimension(300,300));
		framka.setVisible(true);
		framka.repaint(); /**/
	}
	private JComboBox combo1;
	private JComboBox combo2;
	private void sortPersons()
	{
		combo1  = new JComboBox(Persona.getTitles());
		combo2  = new JComboBox(new Object[]{"Rosn¹co", "Malej¹co"});
		
		JFrame  framka = new JFrame("Sortowanie");
		Container cont = new Container();
		JLabel lab1 = new JLabel("Co chcesz posortowaæ");
		
		cont.add(lab1);
		cont.add(combo1);
		cont.add(combo2);
		
		
		JButton buter = new JButton("Sortuj");
		buter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sorter();
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
	
	private void sorter(){
		int index = combo1.getSelectedIndex();
		int maxcountspol = showContainer.getArrOfSpoleczenstwos().size()-1;
		while (maxcountspol >=0)
		{
			showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo().sort(new ComparPersons(index));
			if(combo2.getSelectedIndex() == 1) Collections.reverse(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo());
			showContainer.getSpolByIndex(maxcountspol).reloadTableModel();
			maxcountspol--;
		}
	}
	private ArrayList<LongBox> lBox=null;
	private JTextField nazwaWyniku=null;
	private void wyszukajIStworzWynik() {
		
		lBox = new ArrayList<LongBox>();
		nazwaWyniku = new JTextField("WynikWyszukiwania");
		
		Container contFilters = new Container();
			
		lBox.add(new LongBox(Persona.getTitles()[0],"",""));
		lBox.add(new LongBox(Persona.getTitles()[1],"",""));
		lBox.add(new LongBox(Persona.getTitles()[2],"",""));
		lBox.add(new LongBox(Persona.getTitles()[3],"",""));
		lBox.add(new LongBox(Persona.getTitles()[4],"",""));
		lBox.add(new LongBox(Persona.getTitles()[5],"",""));
		lBox.add(new LongBox(Persona.getTitles()[6],"",""));
		lBox.add(new LongBox(Persona.getTitles()[7],"",""));
		
		
		for (LongBox lbox : lBox) 
		{
			contFilters.add(new JSeparator());
			contFilters.add(lbox);		
		}
		contFilters.setLayout(new BoxLayout(contFilters, BoxLayout.Y_AXIS));
		JFrame  framka = new JFrame("Wyszukiwanie");
		Container cont = new Container();
		
		
		
		cont.add(contFilters);
		cont.add(new JSeparator());
		cont.add(new JLabel("podaj nazwe wyniku"));
		cont.add(nazwaWyniku);
		
		
		JButton but1 = new JButton("Szukaj");
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addSpoleczenstwo(wyszukaj());
				
				framka.setVisible(false);
				
				
			}
		});
		JButton but2 = new JButton("Znajdz i usun");
		but2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(		
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				if(n==0) //yes
				{
					ArrayList<Persona> temp = wyszukaj().getPersonsFromSpoleczenstwo();
					for (Persona persona : temp) 
					{
						showContainer.deletePersonByName(persona.getName());
					}
				}
				framka.setVisible(false);	
			}
		});
		JButton but3 = new JButton("Znajdz i zamien");
		but3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(		
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				if(n==0) //yes
				{
					WyszukajIZamien();
					
				}
				framka.setVisible(false);	
			}
		});
		
		
		cont.add(but1);
		cont.add(but2);
		cont.add(but3);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		framka.add(cont);
		framka.setPreferredSize(new Dimension(400,430));
		framka.pack();
		framka.setVisible(true);
		framka.repaint();
		
	}
	private Spoleczenstwo wyszukaj ()
	{
		ArrayList<Persona> temp= new ArrayList<Persona>();
		int maxcountspol = showContainer.getArrOfSpoleczenstwos().size()-1;
		while (maxcountspol >=0)
		{	
			
			if(lBox.get(0).getIsChecked())
			{
				String str1 = lBox.get(0).getValue();
				String str2 =lBox.get(0).getValueMax();
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsById(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
					str1, str2);
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(1).getIsChecked())
			{
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsByName(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						lBox.get(1).getValue());
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(2).getIsChecked())
			{
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsBySurname(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						lBox.get(2).getValue());
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(3).getIsChecked())
			{
				int str1 = Integer.parseInt(lBox.get(3).getValue());
				int str2 = Integer.parseInt(lBox.get(3).getValueMax());
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsByWiek(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						str1, str2);
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(4).getIsChecked())
			{
				int str1 = Integer.parseInt(lBox.get(4).getValue());
				int str2 = Integer.parseInt(lBox.get(4).getValueMax());
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsByPesel(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						str1, str2);
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(5).getIsChecked())
			{
				int str1 = Integer.parseInt(lBox.get(5).getValue());
				int str2 = Integer.parseInt(lBox.get(5).getValueMax());
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsByZarobki(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						str1, str2);
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(6).getIsChecked())
			{
				int str1 = Integer.parseInt(lBox.get(6).getValue());
				int str2 = Integer.parseInt(lBox.get(6).getValueMax());
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsByidZawodu(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						str1, str2);
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
			if(lBox.get(7).getIsChecked())
			{
				int str1 = Integer.parseInt(lBox.get(7).getValue());
				int str2 = Integer.parseInt(lBox.get(7).getValueMax());
				ArrayList<Persona> temp1=null;
				temp1 = Searcher.findPersonsByidWyksztalcenia(showContainer.getSpolByIndex(maxcountspol).getPersonsFromSpoleczenstwo(),
						str1, str2);
				if(temp1 == null) System.out.println("nic tu nima takigo");
				temp.addAll(temp1);
			}
				
		
			maxcountspol--;
		}
		Spoleczenstwo spol = new Spoleczenstwo(this.nazwaWyniku.getText(), "0", "0", "0", "0", "0");
		spol.addArrayOfPersons(temp);
		spol.reloadTableModel();
		
		return spol;
		
		
	}
	private FileDialog fd =null;
	public void SaveAll()
	{
		try {
			fd = new FileDialog(this, "Zapisz w...",FileDialog.SAVE);
			fd.setVisible(true);
			String filepath = fd.getDirectory() + fd.getFile();
			impExp.WritePersSpolsToFile(showContainer.getArrOfPersons(), showContainer.getArrOfSpoleczenstwos(), filepath);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void LoadAll()
	{
		fd = new FileDialog(this, "Wczytaj z...",FileDialog.LOAD);
		fd.setVisible(true);
		String filepath = fd.getDirectory() + fd.getFile();
		impExp.ReadPersSpolsToFile(this, filepath);
	}
	
	private void WyciagnijPersone() {
		addPerson(getSelectedPersona());
		
	}
	
	public void CloseGui()
	{
		try {
			int n = JOptionPane.showConfirmDialog(		
				    null,
				    "Jesteœ Pewien swojego wyboru?",
				    "Pytanie",
				    JOptionPane.YES_NO_OPTION);
			
			if(n==0) //yes
			{
				login.saveInfo();
				System.exit(0);
			}
			if(n==1) //no
			{
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void saveWybrane() {
		
		
		int index[] = tableOfBaza.getSelectedRows();
		String nam = "";
		ArrayList<Persona> arrPers = new ArrayList<Persona>();
		ArrayList<Spoleczenstwo> arrSpol = new ArrayList<Spoleczenstwo>();
		
		for (int i=0; i<index.length; i++)
		{
			nam = (String) tableOfBaza.getValueAt(index[i], 0);
			System.out.println(index[i] +" -ze tu, jest to  " + nam);
			try {
				if(showContainer.getPersByName(nam).type == "persona")
				{
					arrPers.add(showContainer.getPersByName(nam));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
			try {
				if(showContainer.getSpolByName(nam).type == "spoleczenstwo")
				{
					arrSpol.add(showContainer.getSpolByName(nam));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		try {
			fd = new FileDialog(this, "Zapisz w...",FileDialog.SAVE);
			fd.setVisible(true);
			String filepath = fd.getDirectory() + fd.getFile();
			impExp.WritePersSpolsToFile(arrPers, arrSpol, filepath);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}
	
	private void WyszukajIZamien()
	{
		Spoleczenstwo temp = wyszukaj(); 
		Persona oldPerson=null;
		Persona newPerson=null;
		
		int n = JOptionPane.showConfirmDialog(		
			    null,
			    "Wykonac modyfikacje automatycznie?",
			    "Pytanie",
			    JOptionPane.YES_NO_OPTION);
		if(n==0) //yes
		{
			Persona tempPers =  OkienkoDoEdycjiPersonAutom(temp.getPersonOnIndex(0));
			
			for (Persona pers : temp.getPersonsFromSpoleczenstwo()) 
			{
				oldPerson = pers;
				newPerson = new Persona (pers);
				if(newPerson.equals(pers)) System.out.println("takie same dane");
				newPerson.setZarobki(tempPers.getZarobki());
				newPerson.setIdZawodu(tempPers.getIdZawodu());
				newPerson.setIdWyksztalcenia(tempPers.getIdWyksztalcenia());
				
				
				showContainer.findPersonEndEdit(oldPerson, newPerson);
			}
			
			
			
		}
		if(n==1) //no
		{
			for (Persona pers : temp.getPersonsFromSpoleczenstwo())
			{
				OkienkoDoEdycjiPersonAutom(pers);
				
			}
		}
		
	}
	
	private ArrayList<SmartBox>	smBox;
	private Persona OkienkoDoEdycjiPersonAutom(Persona pers)
	{
		Persona wynikPErson = new Persona(pers);
		smBox = new ArrayList<SmartBox>();
		JFrame  framka = new JFrame("Szybki Edytor");
		Container cont = new Container();
		
		JButton but1 = new JButton("Zapisz");
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(pers);
				//Persona dziad = 
				butOkienkoDoEdycjiPersonAutom(pers);
				
				//System.out.println(pers);
				framka.dispose();
			}
		});
		
		smBox.add(new SmartBox("Zarobki", Double.toString(pers.getZarobki())));
		smBox.add(new SmartBox("ID Zawodu", Integer.toString(pers.getIdZawodu())));
		smBox.add(new SmartBox("ID Wyksztalcenia", Integer.toString(pers.getIdWyksztalcenia())));
		
		//System.out.println(pers);
		for (SmartBox smartBox : smBox) {
			cont.add(smartBox);
		}
		cont.add(but1);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		framka.add(cont);
		//framka.setPreferredSize(new Dimension(400,400));
		framka.pack();
		framka.setVisible(true);
		framka.repaint();
		
		
		
		
		return wynikPErson;
	}
	
	private void butOkienkoDoEdycjiPersonAutom(Persona pers)
	{
		pers.setZarobki(smBox.get(0).getValue());
		pers.setIdZawodu(smBox.get(1).getValue());
		pers.setIdWyksztalcenia(smBox.get(2).getValue());
		
	}
	
	
	
	
	private void initLogin()
	{
		login = new Login();
		management = new Management(login,passToDoSome);
		tryToLogin();
	}
	ArrayList<SmartBox> logBox;
	public void tryToLogin()
	{
		
		JFrame  framka = new JFrame("Logowanie");
		Container cont = new Container();
		
		logBox = new ArrayList<SmartBox>();
		logBox.add(new SmartBox("Login:", ""));
		logBox.add(new SmartBox("has³o:", ""));
		
		
		JButton but1 = new JButton("Zaloguj");
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nowLoged = login.tryLogin(logBox.get(0).getValue(),logBox.get(1).getValue());
				if(nowLoged != null) System.out.println("Priorytet dostêpu: "+nowLoged.getPriority());
				framka.dispose();
			}
		});
		
		
		//System.out.println(pers);
		for (SmartBox sBox : logBox) {
			cont.add(sBox);
		}
		cont.add(but1);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		
		framka.add(cont);
		//framka.setPreferredSize(new Dimension(400,400));
		framka.setAlwaysOnTop(true);
		framka.pack();
		framka.setVisible(true);
		framka.repaint();
	}
	
	ArrayList<SmartBox> regBox;
	public void MakeNewAccount ()
	{
		JFrame  framka = new JFrame("Rejestracja");
		Container cont = new Container();
		
		regBox = new ArrayList<SmartBox>();
		regBox.add(new SmartBox("Login:", ""));
		regBox.add(new SmartBox("has³o:", ""));
		regBox.add(new SmartBox("Priorytet:", ""));
		
		JButton but1 = new JButton("Zarejestruj siê");
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				login.addNewAccount(regBox.get(0).getValue(),regBox.get(1).getValue(),regBox.get(2).getValue());
				framka.dispose();
			}
		});
		
		
		//System.out.println(pers);
		for (SmartBox sBox : regBox) {
			cont.add(sBox);
		}
		cont.add(but1);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		
		framka.add(cont);
		//framka.setPreferredSize(new Dimension(400,400));
		framka.pack();
		framka.setVisible(true);
		framka.repaint();

		
	}
	
	
	private void EdytujPersonifikacje()
	{
		int index = tableOfBaza.getSelectedRow();
		String nam = (String) tableOfBaza.getValueAt(index, 0);
		//	System.out.println(nam);showContainer.getSpolByName(nam)
		
		if(showContainer.getPersByName(nam).type == "persona")
		{
			//System.out.println(showContainer.getPersByName(nam));
			FrameNewFile.RamkaEdycjiPersony(showContainer.getPersByName(nam));
			//System.out.println(showContainer.getPersByName(nam));
			//showContainer.findPersonEndEdit(showContainer.getPersByName(nam), pers);
			
		}
		
	}
	
	ArrayList<SmartBox> spolBox;
	private boolean bspol=false;
	private void EditSpolVars(String str)
	{
		Spoleczenstwo spolTemp=null;
		
		
		int Index = 0;
		//	System.out.println(nam);showContainer.getSpolByName(nam)
		if(showContainer.getSpolByName(str).type == "spoleczenstwo")
			spolTemp = showContainer.getSpolByName(str);
		else System.out.println(Index + "  " +showContainer.getSpolByName(str));
		JFrame  framka = new JFrame("Edycja spoleczenstwa");
		Container cont = new Container();
		
		spolBox = new ArrayList<SmartBox>();
		
		
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[0], Integer.toString(spolTemp.getId())));
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[1], spolTemp.getNazwa()));
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[2], spolTemp.getNarodowosc()));
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[3], spolTemp.getWyznanie()));
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[4], spolTemp.getTyp()));
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[5], Integer.toString(spolTemp.getStopienRozwoju())));
		spolBox.add(new SmartBox((String) Spoleczenstwo.getTitles()[6], Integer.toString(spolTemp.getFormaSpoleczenstwa())));
		
		
		
		JButton but1 = new JButton("Zapisz");
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EdyscjaSpola(showContainer.getSpolByName(str));
				framka.dispose();
			}
		});
		
		
		//System.out.println(pers);
		for (SmartBox sBox : spolBox) {
			cont.add(sBox);
		}
		cont.add(but1);
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		if(bspol)
		{
			
		}
		
		framka.add(cont);
		//framka.setPreferredSize(new Dimension(400,400));
		framka.pack();
		framka.setVisible(true);
		framka.repaint();
	}
	
	private void EdyscjaSpola(Spoleczenstwo spol)
	{
		try {
			spol.setId( spolBox.get(0).getValue());
		spol.setNazwa( spolBox.get(1).getValue());
		spol.setNarodowosc( spolBox.get(2).getValue());
		spol.setWyznanie( spolBox.get(3).getValue());
		spol.setTyp( spolBox.get(4).getValue());
		spol.setStopienRozwoju(spolBox.get(5).getValue());
		spol.setFormaSpoleczenstwa( spolBox.get(6).getValue());
		
			reloadModelBazaObiektow();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void zmianahasladostepowego()
	{
		String name = JOptionPane.showInputDialog("Podaj has³o dostêpu...");
		if(name.equals(passToDoSome))
			if (management.canIDchangePass(nowLoged))
			{
				 this.passToDoSome = JOptionPane.showInputDialog("Podaj nowe has³o dostêpowe");
			}
			else
			System.out.println("Brak dostepuuu..");
	}
	
	
	
	
	
}
