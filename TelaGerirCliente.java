import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaGerirCliente extends JFrame {

    public TelaGerirCliente(SupermercadoController controller) {
        setTitle("Clientes");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnSalvar = new JButton("Salvar(Cadastrar)");

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Nome"));
        form.add(txtNome);
        form.add(new JLabel("CPF"));
        form.add(txtCpf);
        form.add(new JLabel("Senha"));
        form.add(txtSenha);
        form.add(new JLabel(""));
        form.add(btnSalvar);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Nome", "CPF"}, 0);
        JTable tabela = new JTable(model);

        for (Cliente c : controller.listarClientes()) {
            model.addRow(new Object[]{c.getNome(), c.getCpf()});
        }

        btnSalvar.addActionListener(e -> {
           String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String senha = new String(txtSenha.getPassword());

            if (!nome.isEmpty() && !cpf.isEmpty() && !senha.isEmpty()) {
                // AGORA SIM: Passamos os 3 argumentos que o Construtor do Cliente pede
                Cliente c = new Cliente(nome, cpf, senha);
                controller.cadastrarCliente(c);
                
                model.addRow(new Object[]{c.getNome(), c.getCpf()}); // Adiciona na tabela visual
                
                // Limpa os campos
                txtNome.setText("");
                txtCpf.setText("");
                txtSenha.setText("");
                JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            }
        });

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }
}