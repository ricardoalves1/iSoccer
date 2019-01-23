public class Medico extends Funcionario {

    private String crm;

    public Medico(String nome, String email, String cpf, String crm, float salario, String telefone) {
        super(nome, email, cpf, salario, telefone);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }
}
