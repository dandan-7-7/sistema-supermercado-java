package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaVenda extends JFrame {

    public TelaVenda(SupermercadoController controller) {
        setTitle("Realizar Compra");
        setSize(1000, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComboBox<Produto> cbProduto
                = new JComboBox<>(controller.listarProdutos().toArray(new Produto[0]));
        JTextField txtQtd = new JTextField();

        JButton btnComprar = new JButton("Comprar");
        JButton btnVoltar = new JButton("Voltar");

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Produto"));
        panel.add(cbProduto);
        panel.add(new JLabel("Quantidade"));
        panel.add(txtQtd);
        panel.add(btnVoltar);
        panel.add(btnComprar);

        btnVoltar.addActionListener(e -> dispose());

        btnComprar.addActionListener(e -> {
            Produto p = (Produto) cbProduto.getSelectedItem();

            if (p == null) {
                JOptionPane.showMessageDialog(this, "Nenhum produto selecionado!");
                return;
            }

            try {
                int qtd = Integer.parseInt(txtQtd.getText());

                String mensagem = p.comprarProduto(qtd);

                if (mensagem.contains("sucesso")) {

                    Venda v = new Venda(p, qtd);

                    controller.registrarVenda(v);
                    controller.atualizarEstoque();

                    cbProduto.repaint();

                    String textoCupom = v.gerarCupom();
                    JOptionPane.showMessageDialog(this, textoCupom, "Sucesso - Cupom Fiscal", JOptionPane.INFORMATION_MESSAGE);

                    txtQtd.setText("");

                } else {

                    JOptionPane.showMessageDialog(this, mensagem, "Erro na Venda", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um número válido!");
            }
        });

        add(panel);
    }
}
