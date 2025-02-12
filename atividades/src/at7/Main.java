package at7;

import java.util.LinkedList;
import java.util.List;

import at7.classes.Desenvolvedor;
import at7.classes.Funcionario;
import at7.classes.Gerente;

public class Main {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new LinkedList<>();
		Funcionario funcionario = new Funcionario("Funcionario 1", 1555.2);
		Funcionario gerente = new Gerente("Gerente", 2550.50);
		Funcionario desenvolvedor = new Desenvolvedor("Desenvolvedor", 3001.50);
		funcionarios.add(funcionario);
		funcionarios.add(gerente);
		funcionarios.add(desenvolvedor);
		
		for (Funcionario func: funcionarios) {
			func.exibirDetalhes();
		}
		
		
	}
}
