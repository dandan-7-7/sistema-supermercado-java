package TrabalhoFinalPOO;


import java.io.Serializable;

public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    private Produto produto;
    private int quantidade;
    private double total;

    public Venda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = quantidade * produto.getPrecoFinal();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return this.total;
    }

    public String gerarCupom() {
        return "=== CUPOM FISCAL ===\n"
                + "Item: " + produto.getNome() + "\n"
                + "Qtd: " + quantidade + "\n"
                + "Preço Unit: R$ " + String.format("%.2f", produto.getPrecoFinal()) + "\n"
                + "--------------------\n"
                + "TOTAL A PAGAR: R$ " + String.format("%.2f", this.getTotal());
    }
}
