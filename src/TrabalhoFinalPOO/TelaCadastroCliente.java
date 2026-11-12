package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaCadastroCliente extends JFrame {

    public TelaCadastroCliente(SupermercadoController controller) {
        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        panel.add(new JLabel("Nome:"));
        panel.add(txtNome);
        panel.add(new JLabel("CPF:"));
        panel.add(txtCpf);
        panel.add(new JLabel("Senha:"));
        panel.add(txtSenha);
        panel.add(btnCancelar);
        panel.add(btnCadastrar);

        add(panel);

        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String senha = new String(txtSenha.getPassword());

            if (!nome.isEmpty() && !cpf.isEmpty() && !senha.isEmpty()) {
                Cliente c = new Cliente(nome, cpf, senha);
                controller.cadastrarCliente(c);
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }
}
