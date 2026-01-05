public class Cliente extends Pessoa{

    public Cliente(String nome, String cpf){ 
        super(nome, cpf, false);  
    }
   
    public String getNome() {
        return "Cliente: " + super.getNome();
    }
    
}