package projeto_biblioteca.Interface;


import java.util.Arrays;
import java.util.List;

import projeto_biblioteca.Entidades.Cliente;
import projeto_biblioteca.Entidades.Livro;
import projeto_biblioteca.Entidades.Operador;
import projeto_biblioteca.Entidades.Usuario;


public class Controlador {

	public static void processarResposta(String resposta) {
		if ("-1".equals(resposta)) {
			if (Main.logado == null) {
				Main.estado = Etapas.PEDINDO_LOGIN;
			} else if (Main.logado.getClass().equals(Operador.class)) {
				Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
			} else if (Main.logado.getClass().equals(Cliente.class)) {
				Main.estado = Etapas.RECEBENDO_MENU_CLIENTE;
			}
		}
		if ("-2".equals(resposta)) {
			Main.logado = null;
			Main.estado = Etapas.PEDINDO_LOGIN;
		}
		switch (Main.estado) {
		case PEDINDO_LOGIN:
			handlePedindoLogin(resposta);
			
			break;

		case COLETANDO_LOGIN:
			handleColetandoLogin(resposta);
			break;
		
		case RECEBENDO_MENU_OPERADOR:
			handleRecebendoMenuOperador(resposta);
			break;
		
		case CADASTRANDO_LIVRO:
			handleCadastrandoLivro(resposta);
			break;
		
		case EDITANDO_LIVRO:
			handleEditandoLivro(resposta);
			break;
			
		case REMOVENDO_LIVRO:
			handleRemovendoLivro(resposta);
			break;
			
		case CADASTRAR_CLIENTE:
			handleCadastrarCliente(resposta);
			break;
			
		case REMOVER_CLIENTE:
			handleRemoverCliente(resposta);
			
		default:
			break;
		}
		
	}
	
	private static void handleRemovendoLivro(String resposta) {
		Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
		Long id = Long.parseLong(resposta);
		try {
			Main.biblioteca.getLivros().remove(id);
		} catch (Exception e) {
			System.out.println("erro ao remover livro.");
		}
		System.out.println("livro "+id+" removido");
	}

	private static void handleEditandoLivro(String resposta) {
		Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
		String[] content = resposta.split(";");
		String titulo = content[0];
		String autor = content[1];
		Integer pub = null;
		if (!"".equals(content[2])) {
			pub = Integer.parseInt(content[2]); //ano
		}
		Integer qtd = null;
		if (!"".equals(content[3])) {
			qtd = Integer.parseInt(content[3]); //estoque
		}
		Long id = Long.parseLong(content[4]);
		Livro atual = Main.biblioteca.getLivros().get(id);
		if (!"".equals(titulo)) {
			atual.setTitulo(titulo);
		}
		if (!"".equals(autor)) {
			atual.setAutor(autor);
		}
		if (pub != null) {
			atual.setAnoPub(pub);
		}
		if (qtd != null) {
			atual.setEstoque(qtd);
		}
	}

	private static void handleCadastrandoLivro(String resposta) {
		String[] content = resposta.split(";");
		String titulo = content[0];
		String autor = content[1];
		int pub = Integer.parseInt(content[2]); //ano
		int qtd = Integer.parseInt(content[3]); //estoque
		Livro livro = new Livro(titulo, autor, pub, qtd);
		if (!Main.biblioteca.jaCadastrado(livro)) {
			Main.biblioteca.getLivros().put(livro.getId(), livro);
		}
		Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
		
	}

	private static void handleRecebendoMenuOperador(String resposta) {
	    List<String> respostasvalidas = Arrays.asList("A", "B", "C", "D", "E", "a", "b", "c", "d", "e");
	    if (!respostasvalidas.contains(resposta)) {
	        return;
	    }
	    
	    resposta = resposta.toUpperCase();
	    switch (resposta) {
	        case "A":
	            Main.estado = Etapas.CADASTRANDO_LIVRO;
	            break;
	        case "B":
	            Main.estado = Etapas.EDITANDO_LIVRO;
	            break;
	        case "C":
	            Main.estado = Etapas.REMOVENDO_LIVRO;
	            break;
	        case "D":
	            Main.estado = Etapas.CADASTRAR_CLIENTE;
	            break;
	        case "E":
	            Main.estado = Etapas.REMOVER_CLIENTE;
	            break;
	        default:
	            break;
	    }
	}

	private static void handleColetandoLogin(String resposta) {
		String[] login = resposta.split(";");
		String username = login[0];
		String password = login[1];
		for (Usuario usuario: Main.biblioteca.getUsuarios()) {
			if (usuario.getUsername() != null && usuario.getUsername().equals(username)) {
				if (usuario.getSenha() != null && usuario.getSenha().equals(password)) {
					Main.logado = usuario;
				}
				break;
			}
		}
		if (Main.logado == null) {
			Main.estado = Etapas.PEDINDO_LOGIN;
			System.out.println("Usuario/Senha não coincidem");
			return;
		}
		if (Main.logado instanceof Operador) {
			Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
			return;
		}
		if (Main.logado instanceof Cliente) {
			Main.estado = Etapas.RECEBENDO_MENU_CLIENTE;
			return;
		}
		Main.estado = Etapas.RECEBENDO_MENU_CLIENTE;
		
	}

	private static void handlePedindoLogin(String resposta) {
		if ("A".equalsIgnoreCase(resposta)){
			Main.estado = Etapas.COLETANDO_LOGIN;
		}
	}
	
	private static void handleCadastrarCliente(String resposta) {
	    String[] content = resposta.split(";");
	    if (content.length != 6) {
	        System.out.println("Formato inválido para cadastro de cliente");
	        return;
	    }

	    String username = content[0];
	    String senha = content[1];
	    String nome = content[2];
	    String cpf = content[3];
	    String endereco = content[4];
	    String telefone = content[5];

	    for (Usuario usuario : Main.biblioteca.getUsuarios()) {
	        if (usuario.getUsername() != null && usuario.getUsername().equals(username)) {
	            System.out.println("Username já existe");
	            return;
	        }
	    }

	    Cliente novoCliente = new Cliente(username, senha, nome, cpf, endereco, telefone);
	    Main.biblioteca.getUsuarios().add(novoCliente);
	    System.out.println("Cliente cadastrado com sucesso");

	    Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
	}

	private static void handleRemoverCliente(String resposta) {
	    String username = resposta.trim();
	    
	    Usuario clienteParaRemover = null;
	    for (Usuario usuario : Main.biblioteca.getUsuarios()) {
	        if (usuario.getClass().equals(Cliente.class) && 
	            usuario.getUsername() != null && 
	            usuario.getUsername().equals(username)) {
	            clienteParaRemover = usuario;
	            break;
	        }
	    }

	    if (clienteParaRemover != null) {
	        Main.biblioteca.getUsuarios().remove(clienteParaRemover);
	        System.out.println("Cliente removido com sucesso");
	    } else {
	        System.out.println("Cliente não encontrado");
	    }

	    Main.estado = Etapas.RECEBENDO_MENU_OPERADOR;
	}

}
