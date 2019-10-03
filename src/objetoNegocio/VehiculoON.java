package objetoNegocio;

import accesoDatos.VehiculoDAO;
import entidadNegocio.TicketEN;
import entidadNegocio.VehiculoEN;
import presentacion.FrameVehiculo;

public class VehiculoON {
	
	
	
public boolean validarCampos(String placa , String marca , String modelo, String color) {
		
		
		if((placa.length() >= 6 && placa.length() < 8 ) && marca.length() >=3 && modelo.length() >=3 && color.length()>=3) {
			 
			return true;
			
		}
		
		
		return false;
	}

public boolean reguistrarVehiculo(String placa , String marca , String modelo, String color) {
	
	VehiculoEN vehiculo = new VehiculoEN();
	VehiculoDAO vdao = new VehiculoDAO();
	int id = vdao.GenerarId();
	
	vehiculo.setId(id);
	vehiculo.setPlaca(placa);
	vehiculo.setMarca(marca);
	vehiculo.setModelo(modelo);
	vehiculo.setColor(color);
	
	vdao.insertar(vehiculo);
	
	return true;
	
} 

public boolean comprobarPlaca(String placa) {
	
	VehiculoDAO vdao = new VehiculoDAO();
	try {
	if(vdao.verificarPlaca(placa).getPlaca().equals(placa)) {
		return true;
	}	
	}catch(Exception e){
		e.getMessage();
	}
	
	return false;
	
}

	

}
