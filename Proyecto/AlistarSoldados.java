package Proyecto;

import Atxy2k.CustomTextField.RestrictedTextField;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class AlistarSoldados extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AlistarSoldados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));
		setTitle("www.addejercito.com");
		
		Conexion c = new Conexion();
		c.Conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 450, 300);
		contentPane = new JPanel();
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
		btnVolver.setBounds(10, 218, 89, 23);
		panel.add(btnVolver);
		
		JTextArea txtrAlistamientoAlEjercito = new JTextArea();
		txtrAlistamientoAlEjercito.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		txtrAlistamientoAlEjercito.setEditable(false);
		txtrAlistamientoAlEjercito.setForeground(new Color(0, 128, 0));
		txtrAlistamientoAlEjercito.setBackground(Color.LIGHT_GRAY);
		txtrAlistamientoAlEjercito.setText("ALISTAMIENTO AL EJERCITO");
		txtrAlistamientoAlEjercito.setBounds(114, 11, 211, 23);
		panel.add(txtrAlistamientoAlEjercito);
		
		JTextArea txtrNombreYApellidos = new JTextArea();
		txtrNombreYApellidos.setForeground(Color.RED);
		txtrNombreYApellidos.setBackground(Color.LIGHT_GRAY);
		txtrNombreYApellidos.setEditable(false);
		txtrNombreYApellidos.setText("Nombre y Apellidos del soldado:");
		txtrNombreYApellidos.setBounds(10, 58, 252, 23);
		panel.add(txtrNombreYApellidos);
		
		JTextField soldado = new JTextField();
		soldado.setForeground(Color.BLACK);
		soldado.setBackground(Color.WHITE);
		soldado.setBounds(10, 85, 376, 15);
		panel.add(soldado);
		RestrictedTextField soldado1 = new RestrictedTextField(soldado, "QWERTYUIOPASDFGHJKLÑZXCVBNMqwertyuiopasdfghjklñzxcvbnm ");
		soldado1.setLimit(50);
		
		JTextArea txtrDni = new JTextArea();
		txtrDni.setText("DNI:");
		txtrDni.setForeground(Color.RED);
		txtrDni.setEditable(false);
		txtrDni.setBackground(Color.LIGHT_GRAY);
		txtrDni.setBounds(10, 144, 36, 22);
		panel.add(txtrDni);
		
		JTextField dni = new JTextField();
		dni.setForeground(Color.BLACK);
		dni.setBackground(Color.WHITE);
		dni.setBounds(48, 144, 89, 22);
		panel.add(dni);
		RestrictedTextField r1 = new RestrictedTextField(dni, "1234567890");
		r1.setLimit(8);
		
		
		JTextArea txtrSexomf = new JTextArea();
		txtrSexomf.setText("SEXO:");
		txtrSexomf.setForeground(Color.RED);
		txtrSexomf.setEditable(false);
		txtrSexomf.setBackground(Color.LIGHT_GRAY);
		txtrSexomf.setBounds(10, 177, 44, 22);
		panel.add(txtrSexomf);
		
		JTextArea recluta = new JTextArea();
		recluta.setEditable(false);
		recluta.setBackground(Color.LIGHT_GRAY);
		recluta.setText("Recluta");
		recluta.setBounds(326, 144, 60, 24);
		panel.add(recluta);
		
		JComboBox sexo = new JComboBox();
		sexo.setBounds(58, 177, 51, 20);
		sexo.addItem("M");
		sexo.addItem("F");
		panel.add(sexo);
		
		JTextArea cuerposoldado = new JTextArea();
		cuerposoldado.setBackground(Color.LIGHT_GRAY);
		cuerposoldado.setEditable(false);
		cuerposoldado.setText("-");
		cuerposoldado.setBounds(326, 166, 12, 15);
		panel.add(cuerposoldado);
		
		JButton btnNewButton = new JButton("ALISTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (dni.getText().length() == 8) {
					
					dispose();
					
					
					JOptionPane.showMessageDialog(null, "Soldado añadido!! ", "Soldado Registrado Con Exito",JOptionPane.YES_NO_CANCEL_OPTION);
					
					try {
	
						//System.out.println("INSERT INTO listado_soldados (Nombre, DNI, Sexo, Rango, Cuerpo) VALUES (\""+ soldado.getText() + "\", \""+ dni.getText() + "\", \""+ sexo.getSelectedItem() + "\",\""+ recluta.getText() + "\",\""+ cuerposoldado.getText() + "\");");
						c.EjecutarUpdate("INSERT INTO listado_soldados (Nombre, DNI, Sexo, Rango, Cuerpo) VALUES (\""+ soldado.getText() + "\", \""+ dni.getText() + "\", \""+ sexo.getSelectedItem() + "\",\""+ recluta.getText() + "\",\""+ cuerposoldado.getText() + "\");");
						
						
						
						
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
					
					
					Inicio i = new Inicio();
					i.setVisible(true);

				} else {
					
					
					JOptionPane.showMessageDialog(null, "Algo que has puesto esta MUY MAL ", "VUELVE A INTENTARLO",JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		btnNewButton.setBounds(318, 202, 96, 39);
		panel.add(btnNewButton);
		
		JTextArea txtrMF = new JTextArea();
		txtrMF.setText("M / F");
		txtrMF.setForeground(Color.DARK_GRAY);
		txtrMF.setEditable(false);
		txtrMF.setBackground(Color.LIGHT_GRAY);
		txtrMF.setBounds(136, 177, 51, 22);
		panel.add(txtrMF);
		
		JTextArea txtrEjd = new JTextArea();
		txtrEjd.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrEjd.setText("Ej: 12345678");
		txtrEjd.setForeground(Color.DARK_GRAY);
		txtrEjd.setEditable(false);
		txtrEjd.setBackground(Color.LIGHT_GRAY);
		txtrEjd.setBounds(147, 146, 89, 22);
		panel.add(txtrEjd);
		
		JTextArea txtrNombreApellidoApellido = new JTextArea();
		txtrNombreApellidoApellido.setText("Nombre Apellido1 Apellido2");
		txtrNombreApellidoApellido.setForeground(Color.DARK_GRAY);
		txtrNombreApellidoApellido.setEditable(false);
		txtrNombreApellidoApellido.setBackground(Color.LIGHT_GRAY);
		txtrNombreApellidoApellido.setBounds(10, 102, 226, 22);
		panel.add(txtrNombreApellidoApellido);
		
		JTextArea txtrLosRegistradosSeran = new JTextArea();
		txtrLosRegistradosSeran.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrLosRegistradosSeran.setForeground(Color.RED);
		txtrLosRegistradosSeran.setBackground(Color.LIGHT_GRAY);
		txtrLosRegistradosSeran.setEditable(false);
		txtrLosRegistradosSeran.setText("Los registrados seran:");
		txtrLosRegistradosSeran.setBounds(242, 124, 158, 23);
		panel.add(txtrLosRegistradosSeran);
		
		JTextArea txtrRango = new JTextArea();
		txtrRango.setBackground(Color.LIGHT_GRAY);
		txtrRango.setEditable(false);
		txtrRango.setForeground(Color.RED);
		txtrRango.setText("Rango:");
		txtrRango.setBounds(261, 144, 49, 23);
		panel.add(txtrRango);
		
		JTextArea txtrCuerpo = new JTextArea();
		txtrCuerpo.setBackground(Color.LIGHT_GRAY);
		txtrCuerpo.setForeground(Color.RED);
		txtrCuerpo.setEditable(false);
		txtrCuerpo.setText("Cuerpo:");
		txtrCuerpo.setBounds(261, 166, 64, 22);
		panel.add(txtrCuerpo);
		
		
	}
}
