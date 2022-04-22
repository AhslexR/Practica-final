package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Fact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	static String filas3 []= {"","","",""};
    static String colms3 [][]= {{"","","",""}};
    private double precio,res;
    private int cantidad;
    private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fact frame = new Fact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public Fact() {
	Factura();
	modelo= (DefaultTableModel) table.getModel();
	facturar();
}
	
	public void Factura() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 566, 424);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Cliente :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 140, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(10, 40, 85, 30);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 51));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBackground(new Color(255, 153, 51));
		textField.setBounds(105, 44, 250, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 531, 186);
		getContentPane().add(scrollPane);
		
		table = new JTable(colms3,filas3);
		table.setForeground(new Color(0, 0, 51));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Producto", "Precio", "Cantidad", "Total"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.setBackground(new Color(255, 140, 0));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1.setBackground(new Color(255, 153, 51));
		btnNewButton_1.setBounds(413, 345, 128, 30);
	    getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modelo.removeRow(table.getSelectedRow());
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog( null, "Borrado invalido, revise que haya seleccionado el dato especifico","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnNewButton_2.setBackground(new Color(255, 153, 51));
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(10, 345, 128, 30);
		getContentPane().add(btnNewButton_2);
	}
	
void facturar() {
	 Vender v=new Vender();
	for (int i = 0; i < v.model2.getRowCount(); i++) {
		filas3[0]=Vender.filas2[0];
		filas3[1]=Vender.filas2[1];
		filas3[2]=Vender.filas2[2];
		modelo.addRow(filas3);
			
			for (int j = 0; j < v.model2.getRowCount(); j++) {
				String perro= (String) modelo.getValueAt(j, 1);
				String gato= (String) modelo.getValueAt(j, 2);
				precio=Double.parseDouble(perro);
				cantidad=Integer.parseInt(gato);
				res=precio*cantidad;
				filas3[3]=String.valueOf(res);
			}
	}
	modelo.addRow(filas3);		
 }
	
	}


