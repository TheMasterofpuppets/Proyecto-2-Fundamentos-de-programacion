package Bichos50;
import java.util.Random;
public class Bichos {
    private int salud;
    private String tipo;

    public Bichos(int salud, String tipo){
        this.salud = salud;
        this.tipo = tipo;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static void dispararBala(int fila, int columna){
        if(Videojuego.listaBichos[fila][columna] == null){
            System.out.println("No hay ningún bicho en esa posición");
        }else if(Videojuego.listaBichos[fila][columna].getSalud() > 0){
            Videojuego.listaBichos[fila][columna].setSalud(Videojuego.listaBichos[fila][columna].getSalud()-5);
            System.out.println("Se ha disparado");
        }else{
            System.out.println("El bicho seleccionado está muerto");
        }
    }
    
    public static void bombaAtomica(){
        Random generaRandom = new Random();
        while(true){
            int fila = generaRandom.nextInt(0,2);
            int columna = generaRandom.nextInt(0,2);
            if(Videojuego.listaBichos[fila][columna] == null){
                continue;
            }else if(Videojuego.listaBichos[fila][columna].getSalud() > 0){
                Videojuego.listaBichos[fila][columna].setSalud(0);
                break;
            }else{
                continue;
            }
        }
    }

    public static void bichoMutante(){
        int num = 100;
        int x = 0;
        int y = 0;
        for(int fila = 0; fila < 2; fila++){
            for(int colum = 0; colum < 2; colum++){
                if(Videojuego.listaBichos[fila][colum]==null){
                    continue;
                }else if(Videojuego.listaBichos[fila][colum].getSalud() <= 0){
                    continue;
                }else{
                    if(Videojuego.listaBichos[fila][colum].getSalud()<num){
                        num = Videojuego.listaBichos[fila][colum].getSalud();
                        x = fila;
                        y = colum;
                    }
                }
            }
        }
        Videojuego.listaBichos[x][y].setSalud( Videojuego.listaBichos[x][y].getSalud()*2);
    } 

    public static String mensajeAbuela(){
        String mensAbuela = "¡ESA ZANCUDERA DE DÓNDE ESTÁ SALIENDO!";
        return mensAbuela;
    }

    public static boolean bichosVivos(){
        boolean entrega = true;
        int y = 0;
        for(int fila = 0; fila < 2; fila++){
            for(int colum = 0; colum < 2; colum++){
                if(Videojuego.listaBichos[fila][colum]==null){
                    continue;
                }else if(Videojuego.listaBichos[fila][colum].getSalud()<=0){
                    continue;
                }else if(Videojuego.listaBichos[fila][colum].getSalud()>0){
                    y++;
                }
            }
        }
        if(y == 0){
            entrega = false;
        }else{
            entrega = true;
        }
        return entrega;
    }
}
