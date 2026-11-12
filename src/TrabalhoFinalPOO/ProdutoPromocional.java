package TrabalhoFinalPOO;


public class ProdutoPromocional extends Produto {

    private double desconto;

    public ProdutoPromocional(String marca, String nome, int quantidade,
            double preco, String dataValidade, double desconto) {
        super(marca, nome, quantidade, preco, dataValidade);
        this.desconto = desconto;
    }

    @Override
    public double getPrecoFinal() {
        return getPreco() - (getPreco() * desconto);
    }

    public double getDesconto() {
        return desconto;
    }

}
