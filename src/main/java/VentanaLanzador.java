import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLanzador extends JFrame{
    static String nombre;
    private JTextField textField1;
    private JButton confirmarButton;
    private JPanel mainPanel;

    public VentanaLanzador(){
        setContentPane(mainPanel);
        setTitle("Bienvenido");
        setSize(900,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = textField1.getText();
                VentanaElejirJuego ventanaElejirJuego = new VentanaElejirJuego();
                ventanaElejirJuego.setDato(nombre);
                ventanaElejirJuego.setVisible(true);
                setVisible(false);

            }
        });
    }

    public static void main(String[] args){
        VentanaLanzador ventanaLanzador = new VentanaLanzador();

    }


}
