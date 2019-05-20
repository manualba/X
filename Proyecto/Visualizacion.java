package Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Visualizacion extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;


	/**
	 * Create the frame.
	 */
	public Visualizacion() {
		setTitle("www.visualizacionejercito.com");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Desktop\\MANU\\###################\\Ejercito.jpg"));
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
		
		JTextArea txtrVisualizacionDelListado = new JTextArea();
		txtrVisualizacionDelListado.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		txtrVisualizacionDelListado.setEditable(false);
		txtrVisualizacionDelListado.setBackground(Color.LIGHT_GRAY);
		txtrVisualizacionDelListado.setForeground(new Color(0, 128, 0));
		txtrVisualizacionDelListado.setText("VISUALIZACION DEL LISTADO DE TROPAS");
		txtrVisualizacionDelListado.setBounds(213, 11, 298, 28);
		panel.add(txtrVisualizacionDelListado);
		
		
		DefaultTableModel modelo = new DefaultTableModel();
		tabla1 = new JTable(modelo);
		tabla1.setEnabled(false);
		tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla1.setBackground(Color.LIGHT_GRAY);
		tabla1.setBounds(10, 69, 706, 305);
		panel.add(tabla1);
		
		modelo.addColumn("Nombre");
		modelo.addColumn("DNI");
		modelo.addColumn("Sexo");
		modelo.addColumn("Rango");
		modelo.addColumn("Cuerpo");
		modelo.addColumn("Disponibilidad");
		
		
		ResultSet rs = Conexion.EjecutarSentencia("SELECT * FROM listado_soldados");

		try {
			while(rs.next()) {
				String[] filas = new String[6];
				for(int i = 0 ; i < 6 ; i++) {
					filas[i] = rs.getString(i+1);
				}
				modelo.addRow(filas);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollBar = new JScrollPane(tabla1);
		scrollBar.setBounds(10, 50, 737, 336);
		panel.add(scrollBar);
		scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
}
