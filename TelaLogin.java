import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JTextField txtUser = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Entrar");

        panel.add(new JLabel("Usuário:"));
        panel.add(txtUser);
        panel.add(new JLabel("Senha:"));
        panel.add(txtSenha);
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> {
            if (new String(txtSenha.getPassword()).equals("1234")) {
                new TelaMenu(new SupermercadoController()).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Senha inválida");
            }
        });
    }
}