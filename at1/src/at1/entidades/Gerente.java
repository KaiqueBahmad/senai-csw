package at1.entidades;

public class Gerente extends Funcionario {

	private String departamento;
	
	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	@Override
	public String toString() {
		return "Gerente [nome=" + getNome() + ", salario=" + getSalario() + ", departamento="+departamento+"]";
	}
	
	
	
	

}
