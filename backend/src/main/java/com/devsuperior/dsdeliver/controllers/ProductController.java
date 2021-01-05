package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value="/products") //define o caminho do recurso get
public class ProductController {//sera o controlador rest

	//um end point para responder pelo caminho acima
	
	@Autowired
	private ProductService service;
	
	//criando um end point 
	
	@GetMapping//metodo de endpoint para o http
	public ResponseEntity<List<ProductDTO>>findAll()//encapisula a resposta de um http
	{
		List<ProductDTO> list=service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
}
