import java.swing.*;

import javax.swing.JFrame;

import java.awt.*;

public class TelaCadastro extends JFrame {
    setTitle("Cadastro de Cliente");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnSalvar = new JButton("Confirmar Cadastro");

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Nome:"));      form.add(txtNome);
        form.add(new JLabel("CPF:"));       form.add(txtCpf);
        form.add(new JLabel("Senha:"));     form.add(txtSenha);
        form.add(new JLabel(""));           form.add(btnSalvar);

        add(form);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String senha = new String(txtSenha.getPassword());

            if(!nome.isEmpty() && !cpf.isEmpty() && !senha.isEmpty()) {
                Cliente novo = new Cliente(nome, cpf, senha);
                controller.cadastrarCliente(novo);
                JOptionPane.showMessageDialog(this, "Cadastro realizado! Faça Login.");
                dispose(); // Fecha a janela de cadastro
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            }
        });
    }

    
}
