import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaCliente extends JFrame {

    public TelaCliente(SupermercadoController controller) {
        setTitle("Clientes");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        JPanel form = new JPanel(new GridLayout(3, 2));
        form.add(new JLabel("Nome"));
        form.add(txtNome);
        form.add(new JLabel("CPF"));
        form.add(txtCpf);
        form.add(btnSalvar);

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Nome", "CPF"}, 0);
        JTable tabela = new JTable(model);

        for (Cliente c : controller.listarClientes()) {
            model.addRow(new Object[]{c.getNome(), c.getCpf()});
        }

        btnSalvar.addActionListener(e -> {
            Cliente c = new Cliente(txtNome.getText(), txtCpf.getText());
            controller.cadastrarCliente(c);
            model.addRow(new Object[]{c.getNome(), c.getCpf()});
        });

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }
}