import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {

    public TelaMenu(SupermercadoController controller) {
        setTitle("Menu Principal");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JButton btnProduto = new JButton("Produtos");
        JButton btnCliente = new JButton("Clientes");
        JButton btnVenda = new JButton("Venda");
        JButton btnSair = new JButton("Sair");

        panel.add(btnProduto);
        panel.add(btnCliente);
        panel.add(btnVenda);
        panel.add(btnSair);

        add(panel);

        btnProduto.addActionListener(e -> new TelaProduto(controller).setVisible(true));
        btnCliente.addActionListener(e -> new TelaCliente(controller).setVisible(true));
        btnVenda.addActionListener(e -> new TelaVenda(controller).setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));
    }
}