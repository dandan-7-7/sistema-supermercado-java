package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaProduto extends JFrame {

    private Produto produtoSelecionado;
    private JTextField txtNome, txtQtd, txtPreco, txtMarca, txtValidade;
    private JCheckBox chkPromocional;
    private JTextField txtDesconto;
    private JTable tabela;
    private DefaultTableModel model;
    private SupermercadoController controller;

    public TelaProduto(SupermercadoController controller) {
        this.controller = controller;

        setTitle("Cadastro de Produtos");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painelCampos = new JPanel(new GridLayout(9, 2));

        painelCampos.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        painelCampos.add(txtMarca);

        painelCampos.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelCampos.add(txtNome);

        painelCampos.add(new JLabel("Quantidade:"));
        txtQtd = new JTextField();
        painelCampos.add(txtQtd);

        painelCampos.add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        painelCampos.add(txtPreco);

        painelCampos.add(new JLabel("Validade:"));
        txtValidade = new JTextField();
        painelCampos.add(txtValidade);

        chkPromocional = new JCheckBox("Produto promocional");
        painelCampos.add(chkPromocional);
        painelCampos.add(new JLabel(""));

        painelCampos.add(new JLabel("Desconto (%)"));
        txtDesconto = new JTextField();
        txtDesconto.setEnabled(false);
        painelCampos.add(txtDesconto);

        JButton btnVoltar = new JButton("Voltar");
        painelCampos.add(btnVoltar);

        JButton btnSalvar = new JButton("Salvar");
        painelCampos.add(btnSalvar);

        JButton btnEditar = new JButton("Editar");
        painelCampos.add(btnEditar);

        JButton btnExcluir = new JButton("Excluir");
        painelCampos.add(btnExcluir);

        add(painelCampos, BorderLayout.NORTH);

        btnVoltar.addActionListener(e -> dispose());

        chkPromocional.addActionListener(e -> {
            txtDesconto.setEnabled(chkPromocional.isSelected());
        });
        model = new DefaultTableModel(
                new Object[]{"Marca", "Nome", "Quantidade", "Preço", "Validade"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela = new JTable(model);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        btnExcluir.addActionListener(e -> {
            int linha = tabela.getSelectedRow();

            if (linha >= 0) {
                int opcao = JOptionPane.showConfirmDialog(
                        this,
                        "Tem certeza que deseja excluir este produto?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION
                );
                if (opcao == JOptionPane.YES_OPTION) {
                    Produto p = controller.listarProdutos().get(linha);
                    controller.removerProduto(p);
                    carregarTabela();

                    JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
                    txtMarca.setText("");
                    txtNome.setText("");
                    txtQtd.setText("");
                    txtPreco.setText("");
                    txtValidade.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
            }
        });

        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tabela.getSelectedRow();
                if (linha >= 0) {
                    produtoSelecionado = controller.listarProdutos().get(linha);

                    txtMarca.setText(produtoSelecionado.getMarca());
                    txtNome.setText(produtoSelecionado.getNome());
                    txtQtd.setText(String.valueOf(produtoSelecionado.getQuantidade()));
                    txtPreco.setText(String.valueOf(produtoSelecionado.getPreco())); // PREÇO BASE
                    txtValidade.setText(produtoSelecionado.getValidade());

                    if (produtoSelecionado instanceof ProdutoPromocional) {
                        chkPromocional.setSelected(true);
                        txtDesconto.setEnabled(true);
                        double desc = ((ProdutoPromocional) produtoSelecionado).getDesconto();
                        txtDesconto.setText(String.valueOf(desc * 100));
                    } else {
                        chkPromocional.setSelected(false);
                        txtDesconto.setEnabled(false);
                        txtDesconto.setText("");
                    }
                }
            }
        });

        carregarTabela();

        btnSalvar.addActionListener(e -> salvarProduto());
        btnEditar.addActionListener(e -> {
            if (produtoSelecionado != null) {

                String marca = txtMarca.getText();
                String nome = txtNome.getText();
                int qtd = Integer.parseInt(txtQtd.getText());
                double precoBase = Double.parseDouble(txtPreco.getText());
                String validade = txtValidade.getText();

                Produto novoProduto;

                if (chkPromocional.isSelected()) {
                    double desconto = Double.parseDouble(txtDesconto.getText()) / 100.0;
                    novoProduto = new ProdutoPromocional(
                            marca, nome, qtd, precoBase, validade, desconto
                    );
                } else {
                    novoProduto = new ProdutoNormal(
                            marca, nome, qtd, precoBase, validade
                    );
                }

                controller.atualizarProduto(produtoSelecionado, novoProduto);

                carregarTabela();
                JOptionPane.showMessageDialog(this, "Produto editado com sucesso!");
                produtoSelecionado = null;

            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para editar!");
            }
        });

    }

    private void salvarProduto() {
        try {
            String marca = txtMarca.getText();
            String nome = txtNome.getText();
            int qtd = Integer.parseInt(txtQtd.getText());
            double preco = Double.parseDouble(txtPreco.getText());
            String validade = txtValidade.getText();

            Produto p;

            if (chkPromocional.isSelected()) {
                double desconto = Double.parseDouble(txtDesconto.getText()) / 100.0;

                p = new ProdutoPromocional(
                        marca, nome, qtd, preco, validade, desconto
                );
            } else {
                p = new ProdutoNormal(
                        marca, nome, qtd, preco, validade
                );
            }

            controller.cadastrarProduto(p);

            model.addRow(new Object[]{
                marca,
                nome,
                qtd,
                p.getPrecoFinal(),
                validade
            });

            txtNome.setText("");
            txtQtd.setText("");
            txtPreco.setText("");
            txtMarca.setText("");
            txtValidade.setText("");
            txtDesconto.setText("");
            chkPromocional.setSelected(false);

            JOptionPane.showMessageDialog(this, "Produto cadastrado!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Dados inválidos!");
        }
    }

    private void carregarTabela() {
        model.setRowCount(0);
        for (Produto p : controller.listarProdutos()) {
            model.addRow(new Object[]{
                p.getMarca(),
                p.getNome(),
                p.getQuantidade(),
                p.getPrecoFinal(),
                p.getValidade()
            });
        }
    }
}
