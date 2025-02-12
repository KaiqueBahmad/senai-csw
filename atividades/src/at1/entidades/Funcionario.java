package at1.entidades;

public class Funcionario {
	private String nome;
	private Double salario;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getSalario() {
		return salario;
	}
	public void aumentarSalario(Double amount) {
		if (this.salario == null) {
			salario = 0.0;
		}
		salario += amount;
	}
	
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", salario=" + salario + "]";
	}
	
	
	
	
}
