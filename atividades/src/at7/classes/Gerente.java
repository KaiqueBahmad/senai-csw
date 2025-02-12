package at7.classes;

public class Gerente extends Funcionario {
	
	
	public Gerente(String nome, double salario) {
		super(nome, salario);
	}
	
	@Override
	public double calcularBonus() {
		return this.salario * 0.20;
	}
}
