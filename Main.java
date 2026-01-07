import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SupermercadoController controller = new SupermercadoController();

     
        if (controller.listarFuncionarios().isEmpty()) {
            controller.cadastrarFuncionario(
                new Funcionario("Admin", "12345678900", "admin")
            );
        }

        SwingUtilities.invokeLater(() -> {
            new TelaLogin(controller).setVisible(true);
        });
    }
}
