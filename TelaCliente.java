import java.awt.*;
import javax.swing.*;

public class TelaCliente extends JFrame {
    public TelaCliente(SupermercadoController controller) {
    setTitle("Menu Principal");
    setSize(300, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(4, 1));
    }
}
