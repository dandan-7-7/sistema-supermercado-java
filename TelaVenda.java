import java.awt.*;
import javax.swing.*;

public class TelaVenda extends JFrame {

    public TelaVenda(SupermercadoController controller) {
        setTitle("Realizar Venda");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox<Produto> cbProduto =
                new JComboBox<>(controller.listarProdutos().toArray(new Produto[0]));
        JTextField txtQtd = new JTextField();
        JButton btnComprar = new JButton("Comprar");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Produto"));
        panel.add(cbProduto);
        panel.add(new JLabel("Quantidade"));
        panel.add(txtQtd);
        panel.add(new JLabel(""));
        panel.add(btnComprar);

        btnComprar.addActionListener(e -> {
            Produto p = (Produto) cbProduto.getSelectedItem();
            try {
                int qtd = Integer.parseInt(txtQtd.getText());
                String mensagem = p.comprarProduto(qtd);
                JOptionPane.showMessageDialog(this, mensagem);

                // ADICIONE ESSA LINHA PARA SALVAR NO ARQUIVO:
                if (mensagem.contains("sucesso")) { // Só salva se a compra deu certo
                    controller.atualizarEstoque();
                    cbProduto.repaint();
                }

            } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Digite um número válido!");
            }
        });

        add(panel);
    }
}