package com.br.senai.bibliotecajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.senai.bibliotecajpa.model.Categoria;
import com.br.senai.bibliotecajpa.model.Livro;
import com.br.senai.bibliotecajpa.repository.CategoriaRepository;

import java.util.List;

import javax.management.RuntimeErrorException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        return this.categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria nao encontrado"));
    }

    public Categoria save(Categoria categoria) {
    	validaCategoria(categoria);
        return this.categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        this.categoriaRepository.deleteById(id);
    }
    
    public Categoria addLivroCategoria(Categoria categoria, Livro livro) {
    	categoria.getLivros().add(livro);
    	livro.setCategoria(categoria);
    	return this.save(categoria);
    }
    
    public Categoria update(Categoria categoria) {
    	validaCategoria(categoria);
        return this.save(categoria);
    }
    
    public void validaCategoria(Categoria categoria) {
    	if (categoria.getNome() == null) {
    		throw new RuntimeErrorException(null, "Preencha o campo Nome");
    	}
    }

}
