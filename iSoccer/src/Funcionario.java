public class Funcionario {

    private String nome;
    private String email;
    private String cpf;
    private float salario;
    private String telefone;

    public Funcionario(){}

    public Funcionario(String nome, String email, String cpf, float salario, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.salario = salario;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}