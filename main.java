public class main {
    public static void main(String[] args) {
        System.out.println("Sistema de Supermercado Iniciado");
        
    
        SupermercadoController controller = new SupermercadoController();

        Produto p1 = new Produto("Arroz", 10, 25.0);
        Produto p2 = new Produto("Feijão", 5, 8.5);

        controller.cadastrarProduto(p1);
        controller.cadastrarProduto(p2);
        
        
        for (Produto p : controller.listarProdutos()) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Preço: " + p.getPreco());
        }
        
        System.out.println(controller.listarProdutos());
    }
    //joga na IA o codigo de controller pra ver se ja ta completo, ou falta mais alguma coisa?
    // correto mais temos que fazer o editar funcionario e cliente 
    //show
    // vou fazer 
    // vou jogar na ia
    // ta com erro nas chaves
} 
