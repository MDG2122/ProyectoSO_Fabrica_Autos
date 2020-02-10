/*
 * Proyecto I SO - Trimestre 1718-2
 * Autores: César Salazar y Loredana de Miro
 */
package Logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.util.concurrent.Semaphore;

public class Fabrica 
{   
    //Variables a usar:
    
    //Llamadas a otras clases:
    private Cronometrador cronometrador;
    private Almacen almacen;
    private Contador contador;
    private Gerente gerente;

    
    //ArrayLists de Productor-Ensamblador:
    public ArrayList<Productor> Productor_motor;
    public ArrayList<Productor> Productor_parabrisa;
    public ArrayList<Productor> Productor_rueda;
    public ArrayList<Ensamblador> Ensambladores;
    
    //Atributos JLabel:
    public JLabel nroDiasDespacho, cantidadMotores, cantidadParabrisas, cantidadRuedas, cantidadProdMot, cantidadProdPar, cantidadProdRu, diasTrici, cantidadEnsambladores, cantidadAutos, estadoGerente, estadoCrono, nroDias;
    
    //Semáforos:
    private Semaphore SE_ProductorMotor;
    private Semaphore S_ProductorMotor;
    private Semaphore S_EnsambladorMotor;
    
    private Semaphore SE_ProductorParabrisa;
    private Semaphore S_ProductorParabrisa;
    private Semaphore S_EnsambladorParabrisa;
    
    private Semaphore SE_ProductorRueda;
    private Semaphore S_ProductorRueda;
    private Semaphore S_EnsambladorRueda;
    
    private Semaphore SE_Ensamblador;
    
    private Semaphore SE_Calendario;
    
    //Variables a los que se les pasan sus valores por el archivo de texto (El orden con el que esta escrito aquí es el orden seguido en el swicht y en el .txt):
    private int tiempo_dia;             //Tiempo que dura un día
    private int dia_despacho;           //Cant. de días entre despacho    
    private int cant_motor;            //Almacén de Cabeza
    private int cant_parabrisa;            //Almacén de Cuerpo
    private int cant_rueda;        //Almacén de Extremidad    
    private int ini_prod_motor;         //Cant. inicial Productor de Cabeza
    private int ini_prod_parabrisa;         //Cant. inicial Productor de Cuerpo
    private int ini_prod_rueda;     //Cant. inicial Productor de Extremidad
    private int max_prod_motor;         //Cant. máxima Productor de Cabeza
    private int max_prod_parabrisa;         //Cant. máxima Productor de Cuerpo
    private int max_prod_rueda;     //Cant. máxima Productor de Extremidad
    private int ini_ensambladores;       //Cant. inicial de ensambladores
    private int max_ensambladores;       //Cant. máxima de ensambladores
    
    //Constructor que inicializa la fábrica:
    public Fabrica(JLabel nroDiasDespacho, JLabel cantidadMotores, JLabel cantidadParabrisas, JLabel cantidadRuedas, JLabel cantidadProdMot, JLabel cantidadProdPar, JLabel cantidadProdRu, JLabel cantidadEnsambladores, JLabel cantidadAutos, JLabel estadoGerente, JLabel estadoCrono, JLabel nroDias) throws IOException
    {  
        //Leer el archivo de texto:
        LeerDatos();
                
       //Inicializar los labels con valores:
        this.nroDiasDespacho = nroDiasDespacho;
        nroDiasDespacho.setText(Integer.toString(dia_despacho));
        
        this.cantidadMotores = cantidadMotores;
        cantidadMotores.setText(Integer.toString(0));
        
        this.cantidadParabrisas = cantidadParabrisas;
        cantidadParabrisas.setText(Integer.toString(0));
        
        this.cantidadRuedas = cantidadRuedas;
        cantidadRuedas.setText(Integer.toString(0));
        
        this.cantidadProdMot = cantidadProdMot;
        cantidadProdMot.setText(Integer.toString(ini_prod_motor));
        
        this.cantidadProdPar = cantidadProdPar;
        cantidadProdPar.setText(Integer.toString(ini_prod_parabrisa));
        
        this.cantidadProdRu = cantidadProdRu;
        cantidadProdRu.setText(Integer.toString(ini_prod_rueda));
        
        this.cantidadEnsambladores = cantidadEnsambladores;
        cantidadEnsambladores.setText(Integer.toString(ini_ensambladores));
        
        this.cantidadAutos = cantidadAutos;
        cantidadAutos.setText(Integer.toString(0));
        
        this.estadoGerente = estadoGerente;
        estadoGerente.setText("Inactivo");
        
        this.estadoCrono = estadoCrono;
        estadoCrono.setText("Inactivo");

        this.nroDias = nroDias;
        nroDias.setText(Integer.toString(0));        
        
        //Inicializar Almacen:
        almacen= new Almacen(cant_motor, cant_parabrisa, cant_rueda);
        
        //Inicializar Semaforos:
        SE_ProductorMotor= new Semaphore(1);
        S_ProductorMotor= new Semaphore(almacen.getTam_motor());
        S_EnsambladorMotor= new Semaphore(0);
        
        SE_ProductorParabrisa= new Semaphore(1);
        S_ProductorParabrisa= new Semaphore(almacen.getTam_parabrisa());
        S_EnsambladorParabrisa=new Semaphore(0);

        SE_ProductorRueda= new Semaphore(1);
        S_ProductorRueda= new Semaphore(almacen.getTam_rueda());
        S_EnsambladorRueda= new Semaphore(0);

        SE_Ensamblador= new Semaphore(1);
        SE_Calendario= new Semaphore(1);
        
        //Inicializar ArrayLists:
        Productor_motor= new ArrayList<Productor>(max_prod_motor);
        Productor_parabrisa= new ArrayList<Productor>(max_prod_parabrisa);
        Productor_rueda= new ArrayList<Productor>(max_prod_rueda);
        Ensambladores= new ArrayList<Ensamblador>(max_ensambladores);
        
    }
    
