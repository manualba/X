package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class Actualizacion extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;


	/**
	 * Create the frame.
	 */
	public Actualizacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));
		setTitle("www.updateejercito.com");
		
		Conexion c = new Conexion();
		c.Conectar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 874, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio i = new Inicio();
				i.setVisible(true);

				
			}
		});
		btnVolver.setBounds(10, 397, 89, 23);
		panel.add(btnVolver);
		
		JTextArea ACTUALIZAR = new JTextArea();
		ACTUALIZAR.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 17));
		ACTUALIZAR.setEditable(false);
		ACTUALIZAR.setBackground(Color.LIGHT_GRAY);
		ACTUALIZAR.setForeground(new Color(0, 128, 0));
		ACTUALIZAR.setText("ACTUALIZACION DE TROPAS");
		ACTUALIZAR.setBounds(249, 11, 298, 28);
		panel.add(ACTUALIZAR);
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		tabla1 = new JTable(modelo);
		tabla1.setEnabled(false);
		tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla1.setBackground(Color.WHITE);
		tabla1.setBounds(10, 69, 438, 305);
		panel.add(tabla1);
		
		JComboBox rangoos = new JComboBox();
		rangoos.setBounds(603, 205, 129, 23);
		rangoos.addItem("Recluta");
		rangoos.addItem("Soldado");
		rangoos.addItem("Cabo");
		rangoos.addItem("Sargento");
		rangoos.addItem("Teniente");
		rangoos.addItem("Capitan");
		rangoos.addItem("Comandante");
		rangoos.addItem("General Terrestre");
		rangoos.addItem("General Aire");
		rangoos.addItem("General Naval");
		rangoos.addItem("Capitan General");
		panel.add(rangoos);
		
		JComboBox Cuerpo = new JComboBox();
		Cuerpo.setBounds(603, 242, 129, 23);
		Cuerpo.addItem("Terrestre");
		Cuerpo.addItem("Aire");
		Cuerpo.addItem("Naval");
		panel.add(Cuerpo);
		
		JTextArea txtrIntroduceElDni = new JTextArea();
		txtrIntroduceElDni.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrIntroduceElDni.setBackground(Color.LIGHT_GRAY);
		txtrIntroduceElDni.setEditable(false);
		txtrIntroduceElDni.setText("Introduce el DNI para actualizar al soldado:");
		txtrIntroduceElDni.setBounds(505, 107, 311, 23);
		panel.add(txtrIntroduceElDni);
		
		JTextField dni = new JTextField();
		RestrictedTextField r1 = new RestrictedTextField(dni, "1234567890");
		r1.setLimit(8);
		
		dni.setBounds(604, 129, 89, 23);
		panel.add(dni);
		
		JTextArea txtrRango_1 = new JTextArea();
		txtrRango_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrRango_1.setEditable(false);
		txtrRango_1.setBackground(Color.LIGHT_GRAY);
		txtrRango_1.setText("Rango:");
		txtrRango_1.setBounds(505, 202, 64, 23);
		panel.add(txtrRango_1);
		
		JTextArea txtrCuerpo_1 = new JTextArea();
		txtrCuerpo_1.setText("Cuerpo:");
		txtrCuerpo_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrCuerpo_1.setEditable(false);
		txtrCuerpo_1.setBackground(Color.LIGHT_GRAY);
		txtrCuerpo_1.setBounds(505, 236, 74, 23);
		panel.add(txtrCuerpo_1);
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (dni.getText().length() == 8) {
					
					dispose();
					
					
					JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS!!! ", "",JOptionPane.INFORMATION_MESSAGE);
					
					try {
	
						//System.out.println("UPDATE listado_soldados SET Rango = \"" + rangoos.getSelectedItem() + "\", Cuerpo =\"" + Cuerpo.getSelectedItem() + "\" WHERE listado_soldados.DNI = " + dni.getText());
						c.EjecutarUpdate("UPDATE listado_soldados SET Rango = \"" + rangoos.getSelectedItem() + "\", Cuerpo =\"" + Cuerpo.getSelectedItem() + "\" WHERE listado_soldados.DNI = " + dni.getText());
						
						
						
						
					} catch (SQLException e4) {
						
						e4.printStackTrace();
					}
					
					
					Actualizacion a = new Actualizacion();
					a.setVisible(true);

				} else {
					
					
					JOptionPane.showMessageDialog(null, "LA LIASTE!! ", "VUELVE A INTENTARLO",JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		
		btnNewButton.setBounds(704, 329, 112, 45);
		panel.add(btnNewButton);
		
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Rango");
		modelo.addColumn("Cuerpo");
		
		
		ResultSet rs = Conexion.EjecutarSentencia("SELECT DNI,Nombre,Rango,Cuerpo FROM listado_soldados");

		try {
			while(rs.next()) {
				String[] filas = new String[4];
				for(int i = 0 ; i < 4 ; i++) {
					filas[i] = rs.getString(i+1);
				}
				modelo.addRow(filas);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane scrollBar = new JScrollPane(tabla1);
		scrollBar.setBounds(10, 50, 485, 335);
		panel.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	
}
