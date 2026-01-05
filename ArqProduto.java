import java.io.*;
import java.util.ArrayList;

public class ArqProduto {

    private File arquivo = new File("Produtos.txt");

    public boolean salvar(Produto p) {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo, true);
            ObjectOutputStream oos;

            if (arquivo.length() == 0)
                oos = new ObjectOutputStream(fos);
            else
                oos = new AppendableObjectOutputStream(fos);

            oos.writeObject(p);
            oos.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }
    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista = new ArrayList<>();

        if (!arquivo.exists())
            return lista;

        try {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(arquivo));

            while (true) {
                Produto p = (Produto) ois.readObject();
                lista.add(p);
            }
        } catch (EOFException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
