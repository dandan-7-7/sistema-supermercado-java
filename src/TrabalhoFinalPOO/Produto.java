package TrabalhoFinalPOO;


import java.io.Serializable;

public abstract class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private int quantidade;
    private double preco;
    private String dataValidade;
    private String Marca;

    public Produto(String Marca, String nome, int quantidade, double preco, String dataValidade) {
        this.nome = nome;
        this.quantidade = Math.max(0, quantidade);
        this.preco = Math.max(0.0, preco);
        this.dataValidade = dataValidade;
        this.Marca = Marca;
    }

    public abstract double getPrecoFinal();

    public String comprarProduto(int quant) {
        if (quant <= 0) {
            return "Quantidade inválida para compra.";
        }

        if (quant <= quantidade) {
            quantidade -= quant;
            return "Compra realizada com sucesso!";
        } else {
            return "Compra não realizada, pois o estoque só pussui " + quantidade
                    + " unidades do item " + nome;
        }
    }

    public double calcularValorTotalEmEstoque() {
        return quantidade * getPrecoFinal();
    }

    @Override
    public String toString() {
        return "Marca: " + Marca
                + " Nome: " + nome
                + " (R$ " + getPrecoFinal() + ")"
                + " Qtde: " + quantidade
                + " Validade: " + dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getValidade() {
        return dataValidade;
    }

    public String getMarca() {
        return Marca;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