    //Método para contratar productor de motores de autos:
    public void Contratar_Prod_Motor()
    {
        if (ini_prod_motor!=max_prod_motor) 
        {
           Productor Prod_Motor = new Productor(almacen, SE_ProductorMotor, S_ProductorMotor, S_EnsambladorMotor, 0, cantidadMotores, 2);
           Productor_motor.add(Prod_Motor);
           ini_prod_motor++;
           cantidadProdMot.setText(Integer.toString(ini_prod_motor));  
           Prod_Motor.start();  
        } 
    }
    
    //Método para contratar productor de parabrisas:
    public void Contratar_Prod_Parabrisa()
    {
        if (ini_prod_parabrisa!=max_prod_parabrisa) 
        {
           Productor Prod_Parabrisa = new Productor(almacen, SE_ProductorParabrisa, S_ProductorParabrisa, S_EnsambladorParabrisa, 1, cantidadParabrisas, 3);
           Productor_parabrisa.add(Prod_Parabrisa);
           ini_prod_parabrisa++;
           cantidadProdPar.setText(Integer.toString(ini_prod_parabrisa));  
           Prod_Parabrisa.start();  
        } 

    }    
    
    //Método para contratar productor de ruedas:
    public void Contratar_Prod_Rueda()
    {
        if (ini_prod_rueda!=max_prod_rueda) 
        {
           Productor Prod_Rueda = new Productor(almacen, SE_ProductorRueda, S_ProductorRueda, S_EnsambladorRueda, 2, cantidadRuedas, 1);
           Productor_rueda.add(Prod_Rueda);
           ini_prod_rueda++;
           cantidadProdRu.setText(Integer.toString(ini_prod_rueda));  
           Prod_Rueda.start();  
        } 

    }        
    
    //Método para contratar ensambladores de autos:
    public void Contratar_Ensamblador()
    {
        if (ini_ensambladores!=max_ensambladores) 
        {
           Ensamblador Ensam = new Ensamblador(almacen, S_ProductorMotor, S_EnsambladorMotor, SE_ProductorMotor, S_ProductorParabrisa, S_EnsambladorParabrisa, SE_ProductorParabrisa, S_ProductorRueda, S_EnsambladorRueda, SE_ProductorRueda, SE_Ensamblador, 2, cantidadMotores, cantidadParabrisas, cantidadRuedas, cantidadAutos);
           Ensambladores.add(Ensam);
           ini_ensambladores++;
           cantidadEnsambladores.setText(Integer.toString(ini_ensambladores));  
           Ensam.start();  
        } 

    }
    
    //Método para despedir a productor de motores:
    public void Despedir_Prod_Motor()
    {
        if(Productor_motor.size()>1)
        {
            Productor_motor.remove(Productor_motor.size()-1);
            ini_prod_motor--;
            cantidadProdMot.setText(Integer.toString(ini_prod_motor));             
        }
          
    }         
    
    //Método para despedir a productor de parabrisas:
    public void Despedir_Prod_Parabrisa()
    {   
        if(Productor_parabrisa.size()>1)
        {
            Productor_parabrisa.remove(Productor_parabrisa.size()-1);
            ini_prod_parabrisa--;
            cantidadProdPar.setText(Integer.toString(ini_prod_parabrisa));             
        }
    }
    
    //Método para despedir a productor de ruedas:
    public void Despedir_Prod_Rueda()
    {
        if(Productor_rueda.size()>1)
        {
            Productor_rueda.remove(Productor_rueda.size()-1);
            ini_prod_rueda--;
            cantidadProdRu.setText(Integer.toString(ini_prod_rueda));              
        }
    }
    
    //Método para despedir a ensamblador de autos:
    public void Despedir_Ensamblador()
    {
        if(Ensambladores.size()>1)
        {
                Ensambladores.remove(Ensambladores.size()-1);
                ini_ensambladores--;
                cantidadEnsambladores.setText(Integer.toString(ini_ensambladores)); 
        }
    }
     
