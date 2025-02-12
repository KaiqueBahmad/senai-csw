package at5.classes;

public class PagamentoCartao extends Pagamento {

	public PagamentoCartao(double valor_total) {
		this.valor_total = valor_total;
	}
	
	@Override
	public double calcularValor() {
		return this.valor_total - valor_total * 0.02;
	}

	@Override
	public void exibirDetalhes() {
			System.out.println("Pagamento em cartão utilizando 2% sobre o total como taxas. Totalizando: "+calcularValor());
		
	}

	
	
}
