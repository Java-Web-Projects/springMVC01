package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.ICustomerDao;
import zttc.itat.model.AppException;
import zttc.itat.model.Customer;
import zttc.itat.model.Pager;

import zttc.itat.service.ICustomerService;

@Service("customerService")
public class CustomerService implements ICustomerService{

	private ICustomerDao customerDao;
	
	@Resource
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public ICustomerDao getCustomerDao(){
		return customerDao;
	}
	
	
	public void add(Customer customer) {
		Customer cus=customerDao.loadByUsername(customer.getCustomerName());
		if(cus!=null) throw new AppException("customer name can't be empty!");{
			customerDao.add(customer);
		}
	}

	public void update(Customer customer) {
		customerDao.update(customer);
	}

	public void delete(Integer customerNO) {
		customerDao.delete(customerNO);
	}

	public Customer load(Integer customerNO) {
		return customerDao.load(customerNO);
	}

	public List<Customer> list() {
		return customerDao.list();
	}

	public Pager<Customer> find() {
		return customerDao.find();
	}

}
