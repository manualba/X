package Proyecto;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import grafico.prueba;

import javax.swing.event.AncestorEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JCheckBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Login() {
		
		String a = "";
		
		Conexion c = new Conexion();
		c.Conectar();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));
		setTitle("www.loginejercito.com");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 457, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea txtrUsuario = new JTextArea();
		txtrUsuario.setForeground(Color.RED);
		txtrUsuario.setBackground(Color.LIGHT_GRAY);
		txtrUsuario.setBounds(34, 91, 76, 26);
		txtrUsuario.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtrUsuario.setText("USERNAME:");
		txtrUsuario.setEditable(false);
		panel.add(txtrUsuario);
		
		try {
			a = prueba.recordar();
		} catch (IOException e2) {}
		textField = new JTextField(a);
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.PINK);
		textField.setBounds(114, 94, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrContrasea = new JTextArea();
		txtrContrasea.setEditable(false);
		txtrContrasea.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		txtrContrasea.setForeground(Color.RED);
		txtrContrasea.setBackground(Color.LIGHT_GRAY);
		txtrContrasea.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrContrasea.setText("PASSWORD:");
		txtrContrasea.setBounds(34, 128, 76, 20);
		panel.add(txtrContrasea);
		
		JTextArea txtrProyectoManu = new JTextArea();
		txtrProyectoManu.setBackground(Color.LIGHT_GRAY);
		txtrProyectoManu.setEditable(false);
		txtrProyectoManu.setForeground(new Color(0, 100, 0));
		txtrProyectoManu.setFont(new Font("Perpetua Titling MT", Font.BOLD, 33));
		txtrProyectoManu.setText("WEB EJ\u00C9RCITO");
		txtrProyectoManu.setBounds(88, 22, 258, 41);
		panel.add(txtrProyectoManu);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBackground(Color.PINK);
		passwordField.setBounds(114, 130, 86, 20);
		panel.add(passwordField);
		
		JCheckBox recordar = new JCheckBox("Recordar usuario");
		recordar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		recordar.setBackground(Color.LIGHT_GRAY);
		recordar.setBounds(136, 179, 139, 23);
		panel.add(recordar);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				
				ResultSet resultado = c.EjecutarSentencia(
						"SELECT * FROM loginprograma "+
						"WHERE Usuario = '" + textField.getText()  +
						"'AND Password='" + passwordField.getText()+"'");
				
				try {
					
					if (resultado.next()){

						if(recordar.isSelected()) {
							try {
								prueba.guardar(textField.getText());	
							} catch (Exception e1) {}
						}	
						
						Inicio i = new Inicio();
						i.setVisible(true);

					}else {
						
						dispose();
						JOptionPane.showMessageDialog(null, "Tu nombre de usuario o contraseña no son correctos ", "ERROR", JOptionPane.OK_OPTION);
						Login l = new Login();
						l.setVisible(true);

					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				
		}
			
		});
		
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setForeground(Color.DARK_GRAY);
		btnEntrar.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnEntrar.setBounds(34, 170, 89, 41);
		panel.add(btnEntrar);
		
		
		
		JTextArea txtrnoTienesUsuario = new JTextArea();
		txtrnoTienesUsuario.setEditable(false);
		txtrnoTienesUsuario.setBackground(Color.LIGHT_GRAY);
		txtrnoTienesUsuario.setFont(new Font("Aparajita", Font.PLAIN, 14));
		txtrnoTienesUsuario.setText("\u00BFNo tienes usuario?");
		txtrnoTienesUsuario.setBounds(213, 245, 100, 20);
		panel.add(txtrnoTienesUsuario);
		
		JTextArea txtrRegistrateAquiAhora = new JTextArea();
		txtrRegistrateAquiAhora.setEditable(false);
		txtrRegistrateAquiAhora.setBackground(Color.LIGHT_GRAY);
		txtrRegistrateAquiAhora.setFont(new Font("Aparajita", Font.PLAIN, 13));
		txtrRegistrateAquiAhora.setText("Registrate aqui ahora!!");
		txtrRegistrateAquiAhora.setBounds(213, 265, 100, 22);
		panel.add(txtrRegistrateAquiAhora);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				RegistroCuenta r = new RegistroCuenta();
				r.setVisible(true);
			}
		});
		btnRegistrar.setBounds(319, 263, 100, 20);
		panel.add(btnRegistrar);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				VisualizacionSR vsr = new VisualizacionSR();
				vsr.setVisible(true);
				
			}
		});
		button.setBounds(10, 280, 100, 9);
		panel.add(button);
		
		JTextArea txtrEntrarSinRegistrar = new JTextArea();
		txtrEntrarSinRegistrar.setEditable(false);
		txtrEntrarSinRegistrar.setBackground(Color.LIGHT_GRAY);
		txtrEntrarSinRegistrar.setFont(new Font("Monospaced", Font.PLAIN, 9));
		txtrEntrarSinRegistrar.setText("Entrar sin registrar");
		txtrEntrarSinRegistrar.setBounds(10, 265, 113, 18);
		panel.add(txtrEntrarSinRegistrar);
		
		
		
	}
}
