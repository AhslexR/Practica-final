package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;

public class Vender extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	private JTextField tf1;
	static String filas []= {"","","",""};
    static String colms [][]= {{"","",""}};
    static String filas2 []= {"","",""};
    static String colms2 [][]= {{"","",""}};
	private JTable table,table1;
	private JButton btn1,btn2,btn3,btn4;
	int f,fi3;
	double fi2;
	String pro,fi;
	protected DefaultTableModel tabadd,model2;
	private JLabel lb1,lb2,lb3;
	private JSpinner spinner;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Vender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Vender() {
		launch();
		tabadd= (DefaultTableModel) table.getModel();
		model2= (DefaultTableModel) table1.getModel();
	}
	public void launch() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Vender");
		
		setBounds(100, 100, 867, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lb1 = new JLabel("Producto a vender:");
		lb1.setForeground(new Color(255, 153, 51));
		lb1.setBounds(10, 37, 156, 14);
		contentPane.add(lb1);
		
		tf1 = new JTextField();
		tf1.setBackground(new Color(255, 153, 51));
		tf1.setBounds(10, 62, 820, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		btn1 = new JButton("A\u00F1adir al Carrito");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirCarrito();
			}
		});
		btn1.setBounds(474, 492, 130, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("Buscar");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProductos();
			}
		});
		btn2.setBounds(474, 93, 156, 23);
		contentPane.add(btn2);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 454, 435);
		getContentPane().add(scrollPane);
		table = new JTable(colms,filas);
		table.setForeground(new Color(0, 0, 51));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Producto", "Precio","Stock"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.setBackground(new Color(255, 140, 0));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		lb2= new JLabel("Carrito de Compra:");
		lb2.setForeground(new Color(255, 153, 51));
		lb2.setBounds(484, 127, 252, 14);
		contentPane.add(lb2);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(474, 152, 369, 307);
		getContentPane().add(scrollPane2);
		table1 = new JTable(colms2,filas2);
		table1.setBackground(new Color(255, 153, 51));
		table1.setForeground(new Color(0, 0, 51));
		table1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Producto", "Precio", "Cantidad",
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.setBackground(new Color(255, 140, 0));
		scrollPane2.setViewportView(table1);
		contentPane.add(scrollPane2);
		
		btn3= new JButton("Facturar");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facturar();
				
			}
		});
		btn3.setBounds(716, 492, 114, 23);
		contentPane.add(btn3);
		
		lb3 = new JLabel("Cantidad:");
		lb3.setForeground(new Color(255, 153, 51));
		lb3.setBounds(668, 97, 68, 14);
		contentPane.add(lb3);
		
		spinner = new JSpinner();
		spinner.setBounds(746, 93, 84, 20);
		contentPane.add(spinner);
		
		btn4 = new JButton("Borrar");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model2.removeRow(table1.getSelectedRow());
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog( null, "Borrado invalido,revise que haya seleccionado el dato especifico","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn4.setBounds(611, 492, 89, 23);
		contentPane.add(btn4);
}
void buscarProductos()  {

		pro=tf1.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conect= DriverManager.getConnection("jdbc:mysql://localhost:3306/pcshop","root","root");
			 Statement state = conect.createStatement();
			 pro=tf1.getText();
			 ResultSet result=((java.sql.Statement)state).executeQuery("SELECT * FROM componentes WHERE MATCH(n_articulo) AGAINST('"+pro+"')");
				while (result.next()==true) {
					f=result.getInt("id");
					fi=result.getString("n_articulo");
					fi2=result.getDouble("precio");
					fi3=result.getInt("stock");
					filas[0]=String.valueOf(f);
					filas[1]=String.valueOf(fi);
					filas[2]=String.valueOf(fi2);
					filas[3]=String.valueOf(fi3);
					tabadd.addRow(filas);
			
		}
				}catch(ClassNotFoundException o) {
			o.printStackTrace();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
 void AñadirCarrito() {
	 String ana= (String) tabadd.getValueAt(table.getSelectedRow(), 1);
	 String ana2= (String) tabadd.getValueAt(table.getSelectedRow(), 2);
	 int ana3= (int) spinner.getValue();
	    filas2[0]=String.valueOf(ana);
	    filas2[1]=String.valueOf(ana2);
	    filas2[2]=String.valueOf(ana3);
		model2.addRow(filas2);
		tabadd.setRowCount(0);
	 
 }
 void facturar() {
	 Fact f=new Fact();
	 f.setVisible(true);
	 
 }
}