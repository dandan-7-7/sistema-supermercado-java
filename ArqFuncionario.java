import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArqFuncionario {
    private File arquivo = new File("Funcionarios.txt");

    public boolean salvar(Funcionario f) {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo, true);
            ObjectOutputStream oos;

            if (arquivo.length() == 0)
                oos = new ObjectOutputStream(fos);
            else
                oos = new AppendableObjectOutputStream(fos);

            oos.writeObject(f);
            oos.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }
    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> lista = new ArrayList<>();

        if (!arquivo.exists())
            return lista;

        try {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(arquivo));

            while (true) {
                Funcionario f = (Funcionario) ois.readObject();
                lista.add(f);
            }
        } catch (EOFException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
