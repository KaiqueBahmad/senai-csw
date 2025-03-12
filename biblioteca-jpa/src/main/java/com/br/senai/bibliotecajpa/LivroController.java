package com.br.senai.bibliotecajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Integer id) {
        return livroService.findById(id);
    }

    @PostMapping
    public Livro saveLivro(Livro livro) {
        return livroService.save(livro);
    }

    @PutMapping
    public Livro updateLivro(Livro livro) {
        return livroService.update(livro);
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Integer id) {
        this.livroService.delete(id);
    }
}
