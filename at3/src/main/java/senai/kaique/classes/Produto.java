package senai.kaique.classes;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;


    public void adicionarEstoque(int qtd) {
        if (qtd <= 0) {
            return;
        }
        quantidadeEstoque += qtd;
    }

    public void removerEstoque(int qtd) {
        if (quantidadeEstoque - qtd < 0) {
            System.out.println("Voc� n�o pode remover mais do que h� no estoque.");
            return;
        }
        quantidadeEstoque -= qtd;
    }


    public void exibirInformacoes() {
        System.out.printf("Nome: %s\nPreco: %.2f\nQuantidade Estoque: %d\n",nome, preco, quantidadeEstoque);
    }

    public String getNome() {
        return nome;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}