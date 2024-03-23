import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        SistemaGerenciamentoProdutos gerenciador = new SistemaGerenciamentoProdutos(listaProdutos);

        do {
            System.out.println("|---------Menu--------|");
            System.out.println("|1 - Cadastrar Produto|");
            System.out.println("|2 - Sair             |");
            System.out.println("|---------------------|");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("\nCadastro de Produto:");
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição do produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor do produto: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    boolean loop = true;
                    boolean disponivel = false;
                    while (loop) {
                        System.out.print("Disponível para venda (sim/nao): ");
                        String opcaoBoolean = scanner.nextLine();
                        switch (opcaoBoolean.toLowerCase()) {
                            case "sim":
                                disponivel = true;
                                loop = false;
                                break;
                            case "nao":
                                disponivel = false;
                                loop = false;
                                break;
                            default:
                                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                                System.out.println("Você precisa digitar 'sim' ou 'não'.");
                                System.out.println("OBS: caso o erro persista mesmo digitando 'não' corretamente,");
                                System.out.println("digitar 'nao' sem acentuação.");
                                break;
                        }
                    }

                    gerenciador.cadastrarProduto(nome, descricao, valor, disponivel);
                    break;
                case 2:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (true);
    }
}
