import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		iniciarJuego();
	}
	static Scanner sc = new Scanner(System.in);
	static Jugador jugador1 = new Jugador();
	static Jugador jugador2 = new Jugador();
	private static void iniciarJuego() {
	jugador1.iniciarJuego();
	jugador2.iniciarJuego();
		System.out.println("le toca al jugador 1");
	seguirJuego(jugador1);
		System.out.println("le toca al jugador 2");
	seguirJuego(jugador2);
	int valorjugador1=verificarSumaCartas(jugador1);
	int valorJugador2=verificarSumaCartas(jugador2);
	ganador(valorjugador1, valorJugador2);
	}

	private static void seguirJuego(Jugador jugador) {
		int terminar = 1;
		do{
			jugador.mostrarCarta();
			int sacarMasCartas = 0;
			System.out.println("desea sacar mas cartas o desea terminar? (1 para sacar mas, 0 para terminar)");
			sacarMasCartas = sc.nextInt();
			if (sacarMasCartas == 1) {
				jugador.agregarCarta();
			}
			terminar = sacarMasCartas;
		}while (terminar == 1);
	}

	private static int verificarSumaCartas(Jugador jugador1) {
		int sumaFinal = 0;
		int primeraPalabra = 0;
			for (String carta : jugador1.cartas) {
				if (carta.split(" ")[0].equals("Kaiser")||carta.split(" ")[0].equals("Quina")||carta.split(" ")[0].equals("Jota")) {
					primeraPalabra = 11;
					sumaFinal = sumaFinal+ primeraPalabra;
				}else if (carta.split(" ")[0].equals("As")){
					primeraPalabra = 10;
					sumaFinal = sumaFinal+ primeraPalabra;
				}else {
					primeraPalabra = Integer.parseInt(carta.split(" ")[0]);
					sumaFinal = sumaFinal+ primeraPalabra;
				}
				}
			return sumaFinal;
	}

	// el metodo de abajo es mucho texto porque son solo los imprime en pantalla
	private static void ganador(int jugador1, int jugador2) {
		if (jugador1 >21) {
			System.out.println("el jugador 1 ha perdido con: " + jugador1 + " puntos");
		}
		if (jugador2 >21) {
			System.out.println("el jugador 2 ha perdido con: "+ jugador2 + " puntos");
		}
		if (jugador1 == jugador2 ) {
			System.out.println("ambos jugadores tuvieron "+jugador1+" puntos y tuvieron un empate");
		}else if (jugador1 == 21) {
			System.out.println("el jugador 1 ha ganado con: "+ jugador1 + " puntos");
		}else if (jugador2 == 21) {
			System.out.println("el jugador 2 ha ganado con: " + jugador2 + " puntos");
		}else if (jugador1 > jugador2&&jugador1 <=21) {
			System.out.println("jugador 1 ha ganado con: "+ jugador1 + " puntos y jugador 2 quedo con " +jugador2 + " puntos");
		}else if (jugador2 > jugador1&&jugador2 <=21) {
			System.out.println("jugador 2 ha ganado con: "+ jugador2 + " puntos y jugador 1 quedo con " +jugador1 + " puntos");
		}
	}


}