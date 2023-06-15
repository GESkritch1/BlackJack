import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args){
        ingreseNombre();
        eleccionJuego();
    }
    private static void eleccionJuego(){
        System.out.println("cual juego desea jugar: (1) Blackjack, (2) Bullseye");
        int eleccion = Utilitario.leerEntero();
        if (eleccion==1){
            Blackjack.main();
        }else if (eleccion==2){
            Bullseye.main();
        }else{
            System.out.println("no existe ese juego");
        }
    }
    private static void ingreseNombre(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Bienvenido "+nombre+" al casino ");
    }
}
