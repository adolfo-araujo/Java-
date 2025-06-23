import java.util.Random;
import java.util.Scanner;

public class GeradorSenha {
    private int tamanho;
    private boolean usarMaiusculas;
    private boolean usarNumeros;
    private boolean usarSimbolos;

    public GeradorSenha(int tamanho, boolean usarMaiusculas, boolean usarNumeros, boolean usarSimbolos) {
        this.tamanho = tamanho;
        this.usarMaiusculas = usarMaiusculas;
        this.usarNumeros = usarNumeros;
        this.usarSimbolos = usarSimbolos;
    }

    public String gerar() {
        String caracteres = "abcdefghijklmnopqrstuvwxyz";

        if (usarMaiusculas) {
            caracteres += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (usarNumeros) {
            caracteres += "0123456789";
        }
        if (usarSimbolos) {
            caracteres += "!@#$%^&*()-_=+[]{};:,.<>/?";
        }

        StringBuilder senha = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            int index = rand.nextInt(caracteres.length());
            senha.append(caracteres.charAt(index));
        }

        return senha.toString();
    }

    // Método para ler apenas "sim" ou "nao" do usuário
    public static boolean lerRespostaSN(Scanner scanner, String mensagem) {
        String resposta;

        while (true) {
            System.out.print(mensagem);
            resposta = scanner.next().trim().toLowerCase();

            if (resposta.equals("sim")) {
                return true;
            } else if (resposta.equals("nao")) {
                return false;
            } else {
                System.out.println("Resposta inválida! Por favor, digite apenas 'sim' ou 'nao'.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GERADOR DE SENHAS (Java - OO) ===\n");

        System.out.print("Digite o tamanho da senha desejada: ");
        int tamanho = scanner.nextInt();

        boolean usarMaiusculas = lerRespostaSN(scanner, "Incluir letras maiúsculas? (sim/nao): ");
        boolean usarNumeros    = lerRespostaSN(scanner, "Incluir números? (sim/nao): ");
        boolean usarSimbolos   = lerRespostaSN(scanner, "Incluir símbolos? (sim/nao): ");

        // Cria o objeto GeradorSenha
        GeradorSenha gerador = new GeradorSenha(tamanho, usarMaiusculas, usarNumeros, usarSimbolos);

        // Gera a senha
        String senhaGerada = gerador.gerar();

        System.out.println("\nSenha gerada:");
        System.out.println(senhaGerada);

        System.out.println("\n=====================================");

        scanner.close();
    }
}