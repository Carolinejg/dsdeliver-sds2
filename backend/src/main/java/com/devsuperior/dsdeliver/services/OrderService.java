package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service // a classe vai ser um componente injetavel qe podera ser ingetados em outros componentes 
public class OrderService {
	
	@Autowired 
	private OrderRepository repository;
	

	@Autowired 
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)//somente operaçâo de leitura
	public List<OrderDTO> findAll() //buscar os produtos do banco de dados usando repository
	{
		List<Order>list=repository.findOrdersWithProducts();
		return list.stream().map(x->new OrderDTO(x)).collect(Collectors.toList());//aplica a funçâo para todas os objetos da lista. E dps reconverte para a lista
	}
	
	@Transactional   //inserir um pedido no bd
	public OrderDTO insert(OrderDTO dto) //buscar os produtos do banco de dados usando repository, O dto contem todos os dados do pedido
	//e os produtos desse pedido.
	{
		//salvando obj no bd
		Order order=new Order(null,dto.getAddress(),dto.getLatitude(),dto.getLongitude(),Instant.now(),OrderStatus.PENDING);//instancia um pedido
		
		//associar pedidos com produtos
		for(ProductDTO p: dto.getProducts())//percorrendo todos os ProductDTO
		{
			Product product = productRepository.getOne(p.getId());//intancia um produto com base no id do p
			order.getProducts().add(product);
		}
		//salvando os produtos no banco
		order=repository.save(order);
		return new OrderDTO(order);
		
	}
	
	@Transactional   
	public OrderDTO setDelivered(Long id)//alterando um pedido
	{
		
		Order order=repository.getOne(id);//intanciou o pedido 
		order.setStatus(OrderStatus.DELIVERED);
		order=repository.save(order);
		return new OrderDTO(order);
		
	}
}
