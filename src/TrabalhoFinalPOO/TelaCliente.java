package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaCliente extends JFrame {

    public TelaCliente(SupermercadoController controller, Cliente cliente) {
        setTitle("Menu Principal");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel lblBemVindo = new JLabel("Bem vindo ao Menu Principal, " + cliente.getNome() + "!");
        panel.add(lblBemVindo);
        panel.add(new JLabel("Escolha uma opção:"));

        JButton btnVenda = new JButton("Compras");
        JButton btnPerfil = new JButton("Meu Perfil");
        JButton btnSair = new JButton("Sair");

        panel.add(btnVenda);
        panel.add(btnPerfil);
        panel.add(btnSair);

        add(panel);

        btnVenda.addActionListener(e -> new TelaVenda(controller).setVisible(true));
        btnPerfil.addActionListener(e -> new TelaPerfilCliente(controller, cliente).setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));

    }
}
