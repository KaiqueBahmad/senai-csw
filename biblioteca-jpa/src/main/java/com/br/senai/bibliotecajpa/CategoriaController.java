package com.br.senai.bibliotecajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LivroService livroService;
    
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }
    
    @PostMapping("/{idCategoria}/add-livro/{idLivro}")
    public List<Integer> addLivroNaCategoria(
		@PathVariable Integer idCategoria,
		@PathVariable Integer idLivro
	) {
    	List<Integer> livroIds= new LinkedList<Integer>();
    	Set<Livro> livros = this.categoriaService.addLivroCategoria(
			this.categoriaService.findById(idLivro),
			this.livroService.findById(idLivro)
		).getLivros();
    	for (Livro livro: livros) {
    		livroIds.add(livro.getId());
    	}
    	return livroIds;
    }
    
    @PostMapping("/descategorizar/{idLivro}")
    public Livro addLivroNaCategoria(
		@PathVariable Integer idLivro
	) {
    	Livro livro = this.livroService.findById(idLivro);
    	livro.setCategoria(null);
    	return this.livroService.save(livro);
    }
    
    @PostMapping
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping
    public Categoria updateCategoria(Categoria categoria) {
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        this.categoriaService.delete(id);
    }
}
