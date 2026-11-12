package TrabalhoFinalPOO;


import java.util.ArrayList;

public class SupermercadoController implements Autenticavel {

    ArqProduto arqProduto = new ArqProduto();
    ArqCliente arqCliente = new ArqCliente();
    ArqFuncionario arqFuncionario = new ArqFuncionario();
    ArqVendas arqVendas = new ArqVendas();

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendas;

    public SupermercadoController() {
        this.funcionarios = arqFuncionario.listar();
        this.produtos = arqProduto.listar();
        this.clientes = arqCliente.listar();
        this.vendas = arqVendas.listar();
        Funcionario.ajustarTotal(funcionarios.size());
        Cliente.ajustarTotal(clientes.size());

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

    public ArrayList<Venda> listarVendas() {
        return vendas;
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

    public void registrarVenda(Venda v) {
        vendas.add(v);
        arqVendas.salvar(v);
    }

    public boolean editarProduto(String nomeAntigo, String novaMarca, String novoNome, int novaQuantidade, double novoPreco, String novaValidade) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nomeAntigo)) {
                p.setNome(novoNome);
                p.setQuantidade(novaQuantidade);
                p.setPreco(novoPreco);
                p.setMarca(novaMarca);
                p.setValidade(novaValidade);
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

    public boolean editarFuncionario(String nomeAntigo, String novoNome, String novoCPF, String novaSenha) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nomeAntigo)) {
                f.setNome(novoNome);
                f.setCpf(novoCPF);
                f.setSenha(novaSenha);
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
    public boolean autenticarClienteandFuncionario(boolean isFuncionario, String cpf, String senha) {

        if (isFuncionario) {
            for (Funcionario f : funcionarios) {
                if (f.getCpf().equals(cpf) && f.getSenha().equals(senha)) {
                    return true;
                }
            }
            return false;
        } else {
            for (Cliente c : clientes) {
                if (c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
                    return true;
                }
            }
            return false;
        }

    }

    public Cliente buscarClientePorLogin(String cpf, String senha) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
                return c;
            }
        }
        return null;
    }

    public String getFuncionarioLogado() {
        return funcionarios.get(0).getNome();
    }

    public void atualizarProduto(Produto antigo, Produto novo) {
        int i = produtos.indexOf(antigo);
        if (i != -1) {
            produtos.set(i, novo);
            arqProduto.salvarTodaALista(produtos);
        }
    }

    public Funcionario buscarFuncionarioPorLogin(String cpf, String senha) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf) && f.getSenha().equals(senha)) {
                return f;
            }
        }
        return null;
    }

    public boolean recuperarSenha(String tipo, String nome, String cpf, String novaSenha) {

        if (tipo.equals("Funcionario")) {
            for (Funcionario f : listarFuncionarios()) {
                if (f.getNome().equalsIgnoreCase(nome)
                        && f.getCpf().equals(cpf)) {

                    f.setSenha(novaSenha);
                    arqFuncionario.salvarTodaALista(listarFuncionarios());
                    return true;
                }
            }
        }

        if (tipo.equals("Cliente")) {
            for (Cliente c : listarClientes()) {
                if (c.getNome().equalsIgnoreCase(nome)
                        && c.getCpf().equals(cpf)) {

                    c.setSenha(novaSenha);
                    arqCliente.salvarTodaALista(listarClientes());
                    return true;
                }
            }
        }

        return false;
    }

    public double calcularFaturamentoTotal() {
        double total = 0;
        for (Venda v : vendas) {
            total += v.getTotal();
        }
        return total;
    }

}
