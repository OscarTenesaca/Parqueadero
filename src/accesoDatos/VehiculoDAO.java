package accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import entidadNegocio.TicketEN;
import entidadNegocio.VehiculoEN;
import objetoNegocio.ConexionBD;

public class VehiculoDAO {
	

	public int GenerarId() {
		
		Connection c = null;
			String sql="SELECT  count(*)"
					+" FROM vehiculo";		
			try {
				   c=ConexionBD.getConnection();
					PreparedStatement rs=c.prepareStatement(sql);
			   
			    ResultSet ps=rs.executeQuery();
			  
			    while(ps.next())
			    {
			
			  int valor=ps.getInt(1);
			 
			  System.out.println(valor+"valor actual");
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
	
	
	
	public void insertar (VehiculoEN vehiculo) {
		
		Connection c=null;
		
		String query = "INSERT INTO vehiculo (id, placa, marca, modelo, color) VALUES (?,?,?,?,?)";
		
		try {
			
			
			c=ConexionBD.getConnection();
			PreparedStatement rs=c.prepareStatement(query);
			
			rs.setInt(1, vehiculo.getId() );
			rs.setString(2, vehiculo.getPlaca());
			rs.setString(3, vehiculo.getMarca());
			rs.setString(4, vehiculo.getModelo());
			rs.setString(5,vehiculo.getColor());
			
			rs.executeUpdate();
			JOptionPane.showMessageDialog(null, "Operacion Exitosa");
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			ConexionBD.close(c);
		}
		
	}
	
	public VehiculoEN verificarPlaca(String placa) {
		
		VehiculoEN vehiculo = new VehiculoEN();
		Connection c = null;
		String sql="SELECT  placa "
				+" FROM vehiculo where placa = ? " ;
		
		try {
			c = ConexionBD.getConnection();
		    PreparedStatement ps= c.prepareStatement(sql);
		    ps.setString(1, placa);
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	vehiculo.setPlaca(rs.getString("placa"));
		    	
		    	return vehiculo;
		    }
		    
		    
		}catch(Exception e) {
			
		}
		return null;
		
	}

}