    //Método para empezar la producción-ensamblaje:
    public void Producir_Ensamblar()
    {
        for (Object prod_cab: Productor_motor) 
        {
          ((Productor)prod_cab).start(); 
        }
       
        for (Object prod_cue: Productor_parabrisa) 
        {
          ((Productor)prod_cue).start();
        }
        
        for (Object prod_ext: Productor_rueda) 
        {
          ((Productor)prod_ext).start();
        }
       
        for (Object ens: Ensambladores) 
        {
          ((Ensamblador)ens).start();
        }
        
        contador = new Contador(dia_despacho);
        cronometrador = new Cronometrador (tiempo_dia, contador, estadoCrono, nroDiasDespacho, nroDias, SE_Calendario);
        gerente = new Gerente (contador, SE_Ensamblador, almacen, estadoGerente, cantidadAutos, tiempo_dia);
        cronometrador.start();
        gerente.start();
    }
   
    //Método que inicializa y actualiza los ArrayLists con los números iniciales dados por el archivo de texto:
    public void Inicializar_ArrayLists()
    {
        //Variables auxiliares para validaciones:
        int aux1=ini_prod_motor;
        int aux2=ini_prod_parabrisa;
        int aux3=ini_prod_rueda;
        int aux4=ini_ensambladores;        
        
      while (aux1!=0)
      { 
        Productor_motor.add(new Productor(almacen, SE_ProductorMotor, S_ProductorMotor, S_EnsambladorMotor, 0, cantidadMotores, 2));
        aux1--;
      }
      
      while (aux2!=0)
      {
        Productor_parabrisa.add(new Productor(almacen, SE_ProductorMotor, S_ProductorMotor, S_EnsambladorMotor, 1, cantidadParabrisas, 3));
        aux2--;
      }
      
      while (aux3!=0)
      {
        Productor_rueda.add(new Productor(almacen, SE_ProductorMotor, S_ProductorMotor, S_EnsambladorMotor, 2, cantidadRuedas, 1));
        aux3--;
      }
       
      while (aux4!=0)
      {
        Ensambladores.add(new Ensamblador(almacen, S_ProductorMotor, S_EnsambladorMotor, SE_ProductorMotor, S_ProductorParabrisa, S_EnsambladorParabrisa, SE_ProductorParabrisa, S_ProductorRueda, S_EnsambladorRueda, SE_ProductorRueda, SE_Ensamblador, 2, cantidadMotores, cantidadParabrisas, cantidadRuedas, cantidadAutos));
        aux4--;
      }
    }
    
    public void Reanudar()
    {
        for (Object p_cab: Productor_motor)
        {
            ((Productor)p_cab).reanudar();
        }
        for (Object p_cue: Productor_parabrisa)
        {
            ((Productor)p_cue).reanudar();
        }
        for (Object p_ext: Productor_rueda)
        {
            ((Productor)p_ext).reanudar();
        }
        for (Object ens: Ensambladores)
        {
            ((Ensamblador)ens).reanudar();
        }            
    }
    
    public void Pausar()
    {
        for (Object p_cab: Productor_motor)
        {
            ((Productor)p_cab).pausar();
        }
        for (Object p_cue: Productor_parabrisa)
        {
            ((Productor)p_cue).pausar();
        }
        for (Object p_ext: Productor_rueda)
        {
            ((Productor)p_ext).pausar();
        }
        for (Object ens: Ensambladores)
        {
            ((Ensamblador)ens).pausar();
        }        
    }
    
    //Método que asigna asigna los valores por archivo de texto:
    public void LeerDatos()throws FileNotFoundException, IOException
    {
        String palabra;
        int num_linea=1;

        BufferedReader br = new BufferedReader(new FileReader("archivo.txt"));
        while(br.ready())
        {
            palabra=br.readLine();
            switch(num_linea)
            {
                case 1:
                    tiempo_dia=Integer.parseInt(palabra);
                    break;  
                case 2:
                    dia_despacho=Integer.parseInt(palabra);
                    break;
                        
                case 3:
                    cant_motor=Integer.parseInt(palabra);
                    break; 
                        
                case 4:
                    cant_parabrisa=Integer.parseInt(palabra);
                    break;
                        
                case 5:
                    cant_rueda=Integer.parseInt(palabra);
                    break;
                        
                case 6:
                    ini_prod_motor=Integer.parseInt(palabra);
                    break;
                        
                case 7:
                    ini_prod_parabrisa=Integer.parseInt(palabra);
                    break;
    
                case 8:
                    ini_prod_rueda=Integer.parseInt(palabra);
                    break;
    
                case 9:
                    max_prod_motor=Integer.parseInt(palabra);
                    break;
    
                case 10:
                    max_prod_parabrisa=Integer.parseInt(palabra);
                    break;
    
                case 11:
                    max_prod_rueda=Integer.parseInt(palabra);
                    break;
    
                case 12:
                    ini_ensambladores=Integer.parseInt(palabra);
                    break;
    
                case 13:
                    max_ensambladores=Integer.parseInt(palabra);
                    break;
            }
            num_linea++;
        }
        br.close();
    }
    
}
