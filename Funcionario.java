public class Funcionario extends Pessoa implements Autenticavel {

    public Funcionario(String nome, String cpf, boolean confirmaGestor){ 
        super(nome, cpf, true);   
    }
    @Override
    public boolean autenticar(String senha) {
        return senha.equals("1234");
    }
    public String getNome() {
        return "Funcionário: " + super.getNome();
    }
}
