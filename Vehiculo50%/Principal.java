import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        mostrarMenu(); 
    }

    public static void mostrarMenu(){
        String menu = "\nIngrese el numero dependiendo de la opcion que desee ejecutar\n"+
                    "0. Salir\n" +
                    "1. Crear vehiculo\n" +
                    "2. Mostrar informacion de todos los vehiculos\n" +
                    "3. Cantidad de vehiculos creados\n" +
                    "4. Mostrar informacion de vehiculos con color verde\n" +
                    "5. Ingrese el ID del vehiculo que desee visualizar\n" +
                    "6. Busque vehiculo por ID y añadale un sensor\n" +
                    "7. Busque vehiculo por ID y visualice sus sensores\n" +
                    "8. Visualice la informacion de los sensores de temperatura\n" +
                    "9. Mostrar el vehiculo con más sensores\n" +
                    "10. Añadir vehiculos de una base de datos\n" +
                    "11. Mostrar el menu nuevamente\n" +
                    "Opcion demoniaca 666. Visualice la informacion de los sensores de temperatura en orden de valor\n";

        Scanner entrada = new Scanner(System.in);
        System.out.println(menu);
        while(true){
            int num = entrada.nextInt();
            if(num == 0){
                break;
            }
            
            switch(num){
                case 1:
                    System.out.println("\nCreando vehiculo...\n__________________________________________\n");
                    System.out.println("Digite la marca del vehiculo: ");
                    String marca = entrada.next();
                    System.out.println("Ingrese el modelo del vehiculo: ");
                    int modelo = entrada.nextInt();
                    System.out.println("Ingrese el valor comercial del vehiculo: ");
                    double valorComercial = entrada.nextDouble();
                    System.out.println("Ingrese el color del vehiculo: ");
                    String color = entrada.next();
                    Vehiculo vehiculo = new Vehiculo(modelo, marca, valorComercial, color);
                    System.out.println("El vehiculo con id: " + vehiculo.getId()+ " ha sido creado\n");
                    break;
                
                case 2:
                    if(Vehiculo.toStringVehiculos().equals("")){
                        System.out.println("\nNo hay vehiculos creados\nDigita la opción 1 para crearlos");
                    }else{
                        System.out.println(Vehiculo.toStringVehiculos());
                    }   
                    break;

                case 3:
                    System.out.println("\nLa Cantidad de vehiculos actualmente son: "+ Vehiculo.cantidadVehiculos());
                    break;
                case 4:
                    if(Vehiculo.toStringVehiculos("verde").equals("")){
                        System.out.println("No hay vehiculos de color verde creados\nDigita la opción 1 para crearlos");
                    }else{
                        System.out.println(Vehiculo.toStringVehiculos("verde"));
                    }
                    break; 
                case 5:
                    System.out.println("\nDigite el id del vehiculo que desea buscar");
                    int id = entrada.nextInt();
                    if(Vehiculo.existeVehiculo(id)){
                        Vehiculo idv = Vehiculo.obtenerVehiculoId(id);
                        System.out.println(Vehiculo.toString(idv));
                    }else{
                        System.out.println("\nEl id no corresponde a ningun vehiculo en la base de datos");
                    }
                    break;
                case 6:
                    System.out.println("\nDigite el id del vehiculo al que desea agregarle un sensor");
                    int id2 = entrada.nextInt();
                    if(Vehiculo.existeVehiculo(id2)){
                        System.out.println("\nCreando sensor...\n__________________________________________\n");
                        System.out.println("Digite el tipo de sensor");
                        String tipo = entrada.next();
                        System.out.println("Digite el valor del sensor");
                        double valor = entrada.nextDouble();
                        Sensor sensor = new Sensor(tipo, valor);
                        Vehiculo idv2 = Vehiculo.obtenerVehiculoId(id2);
                        idv2.anadirSensores(sensor);
                        System.out.println("\nEl vehiculo con id: "+ idv2.getId()+ " se le ha agregado un sensor de tipo: " + sensor.getTipo());

                    }else{
                        System.out.println("\nEl id no corresponde a ningun vehiculo en la base de datos");
                    }
                    break;
                case 7:
                    System.out.println("\nDigite el id del vehiculo al que quiere visualizar los sensores");
                    int id3 = entrada.nextInt();
                    if(Vehiculo.existeVehiculo(id3)){
                        Vehiculo idv3 = Vehiculo.obtenerVehiculoId(id3);
                        System.out.println(Sensor.mostrarSensores(idv3.getSensores()));
                    }else{
                        System.out.println("\nEl id no corresponde a ningun vehiculo en la base de datos");
                    }
                    break;
                case 8:
                    System.out.println("\nLos Sensores de tipo temperatura en todos los vehiculos son: ");
                    System.out.println(Sensor.mostrarSensores(Vehiculo.sensorTemperatura()));
                    break;

                case 9:
                    System.out.println("\nEl vehiculo que tiene mayor cantidad de sensores es: ");
                    System.out.println(Vehiculo.vehiculoConMasSensores());
                    break;
                
                case 10:
                    System.out.println("\nAgregando carros de una base de datos...");
                    Vehiculo.agregarCarroDesdeBase();
                    System.out.println("\nVehiculos agregados. Puede visualizarlo si lista los vehiculos con la opcion 2");
                    break;
                
                case 11:
                    System.out.println(menu);
                    break;

                case 666:
                    System.out.println("\nSensores tipo temperatura ordenado por valor: \n");
                    System.out.println(Sensor.mostrarSensores(Vehiculo.ordenar(Vehiculo.sensorTemperatura())));
                    break;
                default:
                    System.out.println("\nERROR:\nOpción seleccionada invalida...");
            }

            System.out.println("\nDigite nuevamente el numero de la acción que desea ejecutar\n11. Mostrar el menu nuevamente\n" + "0. Salir\n");
        }
        entrada.close();                 
    }
}