public class Jogador extends Funcionario {

    private String tipo;
    private boolean apto;

    public Jogador(String nome, String email, String tipo, String cpf, float salario, String telefone, boolean apto) {
        super(nome, email, cpf, salario, telefone);
        this.tipo = tipo;
        this.apto = apto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }
}
