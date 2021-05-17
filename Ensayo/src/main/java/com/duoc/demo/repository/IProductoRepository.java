package com.duoc.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.duoc.demo.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

	@Query(value="select * from producto p where p.categoria = ?1", nativeQuery = true)
	List<Producto> findAllByCategoria(Integer categoria);
	
}
