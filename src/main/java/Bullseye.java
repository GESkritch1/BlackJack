import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bullseye {

    public static void main() {
        iniciarJuego();
    }

    private static void iniciarJuego() {
        List<Integer> listaCaballos = new ArrayList<>();
        List<Integer> listaJugadoresSC = new ArrayList<>();
        Caballo caballo1 = new Caballo("Pedro", 1, "rojo");
        Caballo caballo2 = new Caballo("Juan", 2, "azul");
        Caballo caballo3 = new Caballo("Diego", 3, "amarillo");
        Caballo caballo4 = new Caballo("Bingo", 4, "verde");
        Caballo caballo5 = new Caballo("Proto", 5, "rosado");
        Caballo caballo6 = new Caballo("Zerg", 6, "morado");

        JugadorBullseye jugador1 = new JugadorBullseye(1);
        JugadorBullseye jugador2 = new JugadorBullseye(2);
        JugadorBullseye jugador3 = new JugadorBullseye(3);
        JugadorBullseye jugador4 = new JugadorBullseye(4);
        JugadorBullseye jugador5 = new JugadorBullseye(5);
        JugadorBullseye jugador6 = new JugadorBullseye(6);

        listaCaballos.add(caballo1.getIdentificadorCaballo());
        listaCaballos.add(caballo2.getIdentificadorCaballo());
        listaCaballos.add(caballo3.getIdentificadorCaballo());
        listaCaballos.add(caballo4.getIdentificadorCaballo());
        listaCaballos.add(caballo5.getIdentificadorCaballo());
        listaCaballos.add(caballo6.getIdentificadorCaballo());

        listaJugadoresSC.add(jugador2.getIdentificador());
        listaJugadoresSC.add(jugador3.getIdentificador());
        listaJugadoresSC.add(jugador4.getIdentificador());
        listaJugadoresSC.add(jugador5.getIdentificador());
        listaJugadoresSC.add(jugador6.getIdentificador());

        jugador1.montoInicial();
        int caballoElegido = 0;
        do {
            caballosQueHay(caballo1, caballo2, caballo3, caballo4, caballo5, caballo6);
            caballoElegido = jugador1.elejirCaballo(caballo1, caballo2, caballo3, caballo4, caballo5, caballo6);
        } while (caballoElegido > 6 || caballoElegido < 1);
        int apuestaAlCaballoElegido = jugador1.apuesta(caballoElegido);

        randomizarLosOtrosJugadores(listaCaballos, listaJugadoresSC, caballoElegido);

        System.out.println("¡Comienza la carrera!");

        Random random = new Random();
        int[] tiempos = new int[6];

        for (int i = 0; i < tiempos.length; i++) {
            tiempos[i] = random.nextInt(10) + 1; // Generar tiempos aleatorios entre 1 y 10
        }

        int ganador = obtenerGanador(tiempos);

        System.out.println("El caballo ganador es: " + ganador);

        // Otorgar premios a los jugadores que apostaron por el caballo ganador
        if (caballoElegido == ganador) {
            System.out.println("¡Felicidades! Has ganado la apuesta.");
            jugador1.premio(apuestaAlCaballoElegido);
        } else {
            System.out.println("Lo siento, no has ganado la apuesta.");
        }
    }

    private static int obtenerGanador(int[] tiempos) {
        int ganador = 1;
        int menorTiempo = tiempos[0];

        for (int i = 1; i < tiempos.length; i++) {
            if (tiempos[i] < menorTiempo) {
                ganador = i + 1;
                menorTiempo = tiempos[i];
            }
        }

        return ganador;
    }

    private static void randomizarLosOtrosJugadores(List<Integer> listaCaballos, List<Integer> listaJugadoresSC, int caballoElegido) {
        List<Integer> jugadoresRestantes = new ArrayList<>(listaJugadoresSC);
        jugadoresRestantes.remove(Integer.valueOf(1)); // Remover al jugador que ya eligió caballo

        Random random = new Random();

        for (int i = 0; i < jugadoresRestantes.size(); i++) {
            int jugadorId = jugadoresRestantes.get(i);
            int caballoIndex = random.nextInt(listaCaballos.size());
            int caballoId = listaCaballos.get(caballoIndex);
            listaCaballos.remove(caballoIndex);

            System.out.println("El jugador " + jugadorId + " tiene asignado el caballo " + caballoId);
        }

        System.out.println("El jugador 1 tiene asignado el caballo " + caballoElegido);
    }

    private static void caballosQueHay(Caballo caballo1, Caballo caballo2, Caballo caballo3, Caballo caballo4, Caballo caballo5, Caballo caballo6) {
        System.out.println("Los caballos disponibles son:");
        System.out.println("(1) " + caballo1.getNombreCaballo() + " " + caballo1.getColorCaballo() + ". Identificador: " + caballo1.getIdentificadorCaballo());
        System.out.println("(2) " + caballo2.getNombreCaballo() + " " + caballo2.getColorCaballo() + ". Identificador: " + caballo2.getIdentificadorCaballo());
        System.out.println("(3) " + caballo3.getNombreCaballo() + " " + caballo3.getColorCaballo() + ". Identificador: " + caballo3.getIdentificadorCaballo());
        System.out.println("(4) " + caballo4.getNombreCaballo() + " " + caballo4.getColorCaballo() + ". Identificador: " + caballo4.getIdentificadorCaballo());
        System.out.println("(5) " + caballo5.getNombreCaballo() + " " + caballo5.getColorCaballo() + ". Identificador: " + caballo5.getIdentificadorCaballo());
        System.out.println("(6) " + caballo6.getNombreCaballo() + " " + caballo6.getColorCaballo() + ". Identificador: " + caballo6.getIdentificadorCaballo());
        System.out.println();
    }
}