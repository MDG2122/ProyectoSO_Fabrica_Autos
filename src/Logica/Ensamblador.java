package Logica;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class Ensamblador extends Thread
{
    //Variables:
    private Almacen almacen;
    private Semaphore Semaforo_ProducciónMotor, Semaforo_ConsumidorMotor, Semaforo_ExcluyenteMotor, Semaforo_ProducciónParabrisa, Semaforo_ConsumidorParabrisa, Semaforo_ExcluyenteParabrisa, Semaforo_ProducciónRueda, Semaforo_ConsumidorRueda, Semaforo_ExcluyenteRueda, Semaforo_ExcluyenteEnsamblador;
    private int apuntador_Motor = 0, apuntador_Parabrisa = 0, apuntador_Rueda = 0, tiempo_ensamblaje;
    private JLabel Motores, Parabrisas, Ruedas, Autos;    
    
    //Constructor lleno:
    public Ensamblador(Almacen almacen, Semaphore Semaforo_ProducciónMotor, Semaphore Semaforo_ConsumidorMotor, Semaphore Semaforo_ExcluyenteMotor, Semaphore Semaforo_ProducciónParabrisa, Semaphore Semaforo_ConsumidorParabrisa, Semaphore Semaforo_ExcluyenteParabrisa, Semaphore Semaforo_ProducciónRueda, Semaphore Semaforo_ConsumidorRueda, Semaphore Semaforo_ExcluyenteRueda, Semaphore Semaforo_ExcluyenteEnsamblador, int tiempo_ensamblaje, JLabel Motores, JLabel Parabrisas, JLabel Ruedas, JLabel Autos) 
    {
        this.almacen = almacen;
        this.Semaforo_ProducciónMotor = Semaforo_ProducciónMotor;
        this.Semaforo_ConsumidorMotor = Semaforo_ConsumidorMotor;
        this.Semaforo_ExcluyenteMotor = Semaforo_ExcluyenteMotor;
        this.Semaforo_ProducciónParabrisa = Semaforo_ProducciónParabrisa;
        this.Semaforo_ConsumidorParabrisa = Semaforo_ConsumidorParabrisa;
        this.Semaforo_ExcluyenteParabrisa = Semaforo_ExcluyenteParabrisa;
        this.Semaforo_ProducciónRueda = Semaforo_ProducciónRueda;
        this.Semaforo_ConsumidorRueda = Semaforo_ConsumidorRueda;
        this.Semaforo_ExcluyenteRueda = Semaforo_ExcluyenteRueda;
        this.Semaforo_ExcluyenteEnsamblador = Semaforo_ExcluyenteEnsamblador;
        this.tiempo_ensamblaje = tiempo_ensamblaje;
        this.Motores = Motores;
        this.Parabrisas = Parabrisas;
        this.Ruedas = Ruedas;
        this.Autos = Autos;
    }
    
    @Override
    public void run()
    {
        while (true)
        {

            try 
            {
                //Entra un ensamblador:
                Semaforo_ExcluyenteEnsamblador.acquire();
                //Quiero "n" motores de auto:
                Semaforo_ConsumidorMotor.acquire(1);
                //Entra en el almacen:
                Semaforo_ExcluyenteMotor.acquire();
                consumirMotor();
                //Sale del almacen:
                Semaforo_ExcluyenteMotor.release();
                //Ya otro ensamblador puede agarrar motores:
                Semaforo_ProducciónMotor.release(1);
                //Sale el ensamblador:
                Semaforo_ExcluyenteEnsamblador.release();  
  
                Semaforo_ExcluyenteEnsamblador.acquire();
                Semaforo_ConsumidorParabrisa.acquire(1);
                Semaforo_ExcluyenteParabrisa.acquire();
                consumirParabrisa();
                Semaforo_ExcluyenteParabrisa.release();
                Semaforo_ProducciónParabrisa.release(1);
                Semaforo_ExcluyenteEnsamblador.release();
                
                Semaforo_ExcluyenteEnsamblador.acquire();
                Semaforo_ConsumidorRueda.acquire(4);
                Semaforo_ExcluyenteRueda.acquire();
                consumirRuedas();
                Semaforo_ExcluyenteRueda.release();
                Semaforo_ProducciónRueda.release(4);
                Semaforo_ExcluyenteEnsamblador.release();
               
                long start = System.currentTimeMillis();
                sleep(1000*tiempo_ensamblaje*3);
                long stop = System.currentTimeMillis(); 
                ensamblar(start, stop);
                                    
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Ensamblador.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
    
    public void ensamblar(long start, long stop)
    {
        almacen.incrementar_autos();
        Autos.setText(Integer.toString(almacen.getCant_autos()));
        System.out.println("+Ensamblador: Ensambla un auto+");
        System.out.println(" Tiempo de ensamblaje : " + (stop - start)+"\n");
    }
    
    public void consumirMotor()
    {
        if(almacen.getValor_Almacen_motor(apuntador_Motor)==1)
        {
            almacen.setCant_motor(apuntador_Motor, 0);
            Motores.setText(Integer.toString(almacen.Contar_Motor()));
            apuntador_Motor = (apuntador_Motor+1)%almacen.getTam_motor();
            System.out.println("#Ensamblador toma un motor de auto#");
        }
        else
        {
            apuntador_Motor = (apuntador_Motor+1)%almacen.getTam_motor();
        }
    }
    
    public void consumirParabrisa()
    {
        if(almacen.getValor_Almacen_parabrisa(apuntador_Parabrisa)==1)
        {
            almacen.setCant_parabrisa(apuntador_Parabrisa, 0);
            Parabrisas.setText(Integer.toString(almacen.Contar_Parabrisa()));
            apuntador_Parabrisa = (apuntador_Parabrisa+1)%almacen.getTam_parabrisa(); 
            System.out.println("#Ensamblador toma un parabrisa de auto#");
        }
        else
        {
            apuntador_Parabrisa = (apuntador_Parabrisa + 1)%almacen.getTam_parabrisa();
        }
    }
    
    public void consumirRuedas()
    {
        for(int i=0; i<4; i++)
        {
            if(almacen.getValor_Almacen_rueda(apuntador_Rueda)==1)
            {
                almacen.setCant_rueda(apuntador_Rueda, 0);
                Ruedas.setText(Integer.toString(almacen.Contar_Rueda()));
                apuntador_Rueda = (apuntador_Rueda+1)%almacen.getTam_rueda();
                System.out.println("#Ensamblador toma una rueda de auto#");   
            }
            else
            {
                apuntador_Rueda = (apuntador_Rueda+1)%almacen.getTam_rueda();
            }               
        }
        
    }
        

    
    
}
