package at7.classes;

public class Desenvolvedor extends Funcionario {

	public Desenvolvedor(String nome, double salario) {
		super(nome, salario);
	}
	
	@Override
	public double calcularBonus() {
		return this.salario * 0.15;
	}
	
	
}
