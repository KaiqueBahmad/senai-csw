package com.br.senai.bibliotecajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	List<Livro> findByCategoriaId(Integer id);
}
