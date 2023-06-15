import java.util.Scanner;

public class JugadorBullseye {
    static Scanner sc = new Scanner(System.in);
    public int nombreJugador;
    private int identificador;
    private int monto;

    public JugadorBullseye(int Identificador) {
        this.identificador = Identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int elejirCaballo(Caballo caballo1, Caballo caballo2, Caballo caballo3, Caballo caballo4, Caballo caballo5, Caballo caballo6) {
        System.out.println("Elija 1 caballo digitando solo su numero de identificador: ");
        int caballoelejido = Utilitario.leerEntero();
        return caballoelejido;
    }

    private void caballos() {
        System.out.println("");
    }

    public int montoInicial() {
        monto = 50000;
        return monto;
    }

    public int apuesta(int caballoelejido) {
        boolean finalizarApuesta = false;
        int dineroApostado = 0;
        do {
            System.out.println("¿Cuánto desea apostar? Las opciones disponibles son:");
            System.out.println("(1) $500: Si gana, se aplica un multiplicador x2.");
            System.out.println("(2) $1000: Si gana, se aplica un multiplicador x3.");
            System.out.println("(3) $5000: Si gana, se aplica un multiplicador x4.");
            System.out.println("(4) $10000: Si gana, se aplica un multiplicador x5.");
            System.out.println("(5) $25000: Si gana, se aplica un multiplicador x7.");
            System.out.println("(6) $50000: Si gana, se aplica un multiplicador x10.");
            System.out.println("En caso de pérdida, el usuario pierde todo el monto apostado.");

            dineroApostado = Utilitario.leerEntero();
            if (dineroApostado >= 1 && dineroApostado <= 6) {
                finalizarApuesta = true;
            } else {
                System.out.println("Esa no es una opción válida.");
            }
        } while (finalizarApuesta == false);

        return dineroApostado;
    }

    public void premio(int apuesta) {
        switch (apuesta) {
            case 1:
                monto += 500 * 2;
                break;
            case 2:
                monto += 1000 * 3;
                break;
            case 3:
                monto += 5000 * 4;
                break;
            case 4:
                monto += 10000 * 5;
                break;
            case 5:
                monto += 25000 * 7;
                break;
            case 6:
                monto += 50000 * 10;
                break;
            default:
                break;
        }
        System.out.println("¡Felicidades! Has ganado " + (apuesta * monto) + " en premios.");
    }

}