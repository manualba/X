package Proyecto;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class RegistroCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public RegistroCuenta() {
		setTitle("www.registerejercito.com");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));

		Conexion c = new Conexion();
		c.Conectar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrRegistroDeCuenta = new JTextArea();
		txtrRegistroDeCuenta.setBackground(Color.LIGHT_GRAY);
		txtrRegistroDeCuenta.setForeground(new Color(0, 128, 0));
		txtrRegistroDeCuenta.setEditable(false);
		txtrRegistroDeCuenta.setFont(new Font("MS Gothic", Font.BOLD, 24));
		txtrRegistroDeCuenta.setText("REGISTRO DE CUENTA");
		txtrRegistroDeCuenta.setBounds(83, 30, 282, 42);
		contentPane.add(txtrRegistroDeCuenta);

		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 128, 0));
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setText("___________________________________________________");
		textArea.setBounds(68, 59, 273, 35);
		contentPane.add(textArea);

		JTextArea txtrUsuario = new JTextArea();
		txtrUsuario.setBackground(Color.LIGHT_GRAY);
		txtrUsuario.setForeground(Color.DARK_GRAY);
		txtrUsuario.setEditable(false);
		txtrUsuario.setText("USERNAME:");
		txtrUsuario.setBounds(35, 108, 73, 20);
		contentPane.add(txtrUsuario);

		textField = new JTextField();
		textField.setBounds(134, 110, 76, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				passwordField = new JPasswordField();

			}

		});

		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				passwordField_1 = new JPasswordField();

			}

		});

		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (passwordField.getText().equals(passwordField_1.getText()) && textField.getText().length() > 1 && passwordField.getText().length() > 1) {
					
					dispose();
					
					JOptionPane.showMessageDialog(null, "Bienvenido!! ", "YA SE HA REGISTRADO",JOptionPane.YES_NO_CANCEL_OPTION);

					// Llevar los datos registrados a la base de datos
					
					try {
	
						c.EjecutarUpdate("INSERT INTO loginprograma (Usuario,Password) VALUES (\""+ textField.getText() + "\", \"" + passwordField.getText() + "\");");
						//c.EjecutarUpdate("INSERT INTO loginprograma (Usuario,Password) VALUES (\""+ textField.getText() + "\", \"" + passwordField.getText() + "\");");
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
					
					Login l = new Login();
					l.setVisible(true);

				} else {
					
					JTextPane txtpnTextoError = new JTextPane();
					txtpnTextoError.setEditable(false);
					txtpnTextoError.setForeground(Color.RED);
					txtpnTextoError.setBackground(Color.LIGHT_GRAY);
					txtpnTextoError.setText("Las contraseñas no coinciden!!");
					txtpnTextoError.setBounds(35, 199, 243, 23);
					contentPane.add(txtpnTextoError);
					
					
				}

			}

		});
		btnRegistrar.setBounds(288, 193, 108, 42);
		contentPane.add(btnRegistrar);

		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setBackground(Color.LIGHT_GRAY);
		txtrContrasea.setForeground(Color.DARK_GRAY);
		txtrContrasea.setEditable(false);
		txtrContrasea.setText("PASSWORD:");
		txtrContrasea.setBounds(35, 139, 89, 20);
		contentPane.add(txtrContrasea);

		passwordField.setBounds(134, 141, 76, 20);
		contentPane.add(passwordField);

		JTextArea txtrRecontrasea = new JTextArea();
		txtrRecontrasea.setBackground(Color.LIGHT_GRAY);
		txtrRecontrasea.setForeground(Color.DARK_GRAY);
		txtrRecontrasea.setEditable(false);
		txtrRecontrasea.setText("RePASSWORD:");
		txtrRecontrasea.setBounds(35, 168, 89, 20);
		contentPane.add(txtrRecontrasea);

		passwordField_1.setBounds(134, 170, 76, 20);
		contentPane.add(passwordField_1);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(19, 228, 89, 23);
		contentPane.add(btnCancelar);

		JTextArea txtrminCaracteres = new JTextArea();
		txtrminCaracteres.setEditable(false);
		txtrminCaracteres.setBackground(Color.LIGHT_GRAY);
		txtrminCaracteres.setForeground(Color.DARK_GRAY);
		txtrminCaracteres.setText("(MIN. 2 caracteres)");
		txtrminCaracteres.setBounds(220, 108, 156, 20);
		contentPane.add(txtrminCaracteres);

		JTextArea txtrminCaracteres_1 = new JTextArea();
		txtrminCaracteres_1.setBackground(Color.LIGHT_GRAY);
		txtrminCaracteres_1.setEditable(false);
		txtrminCaracteres_1.setText("(MIN. 2 caracteres)");
		txtrminCaracteres_1.setBounds(220, 139, 158, 20);
		contentPane.add(txtrminCaracteres_1);
		
		
	}
}

