package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service // a classe vai ser um componente injetavel qe podera ser ingetados em outros componentes 
public class OrderService {
	
	@Autowired 
	private OrderRepository repository;
	
	@Transactional(readOnly = true)//somente operaçâo de leitura
	public List<OrderDTO> findAll() //buscar os produtos do banco de dados usando repository
	{
		List<Order>list=repository.findAll();
		return list.stream().map(x->new OrderDTO(x)).collect(Collectors.toList());//aplica a funçâo para todas os objetos da lista. E dps reconverte para a lista
	}
}
