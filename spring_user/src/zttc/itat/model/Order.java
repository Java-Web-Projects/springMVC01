package zttc.itat.model;

import java.util.Date;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_order")
public class Order {
	
	@GeneratedValue
	@Id
	private int orderNO;
	
//	@OneToMany(targetEntity=Customer.class,mappedBy = "order")
	
/*	@OneToMany(mappedBy = "order")
	private List<Customer> customers;
*/
	
//	@OneToMany(targetEntity=Product.class,mappedBy = "order")
	
/*	@OneToMany(mappedBy = "order")
	private List<Product> products;
*/
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="productNO")
	private Product product;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="customerNO")
	private Customer customer;
	
	private int quantity;
//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderTime;
	private String otherInfo;
	
	public int getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(int orderNO) {
		this.orderNO = orderNO;
	}
	
	
	
/*public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}*/
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/*
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
*/
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	
	
}
