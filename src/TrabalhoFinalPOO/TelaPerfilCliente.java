package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaPerfilCliente extends JFrame {

    public TelaPerfilCliente(SupermercadoController controller, Cliente cliente) {
        setTitle("Meu Perfil");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(8, 1));

        JTextField txtNome = new JTextField(cliente.getNome());
        JTextField txtCpf = new JTextField(cliente.getCpf());
        JPasswordField txtSenha = new JPasswordField(cliente.getSenha());

        JButton btnSalvar = new JButton("Salvar");
        JButton btnExcluir = new JButton("Excluir Conta");
        JButton btnVoltar = new JButton("Voltar");

        panel.add(new JLabel("Nome"));
        panel.add(txtNome);
        panel.add(new JLabel("CPF"));
        panel.add(txtCpf);
        panel.add(new JLabel("Senha"));
        panel.add(txtSenha);
        panel.add(btnSalvar);
        panel.add(btnExcluir);
        panel.add(btnVoltar);

        add(panel);

        btnSalvar.addActionListener(e -> {
            boolean ok = controller.editarCliente(
                    cliente.getNome(),
                    txtNome.getText(),
                    txtCpf.getText(),
                    new String(txtSenha.getPassword())
            );

            if (ok) {
                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!");
            }
        });

        btnExcluir.addActionListener(e -> {
            int op = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja excluir sua conta?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (op == JOptionPane.YES_OPTION) {
                controller.removerCliente(cliente);
                JOptionPane.showMessageDialog(this, "Conta excluída!");
                System.exit(0);

            }
        });

        btnVoltar.addActionListener(e -> dispose());
    }
}
