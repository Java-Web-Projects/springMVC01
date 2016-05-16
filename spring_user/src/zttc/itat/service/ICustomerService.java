package zttc.itat.service;

import java.util.List;

import zttc.itat.model.Customer;
import zttc.itat.model.Pager;

public interface ICustomerService {
	public void add(Customer customer);
	public void update(Customer customer);
	public void delete(Integer customerNO);
	public Customer load(Integer customerNO);
	public List<Customer> list();
	public Pager<Customer> find();
}
