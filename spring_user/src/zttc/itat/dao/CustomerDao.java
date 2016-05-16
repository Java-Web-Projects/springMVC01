package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Customer;
import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;

@Repository("customerDao")
public class CustomerDao extends HibernateDaoSupport implements ICustomerDao{

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}

	@Override
	public void delete(Integer customerNO) {
		Customer customer=this.load(customerNO);
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer load(Integer customerNO) {
		return this.getHibernateTemplate().load(Customer.class,customerNO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> list() {
		
		return this.getSession().createQuery("from Customer").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Customer> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Customer");
		query.setFirstResult(offset).setMaxResults(size);
		List<Customer> datas=query.list();
		Pager<Customer> cus=new Pager<Customer>();
		cus.setDatas(datas);
		cus.setSize(size);
		cus.setOffset(offset);
		long total=(Long)this.getSession()
				.createQuery("select count(*) from Customer")
				.uniqueResult();
		cus.setTotal(total);
		return cus;
	}

	@Override
	public Customer loadByUsername(String customerName) {
		return (Customer)this.getSession().createQuery("from Customer where customerName=?").setParameter(0, customerName).uniqueResult();
		
	}

}
