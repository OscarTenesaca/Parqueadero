package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import entidadNegocio.TicketEN;
import objetoNegocio.ConexionBD;
import objetoNegocio.Hilo;
import objetoNegocio.TicketON;
import objetoNegocio.VehiculoON;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;

public class FrameTicket extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumTicket;
	private JTextField txtHoraFin;
	private String mensaje; 
	private JTable table;
	
	TicketON ton;
	FrameVehiculo fv;
	ConexionBD cbd;
	
	private JTextField textField;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTicket frame = new FrameTicket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameTicket() {
		
		ton = new TicketON();
		cbd= new ConexionBD();
		
		
		mensaje = "<html> <p>Conserve el ticket en un lugar seguro."
				+ "En caso de perdida debera presentar documentos que pueda "
				+ "comprobar que los datos coicidan con los registros de la caja y  cancelar $ 5.00</p></html>";
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 618);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParqueaderoOr = new JLabel("GALA-Park");
		lblParqueaderoOr.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblParqueaderoOr.setBounds(174, 17, 164, 38);
		contentPane.add(lblParqueaderoOr);
		
		JLabel lblNumTicket = new JLabel("Numero Ticket:");
		lblNumTicket.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNumTicket.setBounds(21, 89, 109, 27);
		contentPane.add(lblNumTicket);
		
		JLabel lblFechaActual = new JLabel("Fecha Actual:");
		lblFechaActual.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFechaActual.setBounds(21, 175, 109, 27);
		contentPane.add(lblFechaActual);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHoraInicio.setBounds(21, 214, 109, 27);
		contentPane.add(lblHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora Fin:");
		lblHoraFin.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHoraFin.setBounds(21, 253, 109, 27);
		contentPane.add(lblHoraFin);
		
		JLabel lblDescripcion = new JLabel(mensaje);
		lblDescripcion.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblDescripcion.setBounds(21, 361, 481, 86);
		contentPane.add(lblDescripcion);
		
	
		txtNumTicket = new JTextField();
		txtNumTicket.setBounds(142, 89, 130, 27);
		txtNumTicket.setText(""+ton.numeroTicket());
		txtNumTicket.enable(false);	
		contentPane.add(txtNumTicket);
		txtNumTicket.setColumns(10);
		
		JLabel lblFechaAct = new JLabel(""+	ton.FechaActua());
		lblFechaAct.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFechaAct.setBounds(142, 175, 109, 27);
		contentPane.add(lblFechaAct);
		
		JLabel lblHoraIni = new JLabel(""+ ton.HoraInicio());
		lblHoraIni.setFont(new Font("Lucida Grande", Font.BOLD, 13));

		lblHoraIni.setBounds(142, 214, 109, 27);
		contentPane.add(lblHoraIni);
		lblHoraIni.setEnabled(false);
		Hilo h= new Hilo(lblHoraIni);
		h.start();
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setIcon(new ImageIcon("Iconos/IconoTicket.png"));
		lblFoto.setBounds(316, 137, 186, 161);
		contentPane.add(lblFoto);
		
		
		txtHoraFin = new JTextField();
		txtHoraFin.setBounds(142, 253, 130, 27);
		contentPane.add(txtHoraFin);
		txtHoraFin.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPlaca.setBounds(21, 128, 109, 27);
		contentPane.add(lblPlaca);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(142, 128, 130, 27);
		contentPane.add(textField);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setIcon(new ImageIcon("Iconos/IconoImprimir.png"));
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtNumTicket.setText((ton.numeroTicket()+1)+"");
				
				TicketON ton = new TicketON();
				VehiculoON von = new VehiculoON();
				System.out.println(von.comprobarPlaca(textField.getText()));
				
				if (von.comprobarPlaca(textField.getText()) == true) {
					System.out.println("entro 2");
					
					ton.reguistrarTicket(txtNumTicket.getText(), lblFechaAct.getText(), lblHoraIni.getText(), txtHoraFin.getText(), textField.getText() );
					
				}else {
					JOptionPane.showMessageDialog(null, "La placa no existe, registre el Vehiculo");
				}
 
			}
		});
		btnImprimir.setBounds(87, 310, 122, 43);
		contentPane.add(btnImprimir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon("Iconos/IconoListar.png"));
		btnListar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int filas = 0;
				int cont = 0;
				
				List<TicketEN> d = ton.mostrar();
				

				for (TicketEN t : d) {
					
					model.addRow(new Object[filas]);
					
					table.setValueAt(t.getId(), cont, 0);
					table.setValueAt(t.getNumTicket(), cont, 1);
					table.setValueAt(t.getFecha(), cont, 2);
					table.setValueAt(t.getHoraInicio(), cont, 3);
					table.setValueAt(t.getHoraFin(), cont, 4);
					table.setValueAt(t.getPlaca(), cont, 5);
					filas ++;
					cont++;
				}	
			}
		});
		btnListar.setBounds(275, 310, 130, 43);
		contentPane.add(btnListar);
	
		
		JButton btnRegistrarVehiculo = new JButton("Registrar Vehiculo");
		btnRegistrarVehiculo.setIcon(new ImageIcon("Iconos/IconoAgregar.png"));
		btnRegistrarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fv=new FrameVehiculo();
				fv.setVisible(true);
			
			
			}
		});
		
		btnRegistrarVehiculo.setBounds(338, 82, 164, 43);
		contentPane.add(btnRegistrarVehiculo);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {"Id", "Ticket", "Fecha", "HoraInicio ", "HoraFin", "Placa" }));

		table.setBounds(21, 459, 447, 195);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 460, 447, 119);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
	
		
	}
}
