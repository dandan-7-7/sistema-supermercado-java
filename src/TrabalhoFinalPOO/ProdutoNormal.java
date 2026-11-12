package TrabalhoFinalPOO;


public class ProdutoNormal extends Produto {

    public ProdutoNormal(String marca, String nome, int quantidade,
            double preco, String dataValidade) {
        super(marca, nome, quantidade, preco, dataValidade);
    }

    @Override
    public double getPrecoFinal() {
        return getPreco();
    }
}
