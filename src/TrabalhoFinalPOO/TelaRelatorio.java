package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaRelatorio extends JFrame {

    public TelaRelatorio(SupermercadoController controller) {

        setTitle("Relatório do Sistema");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(0, 1, 5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("RELATÓRIO DO SUPERMERCADO", JLabel.CENTER);

        painel.add(titulo);
        painel.add(new JLabel(" ")); 

        painel.add(new JLabel("Total de Produtos: " + controller.listarProdutos().size()));
        painel.add(new JLabel("Total de Clientes: " + controller.listarClientes().size()));
        painel.add(new JLabel("Total de Funcionários: " + controller.listarFuncionarios().size()));
        painel.add(new JLabel("Total de Vendas: " + controller.listarVendas().size()));

        painel.add(new JLabel(" "));

        painel.add(new JLabel("Faturamento Total: R$ "
                + String.format("%.2f", controller.calcularFaturamentoTotal())));

        painel.add(new JLabel(" "));

        String nomeProduto = "Nenhum";
        int maiorQtd = 0;

        for (Produto p : controller.listarProdutos()) {
            int qtdVendida = 0;

            for (Venda v : controller.listarVendas()) {
                if (v.getProduto().getNome().equals(p.getNome())) {
                    qtdVendida += v.getQuantidade();
                }
            }

            if (qtdVendida > maiorQtd) {
                maiorQtd = qtdVendida;
                nomeProduto = p.getNome();
            }
        }

        painel.add(new JLabel("Produto mais vendido: " + nomeProduto));
        painel.add(new JLabel("Quantidade vendida: " + maiorQtd));

        painel.add(new JLabel(" "));

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose());
        painel.add(btnFechar);

        add(painel);
    }
}
