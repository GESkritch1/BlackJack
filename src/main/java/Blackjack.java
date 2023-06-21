import java.util.Scanner;

public class Blackjack {
	private static Scanner sc = new Scanner(System.in);
	private static JugadorBlackjack jugador1 = new JugadorBlackjack();
	private static JugadorBlackjack jugador2 = new JugadorBlackjack();

	public static void main() {
		iniciarJuego();
		ganador(verificarSumaCartas(jugador1), verificarSumaCartas(jugador2));

	}

	private static void iniciarJuego() {
		System.out.println("¡Comienza el juego Blackjack!");
		jugador1.iniciarJuegoBlackjack();
		jugador2.iniciarJuegoBlackjack();
		System.out.println("Le toca al jugador 1");
		seguirJuego(jugador1);
		System.out.println("Le toca al jugador 2");
		seguirJuego(jugador2);
	}

	private static void seguirJuego(JugadorBlackjack jugador) {
		int terminar = 1;
		do {
			jugador.mostrarCarta();
			int sacarMasCartas = 0;
			System.out.println("¿Desea sacar más cartas o desea terminar? (1 para sacar más, 0 para terminar)");
			sacarMasCartas = sc.nextInt();
			if (sacarMasCartas == 1) {
				jugador.agregarCarta();
			}
			terminar = sacarMasCartas;
		} while (terminar == 1);
	}

	private static int verificarSumaCartas(JugadorBlackjack jugador) {
		int sumaFinal = 0;
		int primeraPalabra = 0;
		for (String carta : jugador.cartas) {
			if (carta.split(" ")[0].equals("Kaiser") || carta.split(" ")[0].equals("Quina")
					|| carta.split(" ")[0].equals("Jota")) {
				primeraPalabra = 11;
				sumaFinal = sumaFinal + primeraPalabra;
			} else if (carta.split(" ")[0].equals("As")) {
				primeraPalabra = 10;
				sumaFinal = sumaFinal + primeraPalabra;
			} else {
				primeraPalabra = Integer.parseInt(carta.split(" ")[0]);
				sumaFinal = sumaFinal + primeraPalabra;
			}
		}
		return sumaFinal;
	}

	private static void ganador(int valorJugador1, int valorJugador2) {
		VentanaGanadorBlackjack ventanaGanadorBlackjack = new VentanaGanadorBlackjack();
		if (valorJugador1 > 21) {
			System.out.println("El jugador 1 ha perdido con: " + valorJugador1 + " puntos");
			ventanaGanadorBlackjack.setGanador("El jugador 1 ha perdido con: " + valorJugador1 + " puntos");
		}
		if (valorJugador2 > 21) {
			System.out.println("El jugador 2 ha perdido con: " + valorJugador2 + " puntos");
			ventanaGanadorBlackjack.setGanador("El jugador 2 ha perdido con: " + valorJugador2 + " puntos");
		}
		if (valorJugador1 == valorJugador2) {
			System.out.println("Ambos jugadores tuvieron " + valorJugador1 + " puntos y tuvieron un empate");
			ventanaGanadorBlackjack.setGanador("Ambos jugadores tuvieron " + valorJugador1 + " puntos y tuvieron un empate");
		} else if (valorJugador1 == 21) {
			System.out.println("El jugador 1 ha ganado con: " + valorJugador1 + " puntos");
			ventanaGanadorBlackjack.setGanador("El jugador 1 ha ganado con: " + valorJugador1 + " puntos");
		} else if (valorJugador2 == 21) {
			System.out.println("El jugador 2 ha ganado con: " + valorJugador2 + " puntos");
			ventanaGanadorBlackjack.setGanador("El jugador 2 ha ganado con: " + valorJugador2 + " puntos");
		} else if (valorJugador1 > valorJugador2 && valorJugador1 <= 21) {
			System.out.println("Jugador 1 ha ganado con: " + valorJugador1 + " puntos y Jugador 2 quedó con " + valorJugador2 + " puntos");
			ventanaGanadorBlackjack.setGanador("Jugador 1 ha ganado con: " + valorJugador1 + " puntos y Jugador 2 quedó con " + valorJugador2 + " puntos");
		} else if (valorJugador2 > valorJugador1 && valorJugador2 <= 21) {
			System.out.println("Jugador 2 ha ganado con: " + valorJugador2 + " puntos y Jugador 1 quedó con " + valorJugador1 + " puntos");
			ventanaGanadorBlackjack.setGanador("Jugador 2 ha ganado con: " + valorJugador2 + " puntos y Jugador 1 quedó con " + valorJugador1 + " puntos");
		}
		ventanaGanadorBlackjack.setVisible(true);
	}
}