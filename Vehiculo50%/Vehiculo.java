import java.util.ArrayList; 
import java.io.BufferedReader;
import java.io.FileReader;
public class Vehiculo {
    // Atributos.

    // Listas de Vehiculos, Guarda todos los vehiculos instansiado.
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    // Lista de sensores de cada instancia de la clase vehiculo.
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    
    // Determina el numero de vehiculos que hay instanciados.
    public static int idActual = 1;

    // Atributos generales de instancia.
    private int id;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;

    // Metodos.

    // Constructores.
    public Vehiculo(){
        this.id = idActual;
        Vehiculo.vehiculos.add(this);
        idActual ++;
    }

    public Vehiculo(int modelo, String marca, double valor){
        this(modelo,marca,valor,"verde");
    }
    
    public Vehiculo(int modelo, String marca, double valorComercial, String color){
        this.id = idActual;
        Vehiculo.vehiculos.add(this);
        idActual ++;
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color= color;
    }

    // Getter y Setters.
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getModelo() {
        return this.modelo;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public double getValorComercial() {
        return this.valorComercial;
    }

    public ArrayList<Sensor> getSensores() {
        return this.sensores;
    }
    
    public void setSensores(ArrayList<Sensor> sensores) {
        this.sensores = sensores;
    }

    // Metodo estatico que retorna cuantos vehiculos hay creados.
    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    // Metodo de instancia que retorna la conatidad de sensores que tiene un vehiculo.
    public int cantidadSensores(){
        return this.sensores.size();
    }
    
    // Metodo de instancia para agrear sensores a un vehiculo. 
    public void anadirSensores(Sensor sensor){
        this.sensores.add(sensor);
    }
    
    // Metodo estatico que Muestra la informacion del vehiculo (Incluyendo los sensores que este tiene).
    public static String toString (Vehiculo vehiculo){
        String entrega = "\n"+
        "El id del vehiculo es: " +  vehiculo.getId() + "\n" +                              
        "El modelo del vehiculo es: " + vehiculo.getModelo() + "\n" + 
        "La marca de su vehiculo es:  "+ vehiculo.getMarca() + "\n" + 
        "El color del vehiculo es: " + vehiculo.getColor() + "\n" +
        "El valor comercial del vehiculo es: " + vehiculo.getValorComercial() + "\n";
        
        if(vehiculo.cantidadSensores()>0){
            entrega += "\nLos Sensores de este Vehiculo son: " + Sensor.mostrarSensores(vehiculo.getSensores());
        }else{
            entrega += "\nEl Vehiculo no cuenta con sensores\n";
        }
        return entrega;            
    }

    // Metodo estatico que muesta la indormación de todos los vehiculos existentes.
    public static String toStringVehiculos(){
        String entrega = "";
        for(Vehiculo vehiculo : Vehiculo.vehiculos){
            entrega += Vehiculo.toString(vehiculo);
        }
        return entrega;
    }

    // Sobregarga del metodo anterior, con la diferencia que se muestran los vehiculos con un color especifico.
    public static String toStringVehiculos(String color){
        String entrega = "";
        for(Vehiculo vehiculo : Vehiculo.vehiculos){
            if(vehiculo.getColor().equals(color)){
                entrega += Vehiculo.toString(vehiculo);
            }
        }
        return entrega;
    }

    /*
     * Metodo estatico que retorna un valor 
     * booleano si encuentra entre los 
     * vehiculos creadosun uno con un id 
     * especifico de verdadero, en caso de 
     * que no falso.
     */
    public static boolean existeVehiculo(int id){
        boolean entrega = false;

        for(Vehiculo vehiculo : Vehiculo.vehiculos){
            if(vehiculo.getId()==id){
                entrega = true;
                break;
            }
        }
        return entrega;
    }

    // Metodo estatico que devuelve un vehiculo que es buscado con un id especifico.
    public static Vehiculo obtenerVehiculoId(int id){
        Vehiculo vehiculo = Vehiculo.vehiculos.get(0);

        for(Vehiculo v : Vehiculo.vehiculos){
            if(v.getId()==id){
                vehiculo = v;
                break;
            }
        }
        return vehiculo;
    }

    /*
     * Metodo estatico que retorna una lista 
     * de Sensores, pero, solo de tipo 
     * temperatura.
     */
    public static ArrayList<Sensor> sensorTemperatura(){ 
        ArrayList<Sensor> entrega = new ArrayList<Sensor>();
        for(Vehiculo vehiculo : Vehiculo.vehiculos){
            for(Sensor sensor : vehiculo.getSensores()){
                if(sensor.getTipo().equals("temperatura")){
                    entrega.add(sensor); 
                }
            }
        }
        return entrega;
    }

    // Metodo estatico que retorna un string con el vehiculo de la lista que tenga mas sensores 
    public static String vehiculoConMasSensores(){
        int valorMaximo;
        int aux = 0;
        Vehiculo auxVehiculo = Vehiculo.vehiculos.get(0);

        for(Vehiculo vehiculo : Vehiculo.vehiculos){
            valorMaximo = vehiculo.cantidadSensores();
            if(valorMaximo>aux){
                aux = valorMaximo;
                auxVehiculo = vehiculo;
            }
        }
        return Vehiculo.toString(auxVehiculo);
    }

    // Metodo estatico de ordenamiento (Quick sort). El cual resive una lista de sensores y las organiza de forma acendente
    public static ArrayList<Sensor> ordenar(ArrayList<Sensor> listaSensores){
        if(listaSensores.size()<=1){
            return listaSensores;
        }
        double pivot = listaSensores.get(listaSensores.size()/2).getValor();
        ArrayList<Sensor> izquierda = new ArrayList<Sensor>();
        ArrayList<Sensor> derecha = new ArrayList<Sensor>();
        int auxpivot =0;
        for(Sensor sensor:listaSensores){
            if(sensor.getValor()<pivot){
                izquierda.add(sensor);
            }else if(sensor.getValor()>pivot){
                derecha.add(sensor);
            }else{
                auxpivot++;
            }
        }

        izquierda = ordenar(izquierda);
        for(int i = 0; i<auxpivot;i++){
            izquierda.add(listaSensores.get(listaSensores.size()/2));
        }
        derecha = ordenar(derecha);
        ArrayList<Sensor> ordenada = new ArrayList<Sensor>();
        ordenada.addAll(izquierda);
        ordenada.addAll(derecha);
        return ordenada;
    }
    
    // leer archivo 
    public static void agregarCarroDesdeBase(){
        String info;
        try{
            BufferedReader lector = new BufferedReader(new FileReader("vehiculos.txt"));
            info = lector.readLine();
            while(info != null){
                String atributos[] = info.split(",");
                new Vehiculo(Integer.parseInt(atributos[1]), atributos[0], Double.parseDouble(atributos[2]), atributos[3]);
                info = lector.readLine();
            }
            lector.close();
        }catch (Exception error){
            System.out.println("Base de datos no encontrada");
        }

    }

}