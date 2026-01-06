import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

       
        SupermercadoController supermercadoController = new SupermercadoController();
         supermercadoController.cadastrarCliente(new Cliente("Maria", "1213231", "1234"));
        System.out.println(supermercadoController.listarFuncionarios());

        /*
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
        /* */
    }
}
