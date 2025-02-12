package at7.classes;

public class Funcionario {
	private String nome;
	protected double salario;
	
	public Funcionario (String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}

	public void exibirDetalhes() {
		System.out.printf("Funcionario %s, salário R$%.2f, bonus: %.2f\n", nome, salario, this.calcularBonus());
	}
	
	public double calcularBonus() {
		return salario * 0.1;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
