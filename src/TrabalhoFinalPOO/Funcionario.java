package TrabalhoFinalPOO;


public class Funcionario extends Pessoa {

    private static final long serialVersionUID = 1L;
    private static int totalFuncionarios = 0;

    public Funcionario(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        totalFuncionarios++;
    }

    public static int getTotalFuncionarios() {
        return totalFuncionarios;
    }

    public static void ajustarTotal(int qtd) {
        totalFuncionarios = qtd;
    }
}
