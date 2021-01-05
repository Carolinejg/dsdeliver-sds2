package com.devsuperior.dsdeliver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_product")//nome da tabela no banco
public class Product implements Serializable{//a anotaçâo entity diz que essa classe é uma entidade que será tranformada em tabela
	private static final long serialVersionUID = 1L;//implementação da classe e da versao 1
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//diz para o JPA que o id será uma chave primaria autoincrementada 
	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	public Product() {
		
	}

	public Product(Long id, String name, Double price, String description, String imgUri) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imgUri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUri() {
		return imageUri;
	}

	public void setImgUri(String imgUri) {
		this.imageUri = imgUri;
	}

	//IMPLEMENTAÇÂO PADRÃO PARA COMPARAR UM OBJETO COM OUTRO
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	//IMPLEMENTAÇÂO PADRÃO PARA COMPARAR UM OBJETO COM OUTRO
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
