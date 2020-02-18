package Logica;

import javax.swing.JLabel;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jefe extends Thread
{
    //Variables:
    private int tiempo;
    private JLabel estadoCrono, nroDiasDespacho, nroDias;
    private Contador cont_dia;
    private Semaphore SE_Calendar; 
    private boolean escritura = false;
    
    //Constructor:
    public Jefe(int tiempo, Contador cont_dia, JLabel estadoCrono, JLabel nroDiasDespacho, JLabel nroDias, Semaphore SE_Calendar) 
    {
        this.tiempo = tiempo;
        this.estadoCrono = estadoCrono;
        this.nroDiasDespacho = nroDiasDespacho;
        this.nroDias = nroDias;
        this.cont_dia = cont_dia;
        this.SE_Calendar = SE_Calendar;
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                estadoCrono.setText("Durmiendo");
                sleep((long) (((tiempo*1000)*22.5)/24));
                
                SE_Calendar.acquire();
                estadoCrono.setText("Escribiendo");
                
                if (cont_dia.getCont_dia_despacho()== 0) 
                {
                    cont_dia.setCont_dia_despacho(cont_dia.getDia_original());
                    SE_Calendar.release();
                }
                else
                {   
                    cont_dia.decrementarCont_dia_despacho();
                    nroDiasDespacho.setText(Integer.toString(cont_dia.getCont_dia_despacho()));
                    sleep((long)(((tiempo*1000)*1.5)/24));
                    cont_dia.incrementarCont_dia();
                    nroDias.setText(Integer.toString(cont_dia.getCont_dia()));                    
                    SE_Calendar.release();
                }
                
                
            }
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Jefe.class.getName()).log(Level.SEVERE, null, ex);
            }

               
        }
    }
}
