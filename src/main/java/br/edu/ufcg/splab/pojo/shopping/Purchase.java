package br.edu.ufcg.splab.pojo.shopping;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

import br.edu.ufcg.splab.pojo.client.Client;

@Entity
@Table(name="TB_PURCHASE")
@JsonInclude(Include.NON_EMPTY)
public class Purchase implements Serializable {

	private static final long serialVersionUID = 8618382038798427368L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PURCHASE")
	@SequenceGenerator(name = "SQ_PURCHASE", sequenceName = "SQ_PURCHASE", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client purchaser;
	
	@OneToMany(mappedBy="purchase", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<ProductPurchase> products;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE", nullable=false)
	private Date date;
	
	public Purchase(){
		
	}

	public Purchase(Client client, Product ...products) {
		this.purchaser = client;
		for (Product product: products){
			ProductPurchase productPurchase = new ProductPurchase(product);
			this.addProductPurchase(productPurchase);
		}
	}

	public void addProductPurchase(ProductPurchase productPurchase) {
		if (this.products == null){
			this.products = new HashSet<>();
		}
		this.products.add(productPurchase);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Client purchaser) {
		this.purchaser = purchaser;
	}

	public Set<ProductPurchase> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductPurchase> products) {
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@PrePersist
	public void setUpDate(){
		this.date = Calendar.getInstance().getTime();
	}
	
	public String toString(){
		return Objects.toStringHelper(this).add("client", purchaser).add("date", date).add("items", products)
				.toString();
	}
}
