package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaHistoricoVendas extends JFrame {

    public TelaHistoricoVendas(SupermercadoController controller) {
        setTitle("Histórico de Vendas");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        add(new JLabel("Faturamento Total: R$" + controller.calcularFaturamentoTotal()), BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Produto", "Quantidade", "Total"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabela = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabela);

        for (Venda v : controller.listarVendas()) {
            model.addRow(new Object[]{
                v.getProduto().getNome(),
                v.getQuantidade(),
                v.getTotal()
            });
        }

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> dispose());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnVoltar);

        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }
}
