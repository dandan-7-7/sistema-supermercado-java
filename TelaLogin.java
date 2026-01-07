import java.awt.*;
import javax.swing.*;

public class TelaLogin extends JFrame {
    private SupermercadoController controller = new SupermercadoController();
    public TelaLogin(SupermercadoController controller) {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField txtUser = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Entrar");
        JButton btnCadastrar = new JButton("Cadastrar");
        JCheckBox chkMostrarSenha = new JCheckBox("Mostrar Senha");
        JRadioButton rdoFuncionario = new JRadioButton("Sou Funcionário");
        JRadioButton rdoCliente = new JRadioButton("Sou Cliente");

        panel.add(new JLabel("Usuário(CPF):"));
        panel.add(txtUser);
        panel.add(new JLabel("Senha:"));
        panel.add(txtSenha);
       
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdoFuncionario);
        grupo.add(rdoCliente);
        panel.add(rdoFuncionario);
        panel.add(chkMostrarSenha);
        panel.add(rdoCliente);

        
       
        panel.add(new JLabel(""));
        panel.add(btnCadastrar); 
        panel.add(btnLogin);
        

       
        add(panel);
        chkMostrarSenha.addActionListener(e -> {
            if (chkMostrarSenha.isSelected()) {
                txtSenha.setEchoChar((char) 0);
            } else {
                txtSenha.setEchoChar('*');
            }
        });
        

       btnLogin.addActionListener(e -> {

    if (!rdoFuncionario.isSelected() && !rdoCliente.isSelected()) {
        JOptionPane.showMessageDialog(
            this,
            "Selecione se é Cliente ou Funcionário",
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    boolean isFuncionario = rdoFuncionario.isSelected();
    String cpf = txtUser.getText();
    String senha = new String(txtSenha.getPassword());
    
    boolean autenticado = controller.autenticarClienteandFuncionario(isFuncionario, cpf, senha);

    if (autenticado) {
        JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");

        dispose(); 

        if (isFuncionario) {
            new TelaFuncionario(controller).setVisible(true);
        } else {
            new TelaCliente(controller).setVisible(true);
        }

    } else {
        JOptionPane.showMessageDialog(
            this,
            "CPF ou senha inválidos",
            "Erro de login",
            JOptionPane.ERROR_MESSAGE
        );
    }
    }   );

        btnCadastrar.addActionListener(e -> {
            new TelaGerirCliente(controller).setVisible(true);
        });
    }  }  
    
