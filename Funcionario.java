public class Funcionario extends Pessoa {
    public Funcionario(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
       
    }
    @Override
    public String getNome() {
        return "Funcionário: " + super.getNome();
    }
    public String getSenha() {
        return senha;
    }
}
