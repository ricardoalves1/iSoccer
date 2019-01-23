import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String login = "";
        String senha = "";

        System.out.println(" - iSoccer - \n");

        while (true) {
            System.out.print("login: ");
            login = input.next();

            System.out.print("Senha: ");
            senha = input.next();

            if (!login.equals("login") || !senha.equals("senha")){
                System.out.println("Login ou senha incorreto");
            }
            else {
                new Sistema().menu();
                break;
            }
        }

    }

}
