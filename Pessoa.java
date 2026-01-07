import java.io.Serializable;

public abstract class Pessoa implements Serializable{ 
    protected String nome; 
    protected String cpf; 
    protected String senha;
    public Pessoa(String nome, String cpf, String senha) { 
        this.nome = nome; 
        this.cpf = cpf; 
        this.senha = senha;
    } 
    public void setNome(String nome) { 
        this.nome = nome; 
    } 
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    } 
    
    public String getNome() { 
        return nome; 
    } 
    public String getCpf() { 
        return cpf; 
    } 
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}