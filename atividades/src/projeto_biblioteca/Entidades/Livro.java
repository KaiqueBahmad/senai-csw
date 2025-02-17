package projeto_biblioteca.Entidades;

public class Livro {
	private static int contador = 1;
	
	long id;
	String titulo;
	String autor;
	int anoPub;
	int estoque;
	public Livro(String titulo, String autor, int anoPub, int estoque) {
		this.id = contador++;
		this.titulo = titulo;
		this.autor = autor;
		this.anoPub = anoPub;
		this.estoque = estoque;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (!Object.class.equals(this.getClass())) {
			return false;
		}
		Livro otherLivro = (Livro) obj;
		return this.titulo.equals(otherLivro.getTitulo())
			&& this.anoPub == otherLivro.getAnoPub()
			&& this.autor.equals(otherLivro.getAutor());
	}

	@Override
	public String toString() {
		return String.format("[%d] %s, %s em %d. Em estoque %d", id, titulo, autor, anoPub, estoque);
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public int getAnoPub() {
		return anoPub;
	}



	public void setAnoPub(int anoPub) {
		this.anoPub = anoPub;
	}



	public int getEstoque() {
		return estoque;
	}



	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	
	
}
