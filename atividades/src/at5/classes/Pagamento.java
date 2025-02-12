package at5.classes;

public abstract class Pagamento {
	protected double valor_total;
	public abstract double calcularValor();
	public abstract void exibirDetalhes();
}
