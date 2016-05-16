package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Order;
import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;
@Repository("orderDao")
public class OrderDao extends HibernateDaoSupport implements IOrderDao{
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	public void add(Order order) {
		this.getHibernateTemplate().save(order);
	}

	public void update(Order order) {
		this.getHibernateTemplate().update(order);
	}

	public void delete(int orderNO) {
		Order order=this.load(orderNO);
		this.getHibernateTemplate().delete(order);
	}

	public Order load(int orderNO) {
		return this.getHibernateTemplate().load(Order.class, orderNO);
	}

	@SuppressWarnings("unchecked")
	public List<Order> list() {
		return this.getSession().createQuery("from Order").list();
	}

	@SuppressWarnings("unchecked")
	public Pager<Order> find() {
		
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Order");
		query.setFirstResult(offset).setMaxResults(size);
		List<Order> datas = query.list();
		Pager<Order> os = new Pager<Order>();
		os.setDatas(datas);
		os.setOffset(offset);
		os.setSize(size);
		
		long total = (Long)this.getSession()
				.createQuery("select count(*) from Order")
				.uniqueResult();
	os.setTotal(total);
	return os;
		
		
	}

/*	@SuppressWarnings("unchecked")
	@Override
	public List<Order> loadByProNO(int productNO) {
		Query query=this.getSession().createQuery("from Order where productNO=?");
		query.setLong(0, productNO);
		List<Order> orders=query.list();
		return orders;
	}
*/	
	

}
