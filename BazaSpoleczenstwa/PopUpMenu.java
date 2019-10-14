package fat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class PopUpMenu {

	private JCheckBoxMenuItem cbMenuItem;
	public PopUpMenu(Gui gui) {

		//Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
	

		//Create the menu bar.
		menuBar = new JMenuBar();

		
		//Build Accounts
		menu = new JMenu("Konto");
		menu.setMnemonic(KeyEvent.VK_K);
		menu.getAccessibleContext().setAccessibleDescription(
		        "tysi¹ce ¿yæ uratowane");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Zaloguj siê",KeyEvent.VK_L);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_L, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "Kliknij by siê zalogowaæ");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.tryToLogin();
			}

			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Rejestracja nowego konta",KeyEvent.VK_R);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_R, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "Kliknij by siê zalogowaæ");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.MakeNewAccount();
			}

			
		});
		menu.add(menuItem);
		
		
		menu.add(new JSeparator());
		menuItem = new JMenuItem("Wylazuj", new ImageIcon("src/Bew.png") );
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.CloseGui();
				
			}
		});
		menu.add(menuItem);
		
		
		
		
		
		//Build menu
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription(
		        "tysi¹ce ¿yæ uratowane");
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Nowy plik",KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_N, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "Kliknij by utworzyæ nowy pusty plik");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new FrameNewFile(gui);
				
			
			}

			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Zapisz wszystko",KeyEvent.VK_A);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "save all");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.SaveAll();
			}

			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Zapisz Wybrane",KeyEvent.VK_W);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_W, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "save all");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.saveWybrane();
			}

			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Wczytaj Obiekty",KeyEvent.VK_O);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "save all");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.LoadAll();
			}

			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Wczytaj Spoleczenstwo",KeyEvent.VK_S);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "save all");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
			}

			
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Wczytaj Persone",KeyEvent.VK_P);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "save all");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
			}

			
		});
		menu.add(menuItem);
		
		menu.add(new JSeparator());
		
		menuItem = new JMenuItem("Drukuj",KeyEvent.VK_D);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_D, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "druki");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
			}

			
		});
		menu.add(menuItem);
		
		
		
		
		
		

		
		
		
		
		
		
		
	/*	
		menu.addSeparator();
		submenu = new JMenu("Sub Menu-test");
		submenu.setMnemonic(KeyEvent.VK_Q);

		menuItem = new JMenuItem("nic nie robi");
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("nic nie robi");
		submenu.add(menuItem);
		menu.add(submenu);

		*/
		
		
		
		
		
		
		
		
		
		//Build second menu in the menu bar.
		menu = new JMenu("Opcje");
		menu.setMnemonic(KeyEvent.VK_O);
		menu.getAccessibleContext().setAccessibleDescription(
		        "nothing else matter");
		menuBar.add(menu);
		
		//a group of JMenuItems
		menuItem = new JMenuItem("Wygeneruj Spoleczenstwo",KeyEvent.VK_Z);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "zmienne - nazwy");
		menuItem.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.addSpoleczenstwo(RandomGenerator.getRandomSpoleczenstwo());
			}
		});
				
		menu.add(menuItem);
		menuItem = new JMenuItem("Wygeneruj Persone",KeyEvent.VK_Z);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "zmienne - nazwy");
		menuItem.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.addPerson(RandomGenerator.getRandomPerson());
			}
		});
				
		menu.add(menuItem);
		menu.add(new JSeparator());
		
		
		menuItem = new JMenuItem("Zmien haslo dostepu",KeyEvent.VK_Z);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "haslo");
		menuItem.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.zmianahasladostepowego();
			}
		});
				
		menu.add(menuItem);
		gui.setJMenuBar(menuBar);
		
		
		/*
		
		
		int n = JOptionPane.showConfirmDialog(		
					    null,
					    "Jesteœ Pewien swojego wyboru?",
					    "Pytanie",
					    JOptionPane.YES_NO_OPTION);
				
				if(n==0) //yes
				{
				
				}
				if(n==1) //no
				{
				
				}
		
		
		
		
		
		cbMenuItem = new JCheckBoxMenuItem("Okno zawsze na wierzchu?");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		cbMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean btemp =true;
				btemp =  cbMenuItem.getState();
				//fie.setAlwaysOnTop(btemp);
			
			}
		});
		menu.add(cbMenuItem);
		
		
		menuItem = new JMenuItem("Testing", new ImageIcon("src/Bew.png") );
		menuItem.setMnemonic(KeyEvent.VK_B);
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ftable.upDateArg();
				
			}
		});
		menu.add(menuItem);

/*
		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);
*/
		
		
		//a group of check box menu items
		
/*
		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);
*/
		//a submenu

	}
	private void addNewEmptyFile() {
		
		
	}

}
