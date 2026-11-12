package TrabalhoFinalPOO;


import java.awt.*;
import javax.swing.*;

public class TelaFuncionario extends JFrame {

    public TelaFuncionario(SupermercadoController controller, Funcionario funcionario) {
        setTitle("Menu Principal");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(11, 2));
        JLabel lblBemVindo = new JLabel("Bem vindo ao Menu Principal, " + funcionario.getNome() + "!");
        panel.add(lblBemVindo);
        panel.add(new JLabel("Escolha uma opção:"));

        JButton btnProduto = new JButton("Gerenciar Produtos");
        JButton btnCliente = new JButton("Gerenciar Clientes");
        JButton btnFuncionario = new JButton("Gerenciar Funcionarios");
        JButton btnVenda = new JButton("Compras");
        JButton btnHistorico = new JButton("Historico de Vendas");
        JButton btnSair = new JButton("Sair");
        JButton btnCreditos = new JButton("Créditos");
        JButton btnPerfil = new JButton("Meu Perfil");
        JButton btnRelatorio = new JButton("Gerar Relatório de Vendas");

        panel.add(btnProduto);
        panel.add(btnCliente);
        panel.add(btnFuncionario);
        panel.add(btnVenda);
        panel.add(btnHistorico);
        panel.add(btnRelatorio);
        panel.add(btnPerfil);
        panel.add(btnSair);
        panel.add(btnCreditos);

        add(panel);

        btnProduto.addActionListener(e -> new TelaProduto(controller).setVisible(true));
        btnCliente.addActionListener(e -> new TelaGerirCliente(controller).setVisible(true));
        btnFuncionario.addActionListener(e -> new TelaGerirFuncionario(controller).setVisible(true));
        btnVenda.addActionListener(e -> new TelaVenda(controller).setVisible(true));
        btnHistorico.addActionListener(e -> new TelaHistoricoVendas(controller).setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));
        btnCreditos.addActionListener(e -> new TelaCreditos().setVisible(true));
        btnPerfil.addActionListener(e -> new TelaPerfilFuncionario(controller, funcionario).setVisible(true));
        btnRelatorio.addActionListener(e -> new TelaRelatorio(controller).setVisible(true));
    }
}
