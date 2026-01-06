public class Cliente extends Pessoa implements Autenticavel {
    private String senha;
    public Cliente(String nome, String cpf, String senha){ 
        super(nome, cpf, false, senha);  
        
    }
    @Override
    public boolean autenticar(String senha) {
        
        return senha.equals(senha);
    }
   
    public String getNome() {
        return "Cliente: " + super.getNome();
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }

    
}