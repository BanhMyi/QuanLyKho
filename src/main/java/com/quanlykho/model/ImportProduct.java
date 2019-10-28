package com.quanlykho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "import_product")

public class ImportProduct {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "id")
		private Integer id;
	 	@Column(name = "number")
		private Integer number;

	 	@Column(name = "date_update")
		private String dateUpdate;

        @Column(name = "price")
        @NotNull
        private Double price;

	     @ManyToOne(fetch = FetchType.LAZY)
	     @JoinColumn(name = "user_id", nullable = false)
	    private Employee employee;
	     public Employee getEmployee() {
	         return employee;
	     }

	     @ManyToOne(fetch = FetchType.LAZY)
	     @JoinColumn(name = "product_id", nullable = false)
		    private Product product;
		     public Product getProduct() {
		         return product;
		     }

		public ImportProduct(Integer number, String dateUpdate, Employee employee, Product product, Double price) {
				this.number = number;
				this.dateUpdate = dateUpdate;
				this.employee = employee;
				this.product = product;
				this.price = price;
			}

		public ImportProduct() {
		}

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getNumber() {
			return number;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}

	 	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
