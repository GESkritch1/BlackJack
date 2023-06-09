import java.util.*;

public class JugadorBlackjack {

	public Collection<String> cartas = new ArrayList<>();
	Carta carta = new Carta();

	public void iniciarJuegoBlackjack() {
		for (int i = 0; i < 2; i++) {
			String cartaEntregar = carta.generarCarta();
			cartas.add(cartaEntregar);
		}
    }

	public void agregarCarta() {
		String cartaEntregar = carta.generarCarta();
		cartas.add(cartaEntregar);
	}


	public void mostrarCarta() {
		for (String carta : cartas) {
			System.out.println(carta);
		}
    }
}