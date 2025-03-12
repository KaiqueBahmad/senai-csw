package com.br.senai.bibliotecajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.livroRepository.save(livro);
    }

    public void delete(Integer id) {
        this.livroRepository.deleteById(id);
    }

    public Livro update(Livro livro) {
        return this.save(livro);
    }

}
