package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Productos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String filas []= {"","","",""};
    static String colms [][]= {{"","","",""}};
    int f,fi3;
	private String fi;
	double fi2;
    private DefaultTableModel tabadd;
    static JFrame frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new Productos();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public Productos() {
	launch();
	tabadd= (DefaultTableModel) table.getModel();
	mostrarProductos();
}
	public void launch() {
		
		
		setTitle("Productos en inventario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 491, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 454, 357);
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
	}
	void mostrarProductos()  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conect= DriverManager.getConnection("jdbc:mysql://localhost:3306/pcshop","root","root");
			 Statement state = conect.createStatement();
			 ResultSet result=((java.sql.Statement)state).executeQuery("select * from componentes");
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
	

}
