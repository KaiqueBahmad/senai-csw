package com.br.senai.bibliotecajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.senai.bibliotecajpa.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	List<Livro> findByCategoriaId(Integer id);
}
