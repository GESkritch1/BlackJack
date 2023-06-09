public class Caballo {

    Bullseye carrera;
    private String nombreCaballo;
    private int identificadorCaballo;
    private String colorCaballo;

    public Caballo(String nombre, int identificador, String color) {
        this.nombreCaballo = nombre;
        this.identificadorCaballo = identificador;
        this.colorCaballo = color;
    }

    public String getNombreCaballo() {
        return this.nombreCaballo;
    }

    public int getIdentificadorCaballo() {
        return this.identificadorCaballo;
    }

    public String getColorCaballo() {
        return this.colorCaballo;
    }

}