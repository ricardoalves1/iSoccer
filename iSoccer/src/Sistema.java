import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    Funcionario presidente;
    Funcionario medico;
    Funcionario tecnico;
    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    ArrayList<SocioTorcedor> sociosTorcedores = new ArrayList<>();

    boolean onibus = false;
    boolean estadio = false;
    int torcedores;
    int banheiros;
    int lanchonetes;
    boolean centroDeTreinamento = false;
    int dormitorios;


    Scanner input = new Scanner(System.in);

    public void menu() {

        int opc = -1;
        while (opc != 0) {

            System.out.println("\n(1) Adicionar funcionário\n" +
                    "(2) Adicionar sócio-torcedor\n" +
                    "(3) Alterar estado de pagamento dos sócios\n" +
                    "(4) Atualizar valor de contribuição\n" +
                    "(5) Listar Funcionários\n" +
                    "(6) Time\n" +
                    "(7) Gerenciar recurso físico\n" +
                    "(8) Relatório - sócio torcedor\n" +
                    "(9) Recursos físicos\n" +
                    "(0) Sair");

            try {
                opc = Integer.parseInt(input.next());

                switch (opc) {
                    case 0:
                        break;
                    case 1:
                        addFuncionario();
                        break;
                    case 2:
                        addSocio();
                        break;
                    case 3:
                        alterarEstadoPagamento();
                        break;
                    case 4:
                        atualizarContribuicao();
                        break;
                    case 5:
                        listarFuncionarios();
                        break;
                    case 6:
                        time();
                        break;
                    case 7:
                        gerenciarRecursos();
                        break;
                    case 8:
                        relatorioSocioTorcedor();
                        break;
                    case 9:
                        if (onibus) {
                            System.out.println("Transporte: ônibus");
                        }
                        else {
                            System.out.println("Transporte: não possui");
                        }

                        if (centroDeTreinamento) {
                            System.out.println("Centro de treinamento: " + dormitorios + " dormitórios");
                        }
                        else {
                            System.out.println("Não possui centro de treinamento");
                        }

                        if (estadio) {
                            System.out.println("Estádio:\nCapacidade: " + torcedores + "\nLanchonetes: " + lanchonetes + "\nBanheiros: " + banheiros);
                        }
                        else {
                            System.out.println("Não possui estádio");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida");
                }

            }
            catch (NumberFormatException e) {
                System.out.println("Opção inválida");
            }

        }

    }

    private void addFuncionario() {

        System.out.println("\nAdicionar Funcionário\n" +
                "(1) Presidente\n" +
                "(2) Médico\n" +
                "(3) Técnico\n" +
                "(4) Preparador Físico\n" +
                "(5) Motorista\n" +
                "(6) Cozinheiro\n" +
                "(7) Advogado\n" +
                "(8) Jogador\n" +
                "(0) Cancelar");

        try {

            int opc = Integer.parseInt(input.next());
            input.nextLine();

            if (opc == 0) {
                return;
            }

            System.out.print("\nNome: ");
            String nome = input.nextLine();

            System.out.print("Email: ");
            String email = input.next();

            System.out.print("CPF: ");
            String cpf = input.next();

            if (cpf.length() != 11) {
                System.out.println("Cpf inválido\nFuncionário não cadastrado");
                return;
            }

            System.out.print("Telefone: ");
            String telefone = input.next();

            System.out.print("Salário: ");
            float salario = Float.parseFloat(input.next());

            switch (opc) {
                case 1:
                    if (verificarFuncionario(1, cpf)) {
                        presidente = new Presidente(nome, email, cpf, salario, telefone);
                        System.out.println("Presidente adicionado");
                    }
                    else {
                        System.out.println("Cadastro cancelado\nPresidente não adicionado");
                    }
                    break;
                case 2:
                    if (verificarFuncionario(2, cpf)) {
                        input.nextLine();
                        System.out.print("CRM: ");
                        String crm = input.nextLine();
                        medico = new Medico(nome, email, cpf, crm, salario, telefone);
                        System.out.println("Médico adicionado");
                    }
                    else {
                        System.out.println("Cadastro cancelado\nMédico não adicionado");
                    }
                    break;
                case 3:
                    if (verificarFuncionario(3, cpf)) {
                        tecnico = new Tecnico(nome, email, cpf, salario, telefone);
                        System.out.println("Técnico adicionado");
                    }
                    else {
                        System.out.println("Cadastro cancelado\nTécnico não adicionado");
                    }
                    break;
                case 4:
                    if (verificarFuncionario(4, cpf)) {
                        funcionarios.add(new PreparadorFisico(nome, email, cpf, salario, telefone));
                        System.out.println("Preparador físico adicionado");
                    }
                    break;
                case 5:
                    if (verificarFuncionario(5, cpf)) {
                        input.nextLine();
                        System.out.print("Número de habilitação: ");
                        String habilitacao = input.nextLine();
                        funcionarios.add(new Motorista(nome, email, cpf, habilitacao, salario, telefone));
                        System.out.println("Motorista adicionado");
                    }
                    break;
                case 6:
                    if (verificarFuncionario(6, cpf)) {
                        funcionarios.add(new Cozinheiro(nome, email, cpf, salario, telefone));
                        System.out.println("Cozinheiro adicionado");
                    }
                    break;
                case 7:
                    if (verificarFuncionario(7, cpf)) {
                        funcionarios.add(new Advogado(nome, email, cpf, salario, telefone));
                        System.out.println("Advogado adicionado");
                    }
                    break;
                case 8:
                    if (verificarFuncionario(8, cpf)) {
                        input.nextLine();
                        String tipo;

                        while (true) {
                            System.out.print("Tipo de jogador: ");
                            tipo = input.nextLine();
                            if (tipo.equals("volante") || tipo.equals("zagueiro") || tipo.equals("meia") || tipo.equals("goleiro") || tipo.equals("atacante") || tipo.equals("lateral esquerdo") || tipo.equals("lateral direito")) {
                                break;
                            } else {
                                System.out.println("Tipo de jogador inválido\nTipos válidos: volante, zagueiro, meia, goleiro, atacante, lateral esquerdo e lateral direito.");
                            }
                        }

                        System.out.println("O jogador está apto para jogar?\n(1) Sim \t (2) Não");
                        boolean apto = false;
                        if (Integer.parseInt(input.next()) == 1) {
                            apto = true;
                        }
                        funcionarios.add(new Jogador(nome, email, tipo, cpf, salario, telefone, apto));
                        System.out.println("Jogador adicionado");
                    }
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Operação inválida");
        }
    }

    private boolean verificarFuncionario(int opc, String cpf) {

        try {
            if (opc == 1) {
                if (presidente != null) {
                    System.out.println("Deseja substituir o presidente?\n(1) Sim \t (0) Não");
                    int esc = Integer.parseInt(input.next());

                    if (esc != 1) {
                        return false;
                    }
                }
            } else if (opc == 2) {
                if (medico != null) {
                    System.out.println("Deseja substituir o médico?\n(1) Sim \t (0) Não");
                    int esc = Integer.parseInt(input.next());

                    if (esc != 1) {
                        return false;
                    }
                }
            } else if (opc == 3) {
                if (tecnico != null) {
                    System.out.println("Deseja substituir o técnico?\n(1) Sim \t (0) Não");
                    int esc = Integer.parseInt(input.next());

                    if (esc != 1) {
                        return false;
                    }
                }
            } else if (opc > 3 && opc < 9) {

                for (Funcionario i: funcionarios) {
                    if (i.getCpf() == cpf) {
                        System.out.println("Cadastro cancelado\nEsse funcionário já está cadastrado");
                        return false;
                    }
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida");
            return false;
        }

        return true;
    }

    private void addSocio() {

        System.out.println(" - Adicionar Sócio-Torcedor - ");

        System.out.print("Nome: ");
        input.next();
        String nome = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("CPF: ");
        String cpf = input.nextLine();

        if (cpf.length() != 11) {
            System.out.println("Cpf inválido\nSócio Torcedor não cadastrado");
            return;
        }

        System.out.print("Telefone: ");
        String telefone = input.nextLine();

        System.out.print("Endereço: ");
        String endereco = input.nextLine();

        boolean estadoPagamento = true;
        while (true) {
            try {
                System.out.println("Estado de pagamento\n(1) Adimplente \t (2) Inadimplente");
                if (Integer.parseInt(input.next()) == 2) {
                    estadoPagamento = false;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida");
            }
        }

        while (true) {
            try {
                System.out.println("Tipo de sócio torcedor:\n(1) Júnior\n(2) Sênior\n(3) Elite");
                int opc = Integer.parseInt(input.next());

                switch (opc) {
                    case 1:
                        sociosTorcedores.add(new SocioJunior(nome, email, cpf, telefone, endereco, estadoPagamento));
                        break;
                    case 2:
                        sociosTorcedores.add(new SocioSenior(nome, email, cpf, telefone, endereco, estadoPagamento));
                        break;
                    case 3:
                        sociosTorcedores.add(new SocioElite(nome, email, cpf, telefone, endereco, estadoPagamento));
                        break;
                    default:
                        System.out.println("Opção inválida");
                        continue;
                }

                System.out.println("Sócio Torcedor adicionado");
                break;
            } catch (NumberFormatException e) {
                System.out.print("Opção inválida");
            }

        }

    }

    private void atualizarContribuicao() {

        try {
            System.out.println("Atualizar valor da contribuição do Sócio Torcedor\n(1) Júnior\n(2) Sênior\n(3) Elite");
            int opc = Integer.parseInt(input.next());
            SocioTorcedor socio = new SocioTorcedor();
            float[] valor = {socio.getContribuicao()[0], socio.getContribuicao()[1], socio.getContribuicao()[2]};
            switch (opc) {
                case 1:
                    System.out.print("Valor: ");
                    valor[0] = Float.parseFloat(input.next());
                    socio.setContribuicao(valor);
                    System.out.println("Valor alterado");
                    break;
                case 2:
                    System.out.print("Valor: ");
                    valor[1] = Float.parseFloat(input.next());
                    socio.setContribuicao(valor);
                    System.out.println("Valor alterado");
                    break;
                case 3:
                    System.out.print("Valor: ");
                    valor[2] = Float.parseFloat(input.next());
                    socio.setContribuicao(valor);
                    System.out.println("Valor alterado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } catch (NumberFormatException e) {
            System.out.println("Opção inválida");
        }

    }

    private void alterarEstadoPagamento() {
        input.nextLine();
        System.out.println("Alterar estado de pagamento do sócio torcedor:");
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.println(cpf);

        for (SocioTorcedor i: sociosTorcedores) {
            if (i.getCpf().equals(cpf)) {

                try {
                    System.out.printf("Sócio torcedor está %s\n(1) Alterar \t (2) Cancelar\n", i.isEstadoPagamento() ? "adimplente" : "inadimplente");
                    switch (Integer.parseInt(input.next())) {
                        case 1:
                            if(i.isEstadoPagamento()) {
                                i.setEstadoPagamento(false);
                            } else {
                                i.setEstadoPagamento(true);
                            }
                            System.out.println("Estado de pagamento alterado");
                            break;
                        case 2:
                            System.out.println("Estado de pagamento não foi alterado");
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida");
                }
                return;
            }
        }

        System.out.println("Sócio torcedor não encontrado");

    }

    private void listarFuncionarios() {

        if (presidente != null)
            System.out.println("Presidente: "+ presidente.getNome());
        if (medico != null)
            System.out.println("Médico: "+ medico.getNome() +"\nOutros funcionários:");

        for (Funcionario i: funcionarios) {
            if (i instanceof Advogado) {
                System.out.print("Advogado: ");
            }
            else if (i instanceof Cozinheiro) {
                System.out.print("Cozinheiro: ");
            }
            else if (i instanceof Motorista) {
                System.out.print("Motorista: ");
            }
            else if (i instanceof PreparadorFisico) {
                System.out.print("Preparador Físico: ");
            }

            System.out.println(i.getNome());
        }

    }

    private void time() {

        if (tecnico != null)
            System.out.println("Técnico: " + tecnico.getNome());

        System.out.println("Jogadores:");
        for (Funcionario i: funcionarios) {
            if (i instanceof Jogador) {
                System.out.printf("%s - %s (%s)\n", i.getNome(), ((Jogador) i).getTipo(), ((Jogador) i).isApto() ? "Apto" : "Inapto");
            }
        }

    }

    public void relatorioSocioTorcedor() {

        System.out.println("Sócios Torcedores: " + sociosTorcedores.size());

        int adimplente = 0;
        for (SocioTorcedor i: sociosTorcedores) {
            if (i.isEstadoPagamento()) {
                adimplente += 1;
            }
        }

        System.out.println("Adimplentes: " + adimplente + "\nInadimplentes: " + (sociosTorcedores.size() - adimplente) + "\nTorcedores:");

        for (SocioTorcedor i: sociosTorcedores) {
            System.out.printf("%s - %s\n", i.getNome(), i.isEstadoPagamento() ? "adimplente" : "inadimplente");
        }

    }

    public void gerenciarRecursos() {

        System.out.println("Gerenciar Recursos Físicos\n(1) Ônibus\n(2) Estádio\n(3) Centro de treinamento");

        try {
            int opc = Integer.parseInt(input.next());

            switch (opc) {
                case 1:
                    if (!onibus) {
                        System.out.println("(1) Adicionar ônibus");
                    }
                    else {
                        System.out.println("(1) Remover ônibus");
                    }

                    if (Integer.parseInt(input.next()) == 1){
                        if (onibus) {
                            onibus = false;
                        }
                        else {
                            onibus = true;
                        }
                    }
                    break;
                case 2:
                    if (!estadio) {
                        System.out.println("(1) Adicionar estádio");
                    }
                    else {
                        System.out.println("(1) Remover estádio\n(2) Torcedores\n(3) Banheiros\n(4) Lanchonetes");
                    }

                    switch (Integer.parseInt(input.next())){
                        case 1:
                            if (estadio) {
                                estadio = false;
                            }
                            else {
                                estadio = true;
                            }
                            break;
                        case 2:
                            if (estadio) {
                                System.out.print("Quantidade: ");
                                torcedores = Integer.parseInt(input.next());
                            }
                            break;
                        case 3:
                            if (estadio) {
                                System.out.print("Quantidade: ");
                                banheiros = Integer.parseInt(input.next());
                            }
                            break;
                        case 4:
                            if (estadio) {
                                System.out.print("Quantidade: ");
                                lanchonetes = Integer.parseInt(input.next());
                            }
                            break;
                        default:
                            System.out.println("Opção inválida");

                    }
                    break;
                case 3:
                    if (!centroDeTreinamento) {
                        System.out.println("(1) Adicionar centro de treinamento");
                    }
                    else {
                        System.out.println("(1) Remover centro de treinamento\n(2) Dormitórios");
                    }

                    switch (Integer.parseInt(input.next())){
                        case 1:
                            if (centroDeTreinamento) {
                                centroDeTreinamento = false;
                            }
                            else {
                                centroDeTreinamento = true;
                            }
                            break;
                        case 2:
                            if (centroDeTreinamento) {
                                System.out.print("Quantidade de dormitórios: ");
                                dormitorios = Integer.parseInt(input.next());
                            }
                            break;
                    }
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Opção inválida");
        }

    }

}
