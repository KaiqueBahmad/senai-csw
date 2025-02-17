package projeto_biblioteca.Interface;

import projeto_biblioteca.Entidades.Biblioteca;
import projeto_biblioteca.Entidades.Operador;
import projeto_biblioteca.Entidades.Usuario;

public class Main {
	
	public static Biblioteca biblioteca = new Biblioteca("Minha Biblioteca");
	public static Usuario logado = null;
	public static Etapas estado;
	
	public static void main(String[] args) {
        estado = Etapas.PEDINDO_LOGIN;
        biblioteca.getUsuarios().add(new Operador("operador", "123"));
        while (true) {
            System.out.println("------------------------------");
            String resposta = "";
            if (estado == Etapas.PEDINDO_LOGIN) {
                resposta = Perguntas.pedirLogin();
            } else if (estado == Etapas.COLETANDO_LOGIN) {
                resposta = Perguntas.coletarLogin();
            } else if (estado == Etapas.RECEBENDO_MENU_OPERADOR || estado == Etapas.RECEBENDO_MENU_CLIENTE) {
                resposta = Perguntas.mostrarMenu();
            } else if (estado == Etapas.CADASTRANDO_LIVRO) {
                resposta = Perguntas.cadastrarLivro();
            } else if (estado == Etapas.EDITANDO_LIVRO) {
                resposta = Perguntas.editarLivro();
            } else if (estado == Etapas.CADASTRAR_CLIENTE) {
                resposta = Perguntas.cadastrarCliente();
            } else if (estado == Etapas.REMOVER_CLIENTE) {
                resposta = Perguntas.removerCliente();
            } else if (estado == Etapas.LOCAR_LIVRO) {
                resposta = Perguntas.locarLivro();
            } else if (estado == Etapas.DEVOLVER_LIVRO) {
                resposta = Perguntas.devolverLivro();
            }
            Controlador.processarResposta(resposta);
        }
    }
}
