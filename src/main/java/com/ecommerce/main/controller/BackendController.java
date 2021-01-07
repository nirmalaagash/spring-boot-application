package com.ecommerce.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.main.model.Product;
import com.ecommerce.main.repo.ProductRepo;

@Controller
public class BackendController {
	
	@Autowired
	ProductRepo pRepo;
	
	@RequestMapping("")
	public String checkPage() {
		return "header";
	}
	
	@RequestMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("products")
	@ResponseBody
	public  List<Product> getProducts() {
		System.out.println("Fetching products..");
		return pRepo.findAll();
	}
	
	@GetMapping("products/{pid}")
	@ResponseBody
	public Optional<Product> getProduct(@PathVariable(name = "pid") String pid) {
		System.out.println("Getting product details..");
		return pRepo.findById(pid);
	}
	
	@PostMapping("products")
	@ResponseBody
	public Product addProduct(@RequestBody Product product) {
		System.out.println("Adding a product..");
		pRepo.save(product);
		return product;
	}
	
	@PutMapping("products/{pid}")
	@ResponseBody
	public Optional<Product> updateProduct(@PathVariable("pid") String pid, @RequestBody Product product) {
		System.out.println("Updating product value..");
		product.setId(pid);
		pRepo.save(product);
		return pRepo.findById(pid);
	}
}
