package Vehiculo50;
import java.util.ArrayList;
public class Sensor {
    private String tipo;
    private double valor;

    public String getTipo(){
        return tipo;
    }

    public double getValor(){
        return valor;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public Sensor(String tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;
    }

    public String toString (){
        String entrega = "\n"+
                           "El tipo de sensor es: " + this.tipo + "\n" + 
                           "El valor del sensor es " + this.valor + "\n";
        return entrega;
    }   

     // Muestra los sensores que posee un vehiculo
    public static String mostrarSensores(ArrayList<Sensor> s){
        String entrega = "";
        for(Sensor sensor : s){
            entrega += sensor.toString() + "\n";
        }
        return entrega;
    }

}