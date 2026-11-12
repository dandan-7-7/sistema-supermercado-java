package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaGerirFuncionario extends JFrame {

    public TelaGerirFuncionario(SupermercadoController controller) {
        setTitle("Gerir Funcionários");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnSalvar = new JButton("Salvar(Cadastrar)");
        JButton btnVoltar = new JButton("Voltar");
        JPanel form = new JPanel(new GridLayout(6, 2));
        JLabel lblTotalFuncionarios = new JLabel(
                "Total de Funcionários: " + Funcionario.getTotalFuncionarios()
        );

        form.add(new JLabel("Nome"));
        form.add(txtNome);
        form.add(new JLabel("CPF"));
        form.add(txtCpf);
        form.add(new JLabel("Senha"));
        form.add(txtSenha);
        form.add(btnVoltar);
        form.add(btnSalvar);
        form.add(lblTotalFuncionarios);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Nome", "CPF"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);

        for (Funcionario f : controller.listarFuncionarios()) {
            model.addRow(new Object[]{f.getNome(), f.getCpf()});
        }

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String senha = new String(txtSenha.getPassword());

            if (!nome.isEmpty() && !cpf.isEmpty() && !senha.isEmpty()) {
                Funcionario f = new Funcionario(nome, cpf, senha);
                controller.cadastrarFuncionario(f);

                model.addRow(new Object[]{f.getNome(), f.getCpf()});

                txtNome.setText("");
                txtCpf.setText("");
                txtSenha.setText("");
                JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
                lblTotalFuncionarios.setText(
                        "Total de funcionários: " + Funcionario.getTotalFuncionarios());

            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            }
        });

        btnVoltar.addActionListener(e -> dispose());
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }
}
