package zttc.itat.dao;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.model.Quotation;

public interface IQuotationDao {
	public void add(Quotation quotation);
	public void update(Quotation quotation);
	public void delete(int quotationNO);
	public Quotation load(int quotationNO);
	public List<Quotation> list();
	public Pager<Quotation> find();
}
