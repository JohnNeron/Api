package com.duoc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.demo.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
