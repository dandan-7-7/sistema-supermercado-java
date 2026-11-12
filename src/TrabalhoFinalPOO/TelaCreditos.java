package TrabalhoFinalPOO;


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaCreditos extends JFrame {

    public TelaCreditos() {
        setTitle("Créditos do Sistema");
        setSize(320, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        add(panel);

        JLabel lblBemVindo = new JLabel("Créditos do Sistema de Supermercado aos Alunos:");
        JLabel lblDaniel = new JLabel("Daniel Fernandes Ferrreira");
        JLabel lblAndre = new JLabel("André Cayare de Lima Souza");
        JLabel lblIarly = new JLabel("Iarly Batista Mariano Maciel");
        panel.add(lblBemVindo);
        panel.add(lblDaniel);
        panel.add(lblAndre);
        panel.add(lblIarly);
    }
}
