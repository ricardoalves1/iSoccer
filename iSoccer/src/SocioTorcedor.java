public class SocioTorcedor {

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String endereco;
    private boolean estadoPagamento;
    private static float[] contribuicao = {0,0,0};

    public SocioTorcedor(String nome, String email, String cpf, String telefone, String endereco, boolean estadoPagamento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.estadoPagamento = estadoPagamento;
    }

    public SocioTorcedor() {}

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(boolean estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public static float[] getContribuicao() {
        return contribuicao;
    }

    public static void setContribuicao(float[] valor) {
        contribuicao = valor;
    }

}