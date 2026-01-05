import java.io.Serializable;

public class Produto implements Serializable {
	private String nome;
	private int quantidade;
	private double preco;
	
	public Produto(String nome,int quantidade, double preco){
		this.nome = nome;
		if(quantidade < 0){
			this.quantidade = 0;
		} else this.quantidade = quantidade;
		if(preco < 0){
			this.preco = 0.0;
		} else
		this.preco = preco;
		
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
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

	//dandan
    public String comprarProduto(int quant){
		if(quant <= 0) return "Quantidade inválida para compra.";
		
		if(quant <= quantidade){
			quantidade -= quant;
			return "Compra realizada com sucesso!";
		} else return "Compra não realizada, pois o estoque só pussui " + quantidade + " unidades do item " + nome;
		

	}
	public String adicionarEstoque(int quant){
		if(quant < 0) return "Quantidade inválida para adicionar ao estoque.";
		
		quantidade += quant;
		return "Quantidade de " + quant + " adicionada com sucesso. Quantidade atual: " + getQuantidade() + " unidades.";
	}
	public String diminuirEstoque(int quant){
		if(quant < 0) return "Quantidade inválida para diminuir do estoque.";
		
		if(quant <= quantidade){
			quantidade -= quant;
			return "Quantidade de " + quant + " do item " + nome + " diminuida com sucesso. Quantidade atual: " + quantidade+ " unidades.";
		} else return "Não é possível diminuir o estoque em " + quant + " unidades, pois só existem " + quantidade + " unidades no estoque.";
		
	}
	public double calcularValorTotalEmEstoque(){
		return quantidade * preco;
	}
}
