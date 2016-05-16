package zttc.itat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_customer")
public class Customer {
	@GeneratedValue
	@Id
	private Integer customerNO;
	private String customerName;
	private String phone;
	private String address;
	private String relationman;
	private String otherInfo;
	@ManyToOne
	private Order order;
	@ManyToOne
	private Quotation quotation;

	public Integer getCustomerNO() {
		return customerNO;
	}
	public void setCustomerNO(Integer customerNO) {
		this.customerNO = customerNO;
	}
	
	@NotEmpty(message="客户名不能为空")
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRelationman() {
		return relationman;
	}
	public void setRelationman(String relationman) {
		this.relationman = relationman;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Quotation getQuotation() {
		return quotation;
	}
	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}
	
	
}
