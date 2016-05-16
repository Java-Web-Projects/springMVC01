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
@Table(name="t_quotation")
public class Quotation {
	
	@GeneratedValue
	@Id
	private int quotationNO;
	private String quotationMan;
//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date quotationTime;
	private String otherInfo;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="productNO")
	private Product product;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="customerNO")
	private Customer customer;
	
//	@OneToMany(targetEntity=Product.class,mappedBy = "quotation")

/*	@OneToMany(mappedBy = "quotation")
	private List<Product> products;
*/	
//	@OneToMany(targetEntity=Customer.class,mappedBy = "quotation")

/*	@OneToMany(mappedBy = "quotation")
	private List<Customer> customers;
*/	

	
	
	public int getQuotationNO() {
		return quotationNO;
	}
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
	public void setQuotationNO(int quotationNO) {
		this.quotationNO = quotationNO;
	}
	
	public String getQuotationMan() {
		return quotationMan;
	}
	public void setQuotationMan(String quotationMan) {
		this.quotationMan = quotationMan;
	}
	public Date getQuotationTime() {
		return quotationTime;
	}
	public void setQuotationTime(Date quotationTime) {
		this.quotationTime = quotationTime;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

/*	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
*/	
	
	
	
	
}
