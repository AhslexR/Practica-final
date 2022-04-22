package Conexion;
import main.Main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	//Inicialización de las variables 
	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnLogin;
	private JPanel panel_1;
	private JLabel lblUsuario;
	private JLabel lblNewLabel_5;
	private JLabel lblRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Iniciar sesión");
		frame.setResizable(false);
		frame.setBounds(100, 100, 828, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 204));
		panel_1.setBounds(0, 0, 999, 652);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(226, 69, 358, 493);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 153, 0));
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(78, 257, 197, 26);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBorder(null);
		txtContraseña.setBounds(78, 338, 197, 26);
		panel.add(txtContraseña);
		
		lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(78, 213, 86, 26);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(78, 307, 117, 20);
		panel.add(lblNewLabel_1);
		
		btnLogin = new JButton("Iniciar sesi\u00F3n");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Preparación del inicio de sesión
				PreparedStatement ps;
				ResultSet rs;
				String uname = txtUsuario.getText();
				String pass = String.valueOf(txtContraseña.getPassword());
				
				String query = "SELECT * FROM `usuarios` WHERE `username` =? AND `pass` =?";
				try {
					ps = Conexiones.getConnection().prepareStatement(query);
					ps.setString(1, uname);
					ps.setString(2, pass);
					rs = ps.executeQuery();
					if(rs.next()) {
						Main mn=new Main();
						
						mn.invocarMain();
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Nombre de Usuario o Contraseña incorrecta");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 0, 51));
		btnLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnLogin.setBounds(98, 395, 157, 34);
		panel.add(btnLogin);
		
		JLabel lblContraseña = new JLabel();
		lblContraseña.setBounds(21, 323, 45, 43);
		ImageIcon imagen1 = new ImageIcon(getClass().getResource("/Images/cerrar-con-llave.png"));
		Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(lblContraseña.getWidth(), lblContraseña.getHeight(), Image.SCALE_DEFAULT));
		lblContraseña.setIcon(fondo1);
		panel.add(lblContraseña);
		
		lblUsuario = new JLabel(); 
		lblUsuario.setBounds(10, 242, 58, 53);
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("/Images/usuario (2).png"));
		Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(lblUsuario.getWidth(), lblUsuario.getHeight(), Image.SCALE_DEFAULT));
		lblUsuario.setIcon(fondo2);
		panel.add(lblUsuario);
	
		lblNewLabel_5 = new JLabel("\u00BFNo est\u00E1 registrado? ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(45, 453, 129, 14);
		panel.add(lblNewLabel_5);
		
		lblRegister = new JLabel("Click aqu\u00ED para registrarse");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Abrir el formulario para registrarse
				@SuppressWarnings("unused")
				Register registro = new Register();
				Register.main(null);
				frame.dispose();
			}
		});
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setBounds(171, 452, 155, 14);
		panel.add(lblRegister);
		
		JLabel lbllogin = new JLabel();
		lbllogin.setBounds(98, 27, 155, 149);
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("/Images/log-in.png"));
		Icon fondo3 = new ImageIcon(imagen3.getImage().getScaledInstance(lbllogin.getWidth(), lbllogin.getHeight(), Image.SCALE_DEFAULT));
		lbllogin.setIcon(fondo3);
		panel.add(lbllogin);
	}

}