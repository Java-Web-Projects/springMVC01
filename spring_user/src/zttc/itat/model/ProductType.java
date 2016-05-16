package zttc.itat.model;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_producttype")
public class ProductType {
	
	@GeneratedValue
	@Id
	private int producttypeNO;
	private String producttypeName;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="productNO")
	private Product product;
	
//	@OneToMany(targetEntity=Product.class,mappedBy = "productType") 

/*    @OneToMany(mappedBy = "productType")
	private List<Product> prodocts;
*/
	
	
	
	public int getProducttypeNO() {
		return producttypeNO;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setProducttypeNO(int producttypeNO) {
		this.producttypeNO = producttypeNO;
	}
	public String getProducttypeName() {
		return producttypeName;
	}
	public void setProducttypeName(String producttypeName) {
		this.producttypeName = producttypeName;
	}

/*	public List<Product> getProdocts() {
		return prodocts;
	}
	public void setProdocts(List<Product> prodocts) {
		this.prodocts = prodocts;
	}
*/	
	
}
