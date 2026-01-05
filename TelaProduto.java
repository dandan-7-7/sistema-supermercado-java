import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaProduto extends JFrame {

    private JTextField txtNome, txtQtd, txtPreco;
    private JTable tabela;
    private DefaultTableModel model;
    private SupermercadoController controller;

    public TelaProduto(SupermercadoController controller) {
        this.controller = controller;

        setTitle("Cadastro de Produtos");
        setSize(500, 400);
        setLocationRelativeTo(null);
       
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2));

        painelCampos.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelCampos.add(txtNome);

        painelCampos.add(new JLabel("Quantidade:"));
        txtQtd = new JTextField();
        painelCampos.add(txtQtd);

        painelCampos.add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        painelCampos.add(txtPreco);

        JButton btnSalvar = new JButton("Salvar");
        painelCampos.add(btnSalvar);

        add(painelCampos, BorderLayout.NORTH);

        model = new DefaultTableModel(
                new Object[]{"Nome", "Quantidade", "Preço"}, 0);
        tabela = new JTable(model);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        carregarTabela();

        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {
        try {
            String nome = txtNome.getText();
            int qtd = Integer.parseInt(txtQtd.getText());
            double preco = Double.parseDouble(txtPreco.getText());

            Produto p = new Produto(nome, qtd, preco);
            controller.cadastrarProduto(p);

            model.addRow(new Object[]{nome, qtd, preco});

            txtNome.setText("");
            txtQtd.setText("");
            txtPreco.setText("");

            JOptionPane.showMessageDialog(this, "Produto cadastrado!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
        }
    }

    private void carregarTabela() {
        model.setRowCount(0);
        for (Produto p : controller.listarProdutos()) {
            model.addRow(new Object[]{
                    p.getNome(),
                    p.getQuantidade(),
                    p.getPreco()
            });
        }
    }
}
