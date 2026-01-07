import java.util.ArrayList;

public class SupermercadoController implements Autenticavel {
    ArqProduto arqProduto = new ArqProduto();
    ArqCliente arqCliente = new ArqCliente();
    ArqFuncionario arqFuncionario = new ArqFuncionario();

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;

    public SupermercadoController() {
        this.funcionarios = arqFuncionario.listar();
        this.produtos = arqProduto.listar();
        this.clientes = arqCliente.listar();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        arqProduto.salvar(produto);
    }
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        arqCliente.salvar(cliente);
    }
     public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        arqFuncionario.salvar(funcionario);
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
        arqProduto.salvarTodaALista(produtos);
    }
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
        arqCliente.salvarTodaALista(clientes);
    }
    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
        arqFuncionario.salvarTodaALista(funcionarios);
    }
    public boolean editarProduto(String nomeAntigo, String novoNome, int novaQuantidade, double novoPreco) {
    for (Produto p : produtos) {
        if (p.getNome().equalsIgnoreCase(nomeAntigo)) {
            p.setNome(novoNome);
            p.setQuantidade(novaQuantidade);
            p.setPreco(novoPreco);
            arqProduto.salvarTodaALista(produtos);

            return true; 
            }
        }
            return false; 
    }
    public boolean editarCliente(String nomeAntigo, String novoNome, String novoCPF, String novaSenha) {
    for (Cliente c : clientes) {
        if (c.getNome().equalsIgnoreCase(nomeAntigo)) {
            c.setNome(novoNome);
            c.setCpf(novoCPF);
            c.setSenha(novaSenha);
            arqCliente.salvarTodaALista(clientes);
            
            return true; 
            }
        }
            return false;
           
    }
    public boolean editarFuncionario(String nomeAntigo, String novoNome, String novoCPF) {
    for (Funcionario f: funcionarios) {
        if (f.getNome().equalsIgnoreCase(nomeAntigo)) {
            f.setNome(novoNome);
            f.setCpf(novoCPF);
            arqFuncionario.salvarTodaALista(funcionarios);
            
            return true; 
            }
        }
            return false; 
    }
    public void atualizarEstoque() {
        arqProduto.salvarTodaALista(produtos);
    }
    @Override
    public boolean autenticarClienteandFuncionario(boolean isFuncionario, String cpf, String senha){

        if(isFuncionario){
            for (Funcionario f: funcionarios) {
                if(f.getCpf().equals(cpf) && f.getSenha().equals(senha)){
                    return true;
                }
            }
            return false;
        }
        else{
            for (Cliente c: clientes) {
                if(c.getCpf().equals(cpf) && c.getSenha().equals(senha)){
                    return true;
                }
            }
            return false;
        }
        
    }

    
    
}