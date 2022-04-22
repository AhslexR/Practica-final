package main;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Conexion.Login;
import Conexion.Register;
import Conexion.Conexiones;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
     
@SuppressWarnings("serial")
public class Tabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static String filas3 []= {"","","",""};
    static String colms3 [][]= {{"","","",""}};
    private DefaultTableModel modelo;
    Conexiones cc = new Conexiones();
    Connection con = cc.getConnection();
    Register r = new Register();
    private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla window = new Tabla();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tabla() {
		setUndecorated(true);
		setResizable(false);
		setTitle("Usuarios ");
		Tableta();
		modelo=(DefaultTableModel) table.getModel();
		VerUsuarios();
	}
	
	public void Tableta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(153, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(1, 1, 3, 2));
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(146, 11, 384, 47);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Usuarios Registrados");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 173, 626, 243);
		getContentPane().add(scrollPane);
		
		table = new JTable(colms3, filas3);
		table.setForeground(new Color(0, 0, 51));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Email", "Usuario"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.setBackground(new Color(255, 140, 0));
		scrollPane.setViewportView(table);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filtrarDatos(txtBuscar.getText());
			}
		});
		txtBuscar.setBounds(73, 88, 159, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar ");
		lblNewLabel_1.setBounds(34, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEliminar_1 = new JButton("Cerrar sesión");
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con.close();
					JOptionPane.showMessageDialog(null, "Sesión cerrada");
					System.exit(ABORT);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar_1.setBounds(187, 444, 329, 23);
		contentPane.add(btnEliminar_1);
	}
	
	public void filtrarDatos(String valor) {
		String [] títulos = {"Nombre", "Apellido", "Email", "Usuario"};
		String [] registros = new String[4];
		Statement st;
		ResultSet rs;
		modelo = new DefaultTableModel(null, títulos);
		String SQL = "select * from usuarios where username like '%"+valor+"%'";
		 
		 try {
			 st = cc.getConnection().createStatement();
			 rs = st.executeQuery(SQL);
			 while(rs.next()) {
				registros[0] = rs.getString("nam");
				registros[1] = rs.getString("last_name");
				registros[2] = rs.getString("email");
				registros[3] = rs.getString("username");
				modelo.addRow(registros);
				table.setModel(modelo);
			 }
		 }
		 catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"Error al mostrar datos"+ e);
		 }
	}
	@SuppressWarnings("static-access")
	public void VerUsuarios() {
		String [] títulos = {"Nombre", "Apellido", "Email", "Usuario"};
		String [] registros = new String[4];
		Statement st;
		ResultSet rs;
		modelo = new DefaultTableModel(null, títulos);
		String SQL = "select * from usuarios";
		 try {
			 st = cc.getConnection().createStatement();
			 rs = st.executeQuery(SQL);
			 
			 while(rs.next()) {
				registros[0] = rs.getString("nam");
				registros[1] = rs.getString("last_name");
				registros[2] = rs.getString("email");
				registros[3] = rs.getString("username");
				
				modelo.addRow(registros);
				table.setModel(modelo);
			 }
		 }
		 catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"Error al mostrar datos"+ e);
		 }
	}
}
