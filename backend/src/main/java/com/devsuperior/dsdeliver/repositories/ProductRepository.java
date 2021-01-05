package com.devsuperior.dsdeliver.repositories; //esse pacote implementa os objetos de acesso a dados relacionados a entidades 

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
