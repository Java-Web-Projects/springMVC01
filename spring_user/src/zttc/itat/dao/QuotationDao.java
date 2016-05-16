package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Pager;
import zttc.itat.model.Quotation;
import zttc.itat.model.SystemContext;

@Repository("quotationDao")
public class QuotationDao extends HibernateDaoSupport implements IQuotationDao{
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	public void add(Quotation quotation) {
		this.getHibernateTemplate().save(quotation);
	}

	public void update(Quotation quotation) {
		this.getHibernateTemplate().update(quotation);
	}

	public void delete(int quotationNO) {
		Quotation quotation=this.load(quotationNO);
		this.getHibernateTemplate().delete(quotation);
	}

	public Quotation load(int quotationNO) {
		return this.getHibernateTemplate().load(Quotation.class, quotationNO);
		
	}

	@SuppressWarnings("unchecked")
	public List<Quotation> list() {
		return this.getSession().createQuery("from Quotation").list();
	}

	@SuppressWarnings("unchecked")
	public Pager<Quotation> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Quotation");  
		query.setFirstResult(offset).setMaxResults(size);
		List<Quotation> datas=query.list();
		Pager<Quotation> pqo=new Pager<Quotation>();
		pqo.setDatas(datas);
		pqo.setOffset(offset);
		pqo.setSize(size);
		
		long total = (Long)this.getSession()
				.createQuery("select count(*) from Quotation")
				.uniqueResult();
		pqo.setTotal(total);
		return pqo;
	}
}
