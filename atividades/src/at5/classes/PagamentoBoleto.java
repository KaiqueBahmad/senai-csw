package at5.classes;

public class PagamentoBoleto extends Pagamento {

	public PagamentoBoleto(double valor_total) {
		this.valor_total = valor_total;
	}
	
	@Override
	public double calcularValor() {
		return this.valor_total;
	}

	@Override
	public void exibirDetalhes() {
			System.out.println("Pagamento Boleto de "+this.valor_total+", utilizando 0% sobre o total como taxas. Totalizando: "+calcularValor());
		
	}

	
	
}
