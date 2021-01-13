package com.devsuperior.dsdeliver.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;

public class OrderDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private double latitude;
	private double longitude;
	private Instant moment;//para trabalhar com tempo
	private OrderStatus status;
	private Double total;
	
	//cada pedido ja vai trazer com ele os produtos
	
	private List<ProductDTO> products=new ArrayList<>();
	
	public OrderDTO() {
		
	}

	public OrderDTO(Long id, String address, double latitude,
			double longitude, Instant moment, OrderStatus status, double total) {
		
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		this.total=total;
	}
	
	public OrderDTO(Order entity) {
			
			id = entity.getId();
			address = entity.getAddress();
			latitude = entity.getLatitude();
			longitude = entity.getLatitude();
			moment = entity.getMoment();
			status = entity.getStatus();
			total= entity.getTotal();
			products=entity.getProducts().stream().map(x->new ProductDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

		
}
