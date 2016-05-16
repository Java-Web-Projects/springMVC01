package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Pager;
import zttc.itat.model.Product;
import zttc.itat.model.SystemContext;

@Repository("productDao")
public class ProductDao extends HibernateDaoSupport implements IProductDao {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	
	public void add(Product product) {
		this.getHibernateTemplate().save(product);
	}

	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

	public void delete(Integer productNO) {
		Product product=this.load(productNO);
		this.getHibernateTemplate().delete(product);
	}

	public Product load(Integer productNO) {
		return this.getHibernateTemplate().load(Product.class, productNO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return this.getSession().createQuery("from Product").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Product> find() {
		
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Product");  
		query.setFirstResult(offset).setMaxResults(size);
		List<Product> datas=query.list();
		Pager<Product> pro=new Pager<Product>();
		pro.setDatas(datas);
		pro.setOffset(offset);
		pro.setSize(size);
		
		long total = (Long)this.getSession()
				.createQuery("select count(*) from Product")
				.uniqueResult();
		pro.setTotal(total);
		return pro;
	}

	@Override
	public Product loadByProname(String proname) {
		return (Product)this.getSession().createQuery("from Product where proname=?").setParameter(0, proname).uniqueResult();
	}

}
