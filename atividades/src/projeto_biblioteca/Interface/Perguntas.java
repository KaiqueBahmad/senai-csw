package projeto_biblioteca.Interface;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import projeto_biblioteca.Entidades.Cliente;
import projeto_biblioteca.Entidades.Livro;
import projeto_biblioteca.Entidades.Operador;
import projeto_biblioteca.Entidades.Usuario;

public class Perguntas {
	public static Scanner scanner = new Scanner(System.in);
	
	public static String mostrarMenu() {
		if (Main.logado instanceof Operador) {
			System.out.println("A) Cadastrar um Livro");
			System.out.println("B) Editar Livro");
			System.out.println("C) Excluir Livro");
			System.out.println("D) Cadastrar Cliente");
			System.out.println("E) Remover Cliente");
		}
		if (Main.logado instanceof Cliente) {
			System.out.println("A) Locar livro");
			System.out.println("B) Devolver livro");
		}
		aviso();
		return scanner.nextLine();
	}
	public static String pedirLogin() {
		System.out.println("#(Existe um usuário padrão username: operador, senha: 1234 )");
		System.out.println("A) Login");
		aviso();
		System.out.println("Escolha uma opcao: ");
		return scanner.nextLine();
	}
	
	public static String coletarLogin() {
		String resposta = "";
		aviso();
		System.out.println("Insira seu username: ");
		String temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		resposta += temp;
		System.out.println("Insira sua senha: ");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		resposta += ";";
		resposta += temp;
		return resposta;
	}
	
	public static String editarLivro() {
		String resposta = "";
		System.out.println("Livros Cadastrados: ");
		Main.biblioteca.mostrarLivros();
		System.out.println("------ Selecione um Livro ------");
		System.out.print("ID: ");
		String id = scanner.nextLine();
		String temp = "";
		
		aviso();
		System.out.println("Novo Titulo  (Vazio deixa igual)");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		resposta += temp;
		
		aviso();
		System.out.println("Novo Autor   (Vazio deixa igual)");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		resposta += ";"+temp;
		
		aviso();
		System.out.println("Novo Data    (Vazio deixa igual)");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		if (!temp.equals("") && !isNum(temp)) {
			System.out.println("Data inválida");
			return "-1";
		}
		resposta += ";"+temp;
		
		System.out.println("Novo Estoque (Vazio deixa igual)");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		if (!temp.equals("") && (!isNum(temp) || Integer.parseInt(temp) < 0)) {
			System.out.println("Entrada inválida para estoque");
			return "-1";
		}
		resposta += ";"+temp;
		resposta += ";"+id;
		
		return resposta;
	}
	
	public static String removerLivro() {
		aviso();
		System.out.println("Lista de livros: ");
		Main.biblioteca.mostrarLivros();
		String id = scanner.nextLine();
		if (!isNum(id)) {
			System.out.println("Entrada inválida para ID de livro.");
			return "-1";
		}
		if ("-1".equals(id)) {
			return "-1";
		}
		if (!Main.biblioteca.getLivros().containsKey(Long.parseLong(id))) {
			System.out.println("Livro nao está na lista");
			return "-1";
		}
		return id;
	}
	
	public static String cadastrarLivro() {
		String resposta = "";
		aviso();
		System.out.println("Insira o nome do livro: ");
		String temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		resposta += temp;

		aviso();
		System.out.println("Insira o nome do autor: ");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		resposta += ";" + temp;
		
		aviso();
		System.out.println("Insira o ano de publicação:");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		if (!isNum(temp)) {
			System.out.println("Data inválida");
			return "-1";
		}
		resposta += ";" + temp;
		
		aviso();
		System.out.println("Insira a quantidade em estoque:");
		temp = scanner.nextLine();
		if ("-1".equals(temp)) {
			return "-1";
		}
		if (!isNum(temp) || Integer.parseInt(temp) < 0) {
			System.out.println("Entrada inválida para quantidade em estoque");
			return "-1";
		}
		resposta += ";" + temp;

		return resposta;
	}
	
	public static String cadastrarCliente() {
	    String resposta = "";
	    aviso();
	    
	    System.out.println("Insira o username do cliente: ");
	    String temp = scanner.nextLine();
	    if ("-1".equals(temp)) {
	        return "-1";
	    }
	    resposta += temp;

	    aviso();
	    System.out.println("Insira a senha: ");
	    temp = scanner.nextLine();
	    if ("-1".equals(temp)) {
	        return "-1";
	    }
	    resposta += ";" + temp;
	    
	    aviso();
	    System.out.println("Insira o nome do cliente: ");
	    temp = scanner.nextLine();
	    if ("-1".equals(temp)) {
	        return "-1";
	    }
	    resposta += ";" + temp;
	    
	    aviso();
	    System.out.println("Insira o CPF: ");
	    temp = scanner.nextLine();
	    if ("-1".equals(temp)) {
	        return "-1";
	    }
	    resposta += ";" + temp;
	    
	    aviso();
	    System.out.println("Insira o endereço: ");
	    temp = scanner.nextLine();
	    if ("-1".equals(temp)) {
	        return "-1";
	    }
	    resposta += ";" + temp;
	    
	    aviso();
	    System.out.println("Insira o telefone: ");
	    temp = scanner.nextLine();
	    if ("-1".equals(temp)) {
	        return "-1";
	    }
	    resposta += ";" + temp;

	    return resposta;
	}

	public static String removerCliente() {
	    aviso();
	    System.out.println("Lista de clientes: ");
	    for (Usuario usuario : Main.biblioteca.getUsuarios()) {
	        if (usuario.getClass().equals(Cliente.class)) {
	            Cliente cliente = (Cliente) usuario;
	            System.out.println("Username: " + cliente.getUsername() + 
	                             " | Nome: " + cliente.getNome() + 
	                             " | CPF: " + cliente.getCpf());
	        }
	    }
	    System.out.println("Digite o username do cliente a ser removido: ");
	    String username = scanner.nextLine();
	    if ("-1".equals(username)) {
	        return "-1";
	    }
	    return username;
	}
	
	private static boolean isNum(String in) {
		try {
	        Integer.parseInt(in);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public static String locarLivro() {
		aviso();
		System.out.println("Livros disponíveis:");
		for (Livro livro : Main.biblioteca.getLivros().values()) {
			if (livro.getEstoque() > 0 && ! ((Cliente) Main.logado).getLivrosEmprestados().contains(livro)) {
				System.out.println(livro);
			}
		}
		System.out.println("Digite o ID do livro que deseja locar:");
		return scanner.nextLine();
	}
	
	public static String devolverLivro() {
		Cliente cliente = (Cliente) Main.logado;
		aviso();
		System.out.println("Seus livros emprestados:");
		for (Livro livro : cliente.getLivrosEmprestados()) {
			System.out.println(livro);
		}
		if (cliente.getLivrosEmprestados().isEmpty()) {
			System.out.println("Você não tem livros emprestados.");
			return "-1";
		}
		System.out.println("Digite o ID do livro que deseja devolver:");
		return scanner.nextLine();
	}
	
	private static void aviso() {
		System.out.println("(-1) Cancela a Operacao");
		System.out.println("(-2) Desloga");
	}
	
	

}
