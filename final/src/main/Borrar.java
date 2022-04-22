package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Borrar extends JDialog {
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Borrar dialog = new Borrar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Borrar() {
		getContentPane().setBackground(new Color(0, 0, 51));
		setResizable(false);
		setTitle("Borrar Producto");
		setBounds(100, 100, 450, 243);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre del Producto especifico:");
			lblNewLabel.setForeground(new Color(255, 153, 51));
			lblNewLabel.setBounds(10, 11, 190, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			tf = new JTextField();
			tf.setBackground(new Color(255, 153, 51));
			tf.setBounds(10, 34, 414, 20);
			getContentPane().add(tf);
			tf.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("Borrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						java.sql.Connection conect= DriverManager.getConnection("jdbc:mysql://localhost:3306/pcshop","root","root");
						 Statement state = conect.createStatement();
						
						
						String nombre=tf.getText();
						 ((java.sql.Statement)state).executeUpdate("delete from componentes where n_articulo = ('"+nombre+"') order by n_articulo limit 1 ");
						 ResultSet result=((java.sql.Statement)state).executeQuery("select * from componentes where n_articulo=('"+nombre+"')");
							;
							if (result.next()==false) {
								JOptionPane.showInternalMessageDialog( null, "El producto "+nombre+" Ha sido borrado exitosamente","Borrado exitoso", JOptionPane.INFORMATION_MESSAGE);
								
							}
						 
						 
					}catch(ClassNotFoundException o) {
						o.printStackTrace();
						
					} catch (SQLException e1) {
						JOptionPane.showInternalMessageDialog( null, "Borrado invalido,revise que haya puesto el nombre especifico del dato","Error", JOptionPane.ERROR_MESSAGE);
					}
					;
				}
				
			});
			btnNewButton.setBackground(new Color(255, 153, 51));
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBounds(335, 170, 89, 23);
			getContentPane().add(btnNewButton);
		}
	}

}
