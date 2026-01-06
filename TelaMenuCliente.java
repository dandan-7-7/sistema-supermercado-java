import javax.swing.*;
import java.awt.*;

public class TelaMenuCliente extends JFrame {
    
    public TelaMenuCliente(SupermercadoController controller, Cliente clienteLogado) {
        setTitle("Área do Cliente: " + clienteLogado.getNome());
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JButton btnComprar = new JButton("Fazer Compras");
        JButton btnEditar = new JButton("Editar Meus Dados");
        JButton btnExcluir = new JButton("Excluir Minha Conta");
        JButton btnSair = new JButton("Sair");

        panel.add(btnComprar);
        panel.add(btnEditar);
        panel.add(btnExcluir);
        panel.add(btnSair);

        add(panel);

        // 1. Comprar
        btnComprar.addActionListener(e -> new TelaVenda(controller).setVisible(true));

        // 2. Editar Conta (Usa o método do controller)
        btnEditar.addActionListener(e -> {
            String novoNome = JOptionPane.showInputDialog("Novo Nome:", clienteLogado.getNome());
            String novaSenha = JOptionPane.showInputDialog("Nova Senha:", clienteLogado.getSenha());
            
            if (novoNome != null && novaSenha != null) {
                // Atualiza o objeto
                clienteLogado.setNome(novoNome);
                clienteLogado.setSenha(novaSenha);
                // Salva no arquivo
                controller.editarCliente(clienteLogado.getNome(), novoNome, clienteLogado.getCpf()); // Truque para forçar o save
                JOptionPane.showMessageDialog(this, "Dados atualizados!");
                setTitle("Área do Cliente: " + novoNome);
            }
        });

        // 3. Excluir Conta
        btnExcluir.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza? Isso apagará sua conta.");
            if (confirm == JOptionPane.YES_OPTION) {
                controller.removerCliente(clienteLogado);
                JOptionPane.showMessageDialog(this, "Conta excluída. Adeus!");
                new TelaLogin().setVisible(true);
                dispose();
            }
        });

        // 4. Sair
        btnSair.addActionListener(e -> {
            new TelaLogin().setVisible(true);
            dispose();
        });
    }
}