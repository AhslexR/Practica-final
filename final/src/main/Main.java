package main;

import java.awt.EventQueue;

import main.Tabla;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	protected JFrame frmVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVentas = new JFrame();
		frmVentas.setBackground(new Color(255, 153, 51));
		frmVentas.getContentPane().setBackground(new Color(0, 0, 51));
		frmVentas.setTitle("Ventas");
		frmVentas.setBounds(100, 100, 644, 426);
		frmVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 153, 51));
		frmVentas.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Men\u00FA");
		mnNewMenu.setBackground(new Color(255, 153, 51));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Vender");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invocarVentas();
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver usuarios");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabla tabla = new Tabla();
				tabla.setVisible(true);
				frmVentas.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem.setBackground(new Color(255, 153, 51));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("Productos");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A\u00F1adir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadir();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Borrar");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Ver inventario");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventario();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		mnNewMenu_1.setBackground(new Color(255, 153, 51));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Acerca de");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits();
			}
		});
		mntmNewMenuItem_3.setBackground(new Color(255, 153, 51));
		mnNewMenu_1.add(mntmNewMenuItem_3);
	}

	public void invocarVentas() {
		Vender ven=new Vender();
		ven.setVisible(true); 
		
	}
	public void invocarMain() {
		frmVentas.setVisible(true);; 
	}
	void inventario() {
		Productos p=new Productos();
		p.setVisible(true);
	}
	void borrar() {
		Borrar b=new Borrar();
		b.setVisible(true);
	}
	void añadir() {
		Añadir add=new Añadir();
		add.setVisible(true);
	}
	void Credits() {
		Creditos c=new Creditos();
		c.setVisible(true);
	}
}
