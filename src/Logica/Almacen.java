package Logica;

public class Almacen 
{
    //Variables:
    private int[] almacen_motor;
    private int[] almacen_parabrisa;
    private int[] almacen_rueda;
    private int tam_motor, tam_parabrisa, tam_rueda, cant_motor, cant_parabrisa, cant_rueda, cant_autos;
    
    //Constructor:
    public Almacen(int tam_motor, int tam_parabrisa, int tam_rueda) 
    {
        this.tam_motor = tam_motor;
        this.tam_parabrisa = tam_parabrisa;
        this.tam_rueda = tam_rueda;
        almacen_motor= new int[tam_motor];
        almacen_parabrisa= new int[tam_parabrisa];
        almacen_rueda= new int[tam_rueda];
    }
    
    //Getters y Setters:

    public int getValor_Almacen_motor(int i) {
        return almacen_motor[i];
    }

    public int getValor_Almacen_parabrisa(int i) {
        return almacen_parabrisa[i];
    }

    public int getValor_Almacen_rueda(int i) {
        return almacen_rueda[i];
    }

    public int getTam_motor() {
        return tam_motor;
    }

    public void setTam_motor(int tam_motor) {
        this.tam_motor = tam_motor;
    }

    public int getTam_parabrisa() {
        return tam_parabrisa;
    }

    public void setTam_parabrisa(int tam_parabrisa) {
        this.tam_parabrisa = tam_parabrisa;
    }

    public int getTam_rueda() {
        return tam_rueda;
    }

    public void setTam_rueda(int tam_rueda) {
        this.tam_rueda = tam_rueda;
    }

    public int getCant_motor() {
        return cant_motor;
    }


    public int getCant_parabrisa() {
        return cant_parabrisa;
    }


    public int getCant_rueda() {
        return cant_rueda;
    }

    public void setCant_motor(int apuntador_Mot, int val) 
    {
        this.almacen_motor[apuntador_Mot] = val;
    }
    

    public void setCant_parabrisa(int apuntador_Pa, int val) 
    {
        this.almacen_parabrisa[apuntador_Pa] = val;
    }
    
    public void setCant_rueda(int apuntador_Ru, int val) 
    {
        this.almacen_rueda[apuntador_Ru] = val;
    }
    
    public int getCant_autos() 
    {
        return cant_autos;
    }

    public void setCant_autos(int cant_autos) 
    {
        this.cant_autos = cant_autos;
    }    
    
    //Método que cuenta los motores en el almacén
    public int Contar_Motor()
    {
        int motor_aux;
        cant_motor = 0;
        
        for(int i=0; i<tam_motor; i++)
        {
            motor_aux = getValor_Almacen_motor(i);
            if (motor_aux == 1)
            {
               cant_motor++;  
            }
        }
        return cant_motor;
    }
    
    //Método que cuenta los parabrisas en el almacén
    public int Contar_Parabrisa()
    {
        int parabrisa_aux;
        cant_parabrisa = 0;
        
        for(int i=0; i<tam_parabrisa; i++){
            parabrisa_aux = getValor_Almacen_parabrisa(i);
            if (parabrisa_aux == 1)
            {
               cant_parabrisa++; 
            }
        }
        return cant_parabrisa;
    }
    
    ////Método que cuenta las ruedas en el almacén
    public int Contar_Rueda()
    {
        int rueda_aux;
        cant_parabrisa = 0;
        
        for(int i=0; i<tam_rueda; i++){
            rueda_aux = getValor_Almacen_rueda(i);
            if (rueda_aux == 1)
            {
               cant_parabrisa++; 
            }
        }
        return cant_parabrisa;
    }
   
}
