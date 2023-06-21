import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VentanaGanadorBullseye extends JFrame{
    private String ganador;
    private JLabel ganadoraMostrar;
    private JButton volverAlInicioButton;
    private JPanel mainPanel;

    public VentanaGanadorBullseye() {
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
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }
    public void setGanador(String ganador) {
        this.ganador = ganador;
        ganadoraMostrar.setText(ganador);
    }

}
