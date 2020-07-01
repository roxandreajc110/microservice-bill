package com.hiberus.microservice.bill.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hiberus.microservice.bill.util.Constants;

import io.swagger.annotations.ApiModelProperty;

/**
 * Business entity Product.
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */

@Entity
@Table
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ApiModelProperty(value = "Id Product", name = "id", dataType = "Long", example = "strategy = GenerationType.IDENTITY")
	private Long id;

	@NotBlank(message = "Name" + Constants.MSN_VALID_NULL)
	@Size(max = 120, message = Constants.MSN_VALID_LENGTH + " 120 characters.")
	@Column(nullable = false, length = 120)
	@ApiModelProperty(value = "Product Name", name = "name", dataType = "String", example = "Artesania Importada")
	private String name;

	@NotBlank(message = "Description product" + Constants.MSN_VALID_NULL)
	@Size(max = 150, message = Constants.MSN_VALID_LENGTH + " 150 characters.")
	@Column(nullable = false, length = 150)
	@ApiModelProperty(value = "Product Description", name = "productDescription", dataType = "String", example = "Artesania Importada de medidas 20x20cm en madera")
	private String productDescription;

	@NotNull(message = "Price product" + Constants.MSN_VALID_NULL)
	@Column(nullable = false, length = 10)
	@ApiModelProperty(value = "Price product", name = "price", dataType = "Long", example = "185000")
	private Long price;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
