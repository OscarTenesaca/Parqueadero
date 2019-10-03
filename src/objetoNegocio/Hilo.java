package objetoNegocio;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
/**
 * 
 *
 */
public class Hilo extends Thread{
	private JLabel txt;
	private Date hora;
	
	public Hilo(JLabel txt){
		this.txt=txt;
	
		
	}
	/**
	 * metodo para que arranque el hilo
	 */
	public  void run(){
		
		while(true){
			try{
				sleep(1000);
				
			}catch (Exception e){
			}
			
			Calendar tiempo=new GregorianCalendar();
		
			txt.setText(tiempo.get(Calendar.HOUR_OF_DAY)+":"+tiempo.get(Calendar.MINUTE)+":"+tiempo.get(Calendar.SECOND));

		}
	}

}
