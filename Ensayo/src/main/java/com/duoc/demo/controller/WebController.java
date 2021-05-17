package com.duoc.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.duoc.demo.model.Categoria;
import com.duoc.demo.model.Producto;
import com.duoc.demo.repository.ICategoriaRepository;
import com.duoc.demo.repository.IProductoRepository;

@Controller
public class WebController {
	@Autowired
	private IProductoRepository pro;
	@Autowired
	private ICategoriaRepository cat;
	
	@ModelAttribute
	public Producto setProducto() {
		return new Producto();
	}
	
	@ModelAttribute
	public Categoria setCategoria() {
		return new Categoria();
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("cat", cat.findAll());
		model.addAttribute("productos", pro.findAll());
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Model model) {
		model.addAttribute("categorias", cat.findAll());
		return "agregar";
	}
	
	@GetMapping("/agregarC")
	public String agregarCategoria() {
		return "agregarCategoria";
	}
	
	@GetMapping("/editar")
	public String editar(Model model) {
		model.addAttribute("categorias", cat.findAll());
		model.addAttribute("productos", pro.findAll());
		return "editar";
	}
	
	@PostMapping("/registrarProducto")
	public String agregarProducto(@Valid @ModelAttribute ("producto")Producto p, BindingResult br, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("categorias", cat.findAll());
			return "agregar";
		}else {
			pro.save(p);
			return "exito";
		}
	}
	
	@PostMapping("/registrarCategoria")
	public String agregarCategoria(@Valid @ModelAttribute ("categoria")Categoria c, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "agregarCategoria";
		} else {
			cat.save(c);
			return "exito";
		}
	}
	
	@PostMapping("/modificarProducto")
	public String modificarProducto(@Valid @ModelAttribute("producto")Producto p, BindingResult br, Model model) {
		if(br.hasErrors()) {
			model.addAttribute("categorias", cat.findAll());
			return "modificar";
		} else {
			pro.save(p);
			return "exito";
		}
	}
	
	@PostMapping("/eliminarProducto")
	public String eliminarProducto(String id, Model model) {
		pro.deleteById(Integer.parseInt(id));
		model.addAttribute("productos", pro.findAll());
		return "exito";
	}
}
