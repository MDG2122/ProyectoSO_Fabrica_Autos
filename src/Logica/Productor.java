package Logica;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Productor extends Thread
{
    //Variables:
    public Almacen almacen;
    private Semaphore Semaforo_Excluyente, Semaforo_Productor, Semaforo_Ensamblador;
    private int tipo, cont_pieza, apuntador=0; //Tipos: 0->Motor, 1->Parabrisa, 2->Rueda
    private JLabel label;
    private int tiempo_produccion, ie;
    private boolean estado;
    
    //Constructor:
    public Productor(Almacen almacen, Semaphore Semaforo_Excluyente, Semaphore Semaforo_Productor, Semaphore Semaforo_Ensamblador, int tipo, JLabel label, int tiempo_produccion, int ie ,boolean estado) 
    {
        this.almacen = almacen;
        this.Semaforo_Excluyente = Semaforo_Excluyente;
        this.Semaforo_Productor = Semaforo_Productor;
        this.Semaforo_Ensamblador = Semaforo_Ensamblador;
        this.tipo = tipo;
        this.label = label;
        this.tiempo_produccion = tiempo_produccion;
        this.ie = ie;
        this.estado = estado;
    }
    
    //Getter y Setter:

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Semaphore getSemaforo_Excluyente() {
        return Semaforo_Excluyente;
    }

    public void setSemaforo_Excluyente(Semaphore Semaforo_Excluyente) {
        this.Semaforo_Excluyente = Semaforo_Excluyente;
    }

    public Semaphore getSemaforo_Productor() {
        return Semaforo_Productor;
    }

    public void setSemaforo_Productor(Semaphore Semaforo_Productor) {
        this.Semaforo_Productor = Semaforo_Productor;
    }

    public Semaphore getSemaforo_Ensamblador() {
        return Semaforo_Ensamblador;
    }

    public void setSemaforo_Ensamblador(Semaphore Semaforo_Ensamblador) {
        this.Semaforo_Ensamblador = Semaforo_Ensamblador;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCont_pieza() {
        return cont_pieza;
    }

    public void setCont_pieza(int cont_pieza) {
        this.cont_pieza = cont_pieza;
    }

    public int getApuntador() {
        return apuntador;
    }

    public void setApuntador(int apuntador) {
        this.apuntador = apuntador;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public int getTiempo_produccion() {
        return tiempo_produccion;
    }

    public void setTiempo_produccion(int tiempo_produccion) {
        this.tiempo_produccion = tiempo_produccion;
    }
    
    @Override
     public void run ()
     {
        while(true)
        {

            while(!this.estado)
            {
               interrupt();
            }

            if(tipo==0)
            {
                try 
                {
                    //Comprueba espacio en el almacen:
                    Semaforo_Productor.acquire();
                    
                    long start = System.currentTimeMillis();
                    sleep(1000*tiempo_produccion);
                    long stop = System.currentTimeMillis();
                    
                    //Entra en el almacen:                    
                    Semaforo_Excluyente.acquire();
                    producirMotor(start, stop);
                    //Se sale del almacen:                          
                    Semaforo_Excluyente.release();
                    //Listo para consumir                    
                    Semaforo_Ensamblador.release();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
            else if(tipo==1)
            {
                try 
                {
                    //Comprueba espacio en el almacen:
                    Semaforo_Productor.acquire();
                    
                    long start = System.currentTimeMillis();
                    sleep(1000*tiempo_produccion);
                    long stop = System.currentTimeMillis();
                    //Entra en el almacen:                    
                    Semaforo_Excluyente.acquire();
                    producirParabrisa(start, stop);
                    //Se sale del almacen:                          
                    Semaforo_Excluyente.release();
                    //Listo para consumir                    
                    Semaforo_Ensamblador.release();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);

                }                
            }
            else
            {
                try 
                {
                    //Comprueba espacio en el almacen:
                    Semaforo_Productor.acquire();
                    
                    long start = System.currentTimeMillis();
                    sleep(1000*tiempo_produccion);
                    long stop = System.currentTimeMillis();
                    
                    //Entra en el almacen:                    
                    Semaforo_Excluyente.acquire();
                    producirRueda(start, stop);
                    //Se sale del almacen:                          
                    Semaforo_Excluyente.release();
                    //Listo para consumir                    
                    Semaforo_Ensamblador.release();
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);

                }                
            }
            
        }    
    }

    public void producirMotor(long start, long stop)
    {
        System.out.println("+Productor de Motor "+this.ie+": Produce un motor de auto+");
        //Deja lo producido en el almacen:
        almacen.setCant_motor(apuntador, 1);
        //Se coloca en el siguiente espacio del almacén:
        apuntador = (apuntador + 1)%almacen.getTam_motor();
        label.setText(Integer.toString(almacen.Contar_Motor()));   
        System.out.println(" Tiempo de producción : " + (stop - start)+"\n");
    }
     
    public void producirParabrisa(long start, long stop)
    {
        System.out.println("+ Productor de parabrisa "+this.ie+": Produce un parabrisa de autos+");
        almacen.setCant_parabrisa(apuntador, 1);
        label.setText(Integer.toString(almacen.Contar_Parabrisa()));
        apuntador = (apuntador + 1)%almacen.getTam_parabrisa();
        System.out.println(" Tiempo de producción : " + (stop - start)+"\n");  
    }
    
    public void producirRueda(long start, long stop)
    {
        System.out.println("+Productor de Rueda "+this.ie+": Produce una rueda de auto+");
        almacen.setCant_rueda(apuntador, 1);
        label.setText(Integer.toString(almacen.Contar_Rueda()));
        apuntador = (apuntador + 1)%almacen.getTam_rueda();
        System.out.println(" Tiempo de producción : " + (stop - start)+"\n");    
    }
    
    public void estadoChange()
    {
        this.estado=false;
    }
       

}
