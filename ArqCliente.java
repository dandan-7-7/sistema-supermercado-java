import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArqCliente {
    private File arquivo = new File("Clientes.txt");

    public boolean salvar(Cliente c) {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo, true);
            ObjectOutputStream oos;

            if (arquivo.length() == 0)
                oos = new ObjectOutputStream(fos);
            else
                oos = new AppendableObjectOutputStream(fos);

            oos.writeObject(c);
            oos.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }
    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();

        if (!arquivo.exists())
            return lista;

        try {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(arquivo));

            while (true) {
                Cliente c = (Cliente) ois.readObject();
                lista.add(c);
            }
        } catch (EOFException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
