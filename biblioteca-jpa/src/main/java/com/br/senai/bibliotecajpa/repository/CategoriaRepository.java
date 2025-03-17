package com.br.senai.bibliotecajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.senai.bibliotecajpa.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
