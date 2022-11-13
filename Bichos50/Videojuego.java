package Bichos50;
import java.util.Random;
import java.util.Scanner;

public class Videojuego{
    public static Bichos listaBichos[][] = new Bichos[2][2];

    public static void main(String[] args) {
        
        // Menú
        String menu = "\n____________________________________________\n"+
        "\nBienvenid@ a BICHO-KILLER\n"+
        "\nSeleccione la opción que desea ejecutar: \n"+
        "1. Mostrar tablero\n"+
        "2. Disparar una bala\n"+
        "3. Activar bomba atómica\n"+
        "4. Activar bicho mutante\n"+
        "5. La frase de la abuela\n"+
        "6. Mostrar nuevamente el menú\n"+
        "\n____________________________________________\n";
        
        
        System.out.println(menu);
        Scanner entrada = new Scanner(System.in);
        int opcion = entrada.nextInt();
        crearJugadores();
        while(true){
            
            switch(opcion){
                case 6:
                    System.out.println(menu);
                case 1:
                    System.out.println(tablero());
                    break;
                case 2:
                    System.out.println("Digite la fila de la posición del bicho que desea atacar: ");
                    int fila = entrada.nextInt();
                    System.out.println("Digite la columna de la posición del bicho que desea atacar: ");
                    int columna = entrada.nextInt();
                    Bichos.dispararBala(fila, columna);
                    break;
                case 3:
                    Bichos.bombaAtomica();
                    break;
                case 4:
                    Bichos.bichoMutante();
                    break;
                case 5:
                    System.out.println(Bichos.mensajeAbuela());
                    break;
                default:
                    System.out.println("\nOpcion inválida, digite nuevamente nuevamente una opción\n");
                    break;
            }
            if(Bichos.bichosVivos()==false){
                System.out.println("\n...Juego finalizado...\n"+"\n¡Gracias por jugar BICHO-KILLER!\n");
                break;
            }
            System.out.println("Digite 6 para mostar el menú nuevamente\n");
            opcion = entrada.nextInt();
        }
        entrada.close();
    }

    // Metodo que imprime el trablero del juego
    public static String tablero(){
        String listanombre[][] = new String[2][2];
        for(int fila = 0; fila<2; fila++){
            for(int colum = 0;colum<2;colum++ ){
                if(listaBichos[fila][colum]==null){
                    listanombre[fila][colum] = "     ";
                }else{
                    listanombre[fila][colum] = listaBichos[fila][colum].getTipo()+"-"+listaBichos[fila][colum].getSalud();
                }
            }
        }
        String juego = "-------------\n"+
                        "|" +listanombre[0][0]+"|" + listanombre[0][1]+ "|\n"+
                        "-------------\n"+
                        "|" + listanombre[1][0]+"|" +listanombre[1][1]+ "|";
        return juego;
    }

    public static void crearJugadores(){
        Random generaRandom = new Random();
        int numero = generaRandom.nextInt(1,5);
        Bichos listaAux[] = new Bichos[numero];
        for(int i = 0; i < numero ; i++){
            int numero2 = generaRandom.nextInt(1,3);
            if(numero2 == 1){
                listaAux[i] = new BichoNormal();
            }else if(numero2 == 2){
                listaAux[i] = new BichoAlien();
            }
        }
        int i = 0;
        for(int fila=0;fila<2;fila++){
            for(int columna=0;columna<2;columna++){
                if(i<numero){
                    listaBichos[fila][columna] = listaAux[i];
                    i++;
                }
            }
        }

    }
}
