public class Carta {

	private String carton;
	private String pinta;
	private String numero;

	public String generarCarta() {
		carton = numeroAleatorio() +" de " + pintaAleatoria();
		return carton;
	}

	private String pintaAleatoria() {

		int aletatoria = (int) (Math.random() * 4+1);

        switch (aletatoria) {
			case 1:
				pinta = "Corazón";
				break;
			case 2:
				pinta = "Trébol";
				break;
			case 3:
				pinta = "Diamante";
				break;
			case 4:
				pinta = "Pica";
				break;
			default:
				pintaAleatoria();
				break;
		}

		return pinta;
	}

	private String numeroAleatorio() {
		int numeroAleatorio = (int) (Math.random() * 13+1);
			numero = String.valueOf(numeroAleatorio);
			if (numero.equals("11")){
				numero="Jota";
			}if (numero.equals("12")){
				numero="Quina";
            }if (numero.equals("13")){
				numero="Kaiser";
			}if (numero.equals("1")){
                numero="As";
			}
			return numero;
	}


}