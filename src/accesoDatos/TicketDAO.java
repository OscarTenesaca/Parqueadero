package accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidadNegocio.TicketEN;
import objetoNegocio.ConexionBD;

public class TicketDAO {
	
	
	

	public int GenerarCodigo() {
	
			
		Connection c = null;
			String sql="SELECT  count(*)"
					+" FROM Ticket";		
			try {
				   c=ConexionBD.getConnection();
					PreparedStatement rs=c.prepareStatement(sql);
			   
			    ResultSet ps=rs.executeQuery();
			  
			    while(ps.next())
			    {
			
			  int valor=ps.getInt(1);
			 
			 // System.out.println(valor+"valor actual");
			 return valor+1;
				  
			    }
			} catch (Exception e) {
			   // e.printStackTrace();
			} finally {
				ConexionBD.close(c);
			}
			JOptionPane.showMessageDialog(null, "no existe dato");	
			return 0;
		}
	
	

	public void insertar (TicketEN ticket) {
		
		Connection c=null;
		
		String query = "INSERT INTO Ticket (id, numTicket, fechaActual, horaInicio, horaFin, placa_vehiculo) VALUES (?,?,?,?,?,?)";
		
		try {
			
			
			c=ConexionBD.getConnection();
			PreparedStatement rs=c.prepareStatement(query);
			rs.setInt(1, ticket.getId());
			rs.setString(2, ticket.getNumTicket());
			rs.setString(3, ticket.getFecha());
			rs.setString(4, ticket.getHoraInicio());
			rs.setString(5,ticket.getHoraFin());
			rs.setString(6,ticket.getPlaca());
			
			rs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Operacion Exitosa");
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			ConexionBD.close(c);
		}
		
	}
	
	
	
	public List<TicketEN> listar(){
		
		
		List<TicketEN> listTicket= new ArrayList<TicketEN>();  
		String sql="SELECT  *  FROM Ticket";
		
		
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		   
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	TicketEN c=new TicketEN();
		       
		       
		      c.setId				(rs.getInt("id"));
		      c.setNumTicket		(rs.getString("numTicket"));
		      c.setFecha			(rs.getString("fechaActual"));
		      c.setHoraInicio		(rs.getString("horaInicio"));
		      c.setHoraFin			(rs.getString("horaFin"));
		      c.setPlaca			(rs.getString("placa_vehiculo"));

		      listTicket.add(c);
		      
		      
		    
		       
		    }
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
		return listTicket;
	}

	
	
	
	

}
