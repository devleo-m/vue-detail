import java.util.ArrayList;
import java.util.Collections;
public class SistemaGerenciamentoProdutos {
    ArrayList<Produto> produtos = new ArrayList<>();

    public SistemaGerenciamentoProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    public void cadastrarProduto(String nome, String descricao, double valor, boolean disponivel) {
        Produto novoProduto = new Produto(nome, descricao, valor, disponivel);
        produtos.add(novoProduto);
        System.out.println("Produto "+nome+" cadastrado com sucesso!");
        exibirProdutos();
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado ainda.");
            return;
        }

        ordenarProdutosPorValor();
        System.out.println("\nLista de Produtos:");
        System.out.println("----------------------");
        System.out.println("Nome\t\t\tValor"); // Ajustando a formatação dos títulos

        for (Produto produto : produtos) {
            System.out.printf("%-15s %.2f%n", produto.getNome(), produto.getValor()); // Alinhamento dos valores
        }
        System.out.println("----------------------\n");
    }

    public void ordenarProdutosPorValor() {
        Collections.sort(produtos, (p1, p2) -> Double.compare(p1.getValor(), p2.getValor()));
    }


}
