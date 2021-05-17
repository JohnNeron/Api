package com.duoc.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.demo.model.Producto;
import com.duoc.demo.repository.IProductoRepository;

@RestController
@CrossOrigin(originPatterns = "*")
public class ApiController {
	@Autowired
	private IProductoRepository pro;
	
	@GetMapping
	@RequestMapping("/productos")
	public List<Producto> listarProductos() {
		return pro.findAll();
	}
	
	@GetMapping
	@RequestMapping("/productos/{id]")
	public Optional<Producto> buscarProducto(@PathVariable("id") int id) {
		return pro.findById(id);
	}
	
	@GetMapping
	@RequestMapping("/productos/categoria/{id}")
	public List<Producto> buscarProductoPorCategoria(@PathVariable("id") int id) {
		return pro.findAllByCategoria(id);
	}
}
