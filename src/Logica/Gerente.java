package Logica;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Gerente extends Thread
{
    //Variables:
    private Contador cont_dia;
    private Semaphore SE_Autos;
    private Random random = new Random();
    private Almacen almacen;
    private boolean revision;
    private JLabel estadoGerente, cantAutos;
    private int tiempo_Duerme, tiempo_Dia;
    
    //Constructor:
    public Gerente(Contador cont_dia, Semaphore SE_Autos, Almacen almacen, JLabel estadoGerente, JLabel cantAutos, int tiempo_Dia) 
    {
        this.cont_dia = cont_dia;
        this.SE_Autos = SE_Autos;
        this.almacen = almacen;
        this.estadoGerente = estadoGerente;
        this.cantAutos = cantAutos;
        this.tiempo_Dia = tiempo_Dia;
    }
    
    //Getter y Setter:
    public Almacen getAlmacen() 
    {
        return almacen;
    }
    
    public void setAlmacen(Almacen almacen) 
    {
        this.almacen = almacen;
    }

    public boolean isRevision() 
    {
        return revision;
    }

    public void setRevision(boolean revision) 
    {
        this.revision = revision;
    }

    public int getTiempo_Dia() 
    {
        return tiempo_Dia;
    }

    public void setTiempo_Dia(int tiempo_Dia) 
    {
        this.tiempo_Dia = tiempo_Dia;
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            
            try 
            {
                //Define las 6-18 horas de sueño del gerente:
                tiempo_Duerme=(this.random.nextInt(12)+6);

                sleep(((tiempo_Dia*1000)*tiempo_Duerme)/24);
                estadoGerente.setText("Dormido");

                //Si se alcanza el día de despacho, Gerente despacha los autos, sino verifica:
                if(cont_dia.getCont_dia_despacho()==0)
                {
                    int aux;
                    SE_Autos.acquire();
                    aux=almacen.getCant_autos();
                    almacen.setCant_autos(0);
                    System.out.println("\n ¡Día del despacho! Se han producido "+aux+" autos.\n");
                    cantAutos.setText(Integer.toString(almacen.getCant_autos()));
                    sleep (tiempo_Dia*1000);
                    estadoGerente.setText("Despachando"); 
                }                          
                else
                {
                    sleep(((tiempo_Dia*1000)*tiempo_Duerme)/24);
                    estadoGerente.setText("Verificando");
                }
                
                SE_Autos.release(); 
                
            }
            catch (InterruptedException ex) 
            {
               Logger.getLogger(Gerente.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }        
    

}
