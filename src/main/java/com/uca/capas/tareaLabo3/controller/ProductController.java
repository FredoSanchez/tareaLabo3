package com.uca.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo3.domain.Product;

@Controller
public class ProductController {
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/productos")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "Megaminx", 25));
		productos.add(new Product(1, "Fisher", 18));
		productos.add(new Product(2, "Pyraminx", 50));
		productos.add(new Product(3, "Mastermorphix", 6));
		productos.add(new Product(4, "Square One", 69));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("productos", productos);

		return mav;	
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public String validar(Product product) {
		return productos.get(product.getId()).getNombre();		
	}
}
