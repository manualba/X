package Proyecto;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class Disponibilidad extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;


	/**
	 * Create the frame.
	 */
	public Disponibilidad() {
		setTitle("www.availabilityejercito.com");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));
		
		Conexion c = new Conexion();
		c.Conectar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 783, 496);
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
		
		JTextArea BAJAS = new JTextArea();
		BAJAS.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 21));
		BAJAS.setEditable(false);
		BAJAS.setBackground(Color.LIGHT_GRAY);
		BAJAS.setForeground(new Color(0, 128, 0));
		BAJAS.setText("Disponibilidad");
		BAJAS.setBounds(286, 11, 188, 28);
		panel.add(BAJAS);
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		tabla1 = new JTable(modelo);
		tabla1.setEnabled(false);
		tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla1.setBackground(Color.WHITE);
		tabla1.setBounds(10, 69, 464, 305);
		panel.add(tabla1);
		
		JTextField dni = new JTextField();
		RestrictedTextField r1 = new RestrictedTextField(dni, "1234567890");
		r1.setLimit(8);
		
		

		
		JTextArea txtrIntroduceElDni = new JTextArea();
		txtrIntroduceElDni.setForeground(Color.RED);
		txtrIntroduceElDni.setBackground(Color.LIGHT_GRAY);
		txtrIntroduceElDni.setEditable(false);
		txtrIntroduceElDni.setText("DNI del Soldado: ");
		txtrIntroduceElDni.setBounds(495, 285, 130, 23);
		panel.add(txtrIntroduceElDni);
		
		JTextArea txtrLaDisponibilidadDe = new JTextArea();
		txtrLaDisponibilidadDe.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrLaDisponibilidadDe.setText("La disponibilidad de un soldado");
		txtrLaDisponibilidadDe.setForeground(Color.BLACK);
		txtrLaDisponibilidadDe.setEditable(false);
		txtrLaDisponibilidadDe.setBackground(Color.LIGHT_GRAY);
		txtrLaDisponibilidadDe.setBounds(495, 64, 238, 23);
		panel.add(txtrLaDisponibilidadDe);
		
		JTextArea txtrSeMarcaraCon = new JTextArea();
		txtrSeMarcaraCon.setText("se marcara con una \"X\"");
		txtrSeMarcaraCon.setForeground(Color.BLACK);
		txtrSeMarcaraCon.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrSeMarcaraCon.setEditable(false);
		txtrSeMarcaraCon.setBackground(Color.LIGHT_GRAY);
		txtrSeMarcaraCon.setBounds(495, 91, 238, 23);
		panel.add(txtrSeMarcaraCon);
		
		JTextArea txtrCuandoEsteNo = new JTextArea();
		txtrCuandoEsteNo.setText("cuando este no est\u00E9 disponible");
		txtrCuandoEsteNo.setForeground(Color.BLACK);
		txtrCuandoEsteNo.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrCuandoEsteNo.setEditable(false);
		txtrCuandoEsteNo.setBackground(Color.LIGHT_GRAY);
		txtrCuandoEsteNo.setBounds(495, 116, 238, 23);
		panel.add(txtrCuandoEsteNo);
		
		JTextArea txtrParaElServicio = new JTextArea();
		txtrParaElServicio.setText("para el servicio.");
		txtrParaElServicio.setForeground(Color.BLACK);
		txtrParaElServicio.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrParaElServicio.setEditable(false);
		txtrParaElServicio.setBackground(Color.LIGHT_GRAY);
		txtrParaElServicio.setBounds(495, 142, 238, 23);
		panel.add(txtrParaElServicio);
		
		JTextArea txtrDisponible = new JTextArea();
		txtrDisponible.setText("Disponible:");
		txtrDisponible.setForeground(Color.RED);
		txtrDisponible.setEditable(false);
		txtrDisponible.setBackground(Color.LIGHT_GRAY);
		txtrDisponible.setBounds(507, 237, 89, 23);
		panel.add(txtrDisponible);
		
		JComboBox marcar = new JComboBox();
		marcar.setBounds(606, 239, 44, 20);
		marcar.addItem(" ");
		marcar.addItem("X");
		panel.add(marcar);
		
		dni.setBounds(630, 286, 117, 23);
		panel.add(dni);
		
		
		JButton actualizar = new JButton("ACTUALIZAR");
		actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (dni.getText().length() == 8) {
					
					dispose();
					
					
					JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS!!! ", "",JOptionPane.INFORMATION_MESSAGE);
					
					try {
						
						c.EjecutarUpdate("UPDATE listado_soldados SET Disponibilidad = \"" + marcar.getSelectedItem() + "\" WHERE listado_soldados.DNI = " + dni.getText());
						
						
						
						
					} catch (SQLException e4) {
						
						e4.printStackTrace();
					}
					
					
					Disponibilidad d = new Disponibilidad();
					d.setVisible(true);
					
				} else {
					
					
					JOptionPane.showMessageDialog(null, "SE TE OLVIDA ALGO... EL DNI!!! ", "VUELVE A INTENTARLO",JOptionPane.WARNING_MESSAGE);
					
				}
				
				
			}
			
		});
		
		actualizar.setBounds(630, 320, 117, 54);
		panel.add(actualizar);

	
		modelo.addColumn("Nombre");
		modelo.addColumn("DNI");
		modelo.addColumn("Disponibilidad");
		
		
		
		ResultSet rs = Conexion.EjecutarSentencia("SELECT DNI,Nombre,Disponibilidad FROM listado_soldados");

		try {
			while(rs.next()) {
				String[] filas = new String[3];
				for(int i = 0 ; i < 3 ; i++) {
					filas[i] = rs.getString(i+1);
				}
				modelo.addRow(filas);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane scrollBar = new JScrollPane(tabla1);
		scrollBar.setBounds(10, 50, 450, 336);
		panel.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
}
