package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaRecuperarSenha extends JFrame {

    public TelaRecuperarSenha(SupermercadoController controller) {
        setTitle("Recuperar Senha");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel lblTipo = new JLabel("Tipo de usuário:");
        JComboBox<String> cbTipo = new JComboBox<>(
                new String[]{"Funcionario", "Cliente"}
        );

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel lblCpf = new JLabel("CPF:");
        JTextField txtCpf = new JTextField();

        JLabel lblNovaSenha = new JLabel("Nova Senha:");
        JPasswordField txtNovaSenha = new JPasswordField();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        add(lblTipo);
        add(cbTipo);
        add(lblNome);
        add(txtNome);
        add(lblCpf);
        add(txtCpf);
        add(lblNovaSenha);
        add(txtNovaSenha);
        add(btnVoltar);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String tipo = (String) cbTipo.getSelectedItem();
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String novaSenha = new String(txtNovaSenha.getPassword());

            boolean ok = controller.recuperarSenha(
                    tipo, nome, cpf, novaSenha
            );

            if (ok) {
                JOptionPane.showMessageDialog(this,
                        "Senha alterada com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Dados não conferem!");
            }
        });

        btnVoltar.addActionListener(e -> dispose());
    }
}
