package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;

public class Creditos extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Creditos dialog = new Creditos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Creditos() {
		setTitle("Acerca de");
		setResizable(false);
		setBounds(100, 100, 450, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrDesarolladoPor = new JTextArea();
		txtrDesarolladoPor.setBackground(new Color(255, 153, 51));
		txtrDesarolladoPor.setEditable(false);
		//txtrDesarolladoPorLos.setText("                                              Desarollado por GCE\u00AE dev.\r\n                                                            Eduard Cruz\r\n                                                             2020-9358\r\n                                                          Gabriel Cedano\r\n                                                            2020-10783\r\n                                                        Cristhian Taveras\r\n                                                            2020-10541");
		txtrDesarolladoPor.setText("                                              Desarollado por LIP\u00AE dev.\r\n                                                   Ashly N Diaz Reyes\r\n                                                        2020-10955\r\n                                                          ");
		txtrDesarolladoPor.setBounds(10, 11, 414, 119);
		contentPanel.add(txtrDesarolladoPor);
	}
}
