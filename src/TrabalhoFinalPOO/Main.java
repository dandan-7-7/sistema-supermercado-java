package TrabalhoFinalPOO;


import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Não foi possível aplicar o visual.");
        }

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
