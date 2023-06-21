import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGanadorBlackjack extends JFrame {
    private JButton volverAlInicioButton;
    private JPanel mainPanel;
    private JLabel ganadoraMostrar;
    private String ganador;


    public VentanaGanadorBlackjack() {
            setContentPane(mainPanel);
            setTitle("Bienvenido");
        setSize(900,600);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

        volverAlInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaElejirJuego ventanaElejirJuego = new VentanaElejirJuego();
                ventanaElejirJuego.setVisible(true);
                setVisible(false);
            }
        });
    }
    public void setGanador(String ganador) {
        this.ganador = ganador;
        ganadoraMostrar.setText(ganador);
    }
}
