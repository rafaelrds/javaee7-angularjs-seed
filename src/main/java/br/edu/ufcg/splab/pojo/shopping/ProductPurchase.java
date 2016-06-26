package br.edu.ufcg.splab.pojo.shopping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

@Entity
@Table(name = "TB_PRODUCT_PURCHASE")
@JsonInclude(Include.NON_EMPTY)
public class ProductPurchase implements Serializable {

	private static final long serialVersionUID = 2360518158136699157L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCT_PURCHASE")
	@SequenceGenerator(name = "SQ_PRODUCT_PURCHASE", sequenceName = "SQ_PRODUCT_PURCHASE", initialValue = 1, allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	@Column(name = "QUANTITY")
	private Long quantity;

	@ManyToOne
	private Purchase purchase;

	public ProductPurchase() {
	}

	public ProductPurchase(Product product) {
		this.product = product;
		this.quantity = 1L;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return Objects.toStringHelper(this).add("product", product).add("quantity", quantity)
				.toString();
	}
}
