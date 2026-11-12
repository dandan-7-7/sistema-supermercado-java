package TrabalhoFinalPOO;


import java.io.*;
import java.util.ArrayList;

public class ArqVendas {

    private File arquivo = new File("Vendas.txt");

    public boolean salvar(Venda v) {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo, true);
            ObjectOutputStream oos;

            if (arquivo.length() == 0) {
                oos = new ObjectOutputStream(fos); 
            }else {
                oos = new AppendableObjectOutputStream(fos);
            }

            oos.writeObject(v);
            oos.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public ArrayList<Venda> listar() {
        ArrayList<Venda> lista = new ArrayList<>();

        if (!arquivo.exists()) {
            return lista;
        }

        try {
            ObjectInputStream ois
                    = new ObjectInputStream(new FileInputStream(arquivo));

            while (true) {
                Venda v = (Venda) ois.readObject();
                lista.add(v);
            }

        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void salvarTodaALista(ArrayList<Venda> lista) {
        try {
            FileOutputStream fos = new FileOutputStream(arquivo, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Venda v : lista) {
                oos.writeObject(v);
            }

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
