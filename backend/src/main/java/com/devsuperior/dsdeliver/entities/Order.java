package com.devsuperior.dsdeliver.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_order")//nome da tabela no banco
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//diz para o JPA que o id será uma chave primaria autoincrementada
	private Long id;
	private String address;
	private double latitude;
	private double longitude;
	private Instant moment;//para trabalhar com tempo
	private OrderStatus status;
	private double total;
	
	//para representar a associação de um pedido tendo 1 ou varios produtos e criado uma coleção. 
	//na regra de negocio não adimite um produto sendo repetido em um mesmo pedido, por isso usou-se o Set, por não aceitar repetição
	
	@ManyToMany
	@JoinTable(name="tb_order_product",
		joinColumns=@JoinColumn(name="order_id"), 	 //chave estrangeira que fererencia a tabela tb_order
		inverseJoinColumns = @JoinColumn(name="product_id"))
	
	private Set<Product>products= new HashSet<>();
	
	public Order () {
		
	}
	//NAO SE COLOCA COLEÇÕES EM CONSTRUTORES
	public Order(Long id, String address, double latitude, double longitude, Instant moment, OrderStatus status,
			double total) {
		super();
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
		this.total = total;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	public Set<Product> getProducts() {
		return products;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
