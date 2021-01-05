package com.devsuperior.dsdeliver.repositories; //esse pacote implementa os objetos de acesso a dados relacionados a entidades 

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
