package main;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Añadir extends JDialog {
	private JTextField tf1,tf2,tf3;
	private JLabel lb1,lb2,lb3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Añadir dialog = new Añadir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Añadir() {
		getContentPane().setBackground(new Color(0, 0, 51));
		setTitle("A\u00F1adir");
		setBounds(100, 100, 453, 238);
		getContentPane().setLayout(null);
		{
			JButton btnNewButton = new JButton("A\u00F1adir");
			btnNewButton.setBackground(new Color(255, 153, 51));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ad();
				}
			});
			btnNewButton.setBounds(338, 165, 89, 23);
			getContentPane().add(btnNewButton);
		}
		{
			lb1 = new JLabel("Nombre:");
			lb1.setForeground(new Color(255, 153, 51));
			lb1.setBounds(10, 11, 46, 14);
			getContentPane().add(lb1);
		}
		{
			tf1 = new JTextField();
			tf1.setBackground(new Color(255, 153, 51));
			tf1.setBounds(66, 8, 305, 20);
			getContentPane().add(tf1);
			tf1.setColumns(10);
		}
		{
			lb2= new JLabel("Precio:");
			lb2.setForeground(new Color(255, 153, 51));
			lb2.setBounds(10, 46, 46, 14);
			getContentPane().add(lb2);
		}
		{
			tf2 = new JTextField();
			tf2.setBackground(new Color(255, 153, 51));
			tf2.setBounds(66, 43, 305, 20);
			getContentPane().add(tf2);
			tf2.setColumns(10);
		}
		{
			lb3 = new JLabel("Stock:");
			lb3.setForeground(new Color(255, 153, 51));
			lb3.setBounds(10, 86, 46, 14);
			getContentPane().add(lb3);
		}
		{
			tf3 = new JTextField();
			tf3.setBackground(new Color(255, 153, 51));
			tf3.setBounds(66, 83, 305, 20);
			getContentPane().add(tf3);
			tf3.setColumns(10);
		}
	}
void ad() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conect= DriverManager.getConnection("jdbc:mysql://localhost:3306/pcshop","root","root");
		 Statement state = conect.createStatement();
		
		String nombre=tf1.getText();
		String price=tf2.getText();
		String stock=tf3.getText();
		 ((java.sql.Statement)state).executeUpdate("insert into componentes(n_articulo,precio,stock)values('"+nombre+"','"+price+"','"+stock+"')");
		 JOptionPane.showInternalMessageDialog( null, "El producto "+nombre+" Ha sido insertado exitosamente","Añadido exitosamente", JOptionPane.INFORMATION_MESSAGE);
	}catch(ClassNotFoundException o) {

		o.getStackTrace();
	} catch (SQLException e1) {
		JOptionPane.showInternalMessageDialog( null, "Registro invalido,revise que haya puesto los datos correctamente","Error", JOptionPane.ERROR_MESSAGE);
	}
	;
}
}

