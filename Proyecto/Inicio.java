package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class Inicio extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Inicio() {
		setTitle("www.homeejercito.com");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(650, 300, 867, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Actualizacion a = new Actualizacion();
				a.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(570, 94, 198, 100);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PREVIEW");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				dispose();
				Visualizacion v = new Visualizacion();
				v.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(72, 94, 198, 100);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				AlistarSoldados al = new AlistarSoldados();
				al.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(72, 281, 198, 100);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UNSUBSCRIBE");
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Bajas b = new Bajas();
				b.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(570, 281, 198, 100);
		panel.add(btnNewButton_3);
		
		JTextArea txtrVisualizar = new JTextArea();
		txtrVisualizar.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrVisualizar.setForeground(new Color(0, 255, 0));
		txtrVisualizar.setEditable(false);
		txtrVisualizar.setBackground(Color.LIGHT_GRAY);
		txtrVisualizar.setText("VISUALIZAR EJ.");
		txtrVisualizar.setBounds(90, 61, 146, 22);
		panel.add(txtrVisualizar);
		
		JTextArea txtrAadir = new JTextArea();
		txtrAadir.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrAadir.setForeground(Color.CYAN);
		txtrAadir.setEditable(false);
		txtrAadir.setBackground(Color.LIGHT_GRAY);
		txtrAadir.setText("A\u00D1ADIR SOLDADOS");
		txtrAadir.setBounds(90, 248, 162, 22);
		panel.add(txtrAadir);
		
		JTextArea txtrActualizar = new JTextArea();
		txtrActualizar.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrActualizar.setForeground(Color.ORANGE);
		txtrActualizar.setEditable(false);
		txtrActualizar.setBackground(Color.LIGHT_GRAY);
		txtrActualizar.setText("ACTUALIZAR DATOS");
		txtrActualizar.setBounds(585, 61, 183, 22);
		panel.add(txtrActualizar);
		
		JTextArea txtrDarDeBaja = new JTextArea();
		txtrDarDeBaja.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrDarDeBaja.setForeground(Color.RED);
		txtrDarDeBaja.setEditable(false);
		txtrDarDeBaja.setBackground(Color.LIGHT_GRAY);
		txtrDarDeBaja.setText("DAR DE BAJA");
		txtrDarDeBaja.setBounds(609, 248, 114, 22);
		panel.add(txtrDarDeBaja);
		
		JButton btnNewButton_4 = new JButton("SIGN OUT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login l = new Login();
				l.setVisible(true);
				
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(351, 424, 96, 34);
		panel.add(btnNewButton_4);
		
		JTextArea txtrPginaPrincipal = new JTextArea();
		txtrPginaPrincipal.setText("P\u00C1GINA PRINCIPAL");
		txtrPginaPrincipal.setForeground(new Color(0, 128, 0));
		txtrPginaPrincipal.setFont(new Font("MS Gothic", Font.BOLD, 34));
		txtrPginaPrincipal.setEditable(false);
		txtrPginaPrincipal.setBackground(Color.LIGHT_GRAY);
		txtrPginaPrincipal.setBounds(261, 24, 308, 34);
		panel.add(txtrPginaPrincipal);
		
		JTextArea txtrAvailability = new JTextArea();
		txtrAvailability.setText("Disponibilidad");
		txtrAvailability.setForeground(Color.MAGENTA);
		txtrAvailability.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrAvailability.setEditable(false);
		txtrAvailability.setBackground(Color.LIGHT_GRAY);
		txtrAvailability.setBounds(343, 158, 146, 22);
		panel.add(txtrAvailability);
		
		JButton btnNewButton_5 = new JButton("Availability");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Disponibilidad d = new Disponibilidad();
				d.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(Color.MAGENTA);
		btnNewButton_5.setBounds(343, 191, 146, 79);
		panel.add(btnNewButton_5);
	}
}
