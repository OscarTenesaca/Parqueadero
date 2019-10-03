package objetoNegocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import accesoDatos.TicketDAO;
import entidadNegocio.TicketEN;


public class TicketON {
	
	
	public String FechaActua() {
		String fechaAct;
		Calendar tiempo=new GregorianCalendar();
		SimpleDateFormat forma_dato= new SimpleDateFormat("dd/MM/yyyy");
		fechaAct = forma_dato.format(tiempo.getTime());
		return fechaAct;	
		}
	
	
	public String HoraInicio() {
		Calendar tiempo=new GregorianCalendar();
		String horaIni;
		horaIni=tiempo.get(Calendar.HOUR_OF_DAY)+":"+tiempo.get(Calendar.MINUTE)+":"+tiempo.get(Calendar.SECOND);		
		return horaIni;	
		}
	

	public int  numeroTicket() {
		TicketDAO tdao = new TicketDAO();
		int numero = tdao.GenerarCodigo();
		
		System.out.println(numero+"num");
		return numero;
	}
	
	public boolean reguistrarTicket( String numTicket, String fechaAct, String horaIni, String horaFin, String placa) {
		
		TicketDAO tdao = new TicketDAO();
		TicketEN ticket = new TicketEN();
		int id = tdao.GenerarCodigo();
		numTicket = "" + numeroTicket();
		
		ticket.setId(id);
		ticket.setNumTicket(numTicket);
		ticket.setFecha(fechaAct);
		ticket.setHoraInicio(horaIni);
		ticket.setHoraFin(horaFin);
		ticket.setPlaca(placa);
		
		tdao.insertar(ticket);
		
		return true;
	}
	


	public List<TicketEN> mostrar() {
		TicketDAO tdao = new TicketDAO();
		List<TicketEN> listaCopia = new ArrayList<TicketEN>(tdao.listar());
		
//		  for (int i = 0; i < listaCopia.size(); i++) {
//			  System.out.println(listaCopia.get(i).getId());
//	    	     System.out.println(listaCopia.get(i).getNumTicket());
//	    	     System.out.println(listaCopia.get(i).getPlaca());
//	    	     System.out.println(listaCopia.get(i).getHoraInicio());
//	    	     System.out.println(listaCopia.get(i).getHoraFin());
//	    	     System.out.println(listaCopia.get(i).getFecha());
//	    	 }
	      
		
		return listaCopia;
	}
		
		
		
	
	
	
	
	

}
