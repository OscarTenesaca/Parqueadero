package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objetoNegocio.VehiculoON;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class FrameVehiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtColor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVehiculo frame = new FrameVehiculo();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameVehiculo() {
		setBounds(100, 100, 491, 392);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(26, 97, 81, 21);
		contentPane.add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(26, 133, 81, 21);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(26, 166, 81, 21);
		contentPane.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(26, 199, 81, 21);
		contentPane.add(lblColor);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(119, 97, 141, 18);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(119, 130, 141, 21);
		contentPane.add(txtMarca);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(119, 163, 141, 21);
		contentPane.add(txtModelo);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(119, 196, 141, 21);
		contentPane.add(txtColor);
		
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("Iconos/IconoAgregar.png"));
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VehiculoON von = new VehiculoON();
			
				if (von.validarCampos(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(), txtColor.getText())== true) {	
				von.reguistrarVehiculo(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText(), txtColor.getText());
				txtPlaca.setText("");
				txtMarca.setText("");
				txtModelo.setText("");
				txtColor.setText("");
				
				}else {
				
					JOptionPane.showMessageDialog(null, "Error al registrar revice los campos");
				}
			
				
			}
		});
		btnRegistrar.setBounds(26, 261, 120, 44);
		contentPane.add(btnRegistrar);
		
		JLabel lblFotoVehiculo = new JLabel(" ");
		lblFotoVehiculo.setIcon(new ImageIcon("Iconos/IconoVehiculo.png"));
		lblFotoVehiculo.setBounds(301, 119, 170, 180);
		contentPane.add(lblFotoVehiculo);
		
		JLabel lblRegistroVehiculo = new JLabel("Registro Vehiculo");
		lblRegistroVehiculo.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblRegistroVehiculo.setBounds(135, 17, 225, 27);
		contentPane.add(lblRegistroVehiculo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon("Iconos/iconoModificar.png"));
		btnModificar.setBounds(169, 261, 120, 44);
		contentPane.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("Iconos/IconoBuscar.png"));
		btnBuscar.setBounds(309, 70, 120, 44);
		contentPane.add(btnBuscar);
	}
}
