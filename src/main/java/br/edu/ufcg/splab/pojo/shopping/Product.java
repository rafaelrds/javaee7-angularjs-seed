package br.edu.ufcg.splab.pojo.shopping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

@Entity
@Table(name = "TB_PRODUCT")
@JsonInclude(Include.NON_EMPTY)
public class Product implements Serializable {

	private static final long serialVersionUID = 7543047500879074596L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCT")
	@SequenceGenerator(name = "SQ_PRODUCT", sequenceName = "SQ_PRODUCT", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "IMG_LINK", nullable = false)
	private String imageLink;

	@Column(name = "PRODUCT_VALUE", nullable = false, precision = 10, scale = 2)
	private Double value;

	public Product() {
	}

	public Product(String name, String description, String imageLink, Double value) {
		this.name = name;
		this.description = description;
		this.imageLink = imageLink;
		this.value = value;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("name", name).add("description", description)
				.add("imageLink", imageLink).add("value", value).toString();
	}
}
