package TrabalhoFinalPOO;


public class Cliente extends Pessoa implements Autenticavel {

    private static final long serialVersionUID = 1L;
    private static int totalClientes = 0;

    @Override
    public boolean autenticarClienteandFuncionario(boolean isFuncionario, String cpf, String senha) {

        return this.getSenha().equals(senha);
    }

    public Cliente(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.senha = senha;
        totalClientes++;
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf, "123456789");
        totalClientes++;

    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public static int getTotalClientes() {
        return totalClientes;
    }

    public static void ajustarTotal(int qtd) {
        totalClientes = qtd;
    }
}
