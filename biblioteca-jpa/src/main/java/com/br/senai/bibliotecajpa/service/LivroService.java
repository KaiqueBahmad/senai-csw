package com.br.senai.bibliotecajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.senai.bibliotecajpa.model.Livro;
import com.br.senai.bibliotecajpa.repository.LivroRepository;

import java.util.List;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Integer id) {
        return this.livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro nao encontrado"));
    }

    public Livro save(Livro livro) {
    	validaLivro(livro);
        return this.livroRepository.save(livro);
    }

    public void delete(Integer id) {
        this.livroRepository.deleteById(id);
    }

    public Livro update(Livro livro) {
    	validaLivro(livro);
        return this.save(livro);
    }
    
    public void validaLivro(Livro livro) {
    	 if (livro == null) {
             throw new IllegalArgumentException("Livro não pode ser nulo");
         }
         
         if (livro.getEditora() == null || livro.getEditora().trim().isEmpty()) {
             throw new IllegalArgumentException("Preencha o campo Editora");
         }
         
         if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
             throw new IllegalArgumentException("Preencha o campo Título");
         }
         
         if (livro.getIsbn() == null || livro.getIsbn().trim().isEmpty()) {
             throw new IllegalArgumentException("Preencha o campo ISBN");
         }
         
         if (!isValidIsbnFormat(livro.getIsbn())) {
             throw new IllegalArgumentException("ISBN inválido: " + livro.getIsbn());
         }
    }

    public boolean isValidIsbnFormat(String isbn) {
        if (isbn == null) {
            return false;
        }
        
        isbn = isbn.trim();
        
        Pattern isbnPattern10 = Pattern.compile("^\\d-\\d{3}-\\d{5}-[\\dX]$");
        Pattern isbnPattern13 = Pattern.compile("^\\d{3}-\\d-\\d{3}-\\d{5}-\\d$");
        Pattern isbnPatternNoHyphens = Pattern.compile("^\\d{9}[\\dX]$|^\\d{13}$");
        if (isbnPattern10.matcher(isbn).matches() || isbnPattern13.matcher(isbn).matches() || isbnPatternNoHyphens.matcher(isbn).matches()) {
        	return true;
        }
        return false;
    }

}
