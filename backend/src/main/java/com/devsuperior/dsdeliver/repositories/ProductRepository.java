package com.devsuperior.dsdeliver.repositories; //esse pacote implementa os objetos de acesso a dados relacionados a entidades 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product>findAllByOrderByNameAsc();
}
