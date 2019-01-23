public class Motorista extends Funcionario {

    private String habilitacao;

    public Motorista(String nome, String email, String cpf, String habilitacao, float salario, String telefone) {
        super(nome, email, cpf, salario, telefone);
        this.habilitacao = habilitacao;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }
}
