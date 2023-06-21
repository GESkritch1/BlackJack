import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class VentanaElejirJuego extends JFrame {
    private String dato;
    private JButton blackjackButton;
    private JButton bullseyeButton;
    private JButton volverALaVentanaButton;
    private JPanel mainPanel;
    private JLabel Bienvenido;

    public VentanaElejirJuego() {
        setContentPane(mainPanel);
        setTitle("Eleccion de Juego");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        volverALaVentanaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLanzador ventanaLanzador = new VentanaLanzador();
                ventanaLanzador.setVisible(true);
                setVisible(false);
            }
        });

        blackjackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Blackjack.main();
            }
        });

        bullseyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Bullseye.main();
            }
        });

        int mask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "closeWindow");
        getRootPane().getActionMap().put("closeWindow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void setDato(String dato) {
        this.dato = dato;
        Bienvenido.setText("Bienvenido usuario: " + dato);
    }
}