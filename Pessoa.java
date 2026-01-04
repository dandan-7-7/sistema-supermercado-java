public abstract class Pessoa { 
    private String nome; 
    private String cpf; 
    private boolean confirmaGestor; 
    public Pessoa(String nome, String cpf, boolean confirmaGestor){ 
        this.nome = nome; 
        this.cpf = cpf; 
        this.confirmaGestor = confirmaGestor; 
    } 
    public void setNome(String nome) { 
        this.nome = nome; 
    } 
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    } 
    public void setConfirmaGestor(boolean confirmaGestor) { 
        this.confirmaGestor = confirmaGestor; 
    } 
    public String getNome() { 
        return nome; 
    } 
    public String getCpf() { 
        return cpf; 
    } public boolean getConfirmaGestor() {
        return confirmaGestor; 
    } 
}