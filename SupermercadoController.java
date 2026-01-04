import java.util.ArrayList;

public class SupermercadoController {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;

    public SupermercadoController() {
        this.funcionarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }
    public void cadastrarCliente(Cliente produto) {
        clientes.add(produto);
    }
     public void cadastrarFucionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }
    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }
    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }
    public ArrayList<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
    public boolean editarProduto(String nomeAntigo, String novoNome, int novaQuantidade, double novoPreco) {
    for (Produto p : produtos) {
        if (p.getNome().equalsIgnoreCase(nomeAntigo)) {
            p.setNome(novoNome);
            p.setQuantidade(novaQuantidade);
            p.setPreco(novoPreco);
            return true; 
            }
        }
            return false; 
    }
    public boolean editarCliente(String nomeAntigo, String novoNome, String novoCPF) {
    for (Cliente c : clientes) {
        if (c.getNome().equalsIgnoreCase(nomeAntigo)) {
            c.setNome(novoNome);
            c.setCpf(novoCPF);
            
            return true; 
            }
        }
            return false;
           
    }
    public boolean editarFuncionaario(String nomeAntigo, String novoNome, String novoCPF) {
    for (Funcionario f: funcionarios) {
        if (f.getNome().equalsIgnoreCase(nomeAntigo)) {
            f.setNome(novoNome);
            f.setCpf(novoCPF);
            
            return true; 
            }
        }
            return false; 
    }
    
}