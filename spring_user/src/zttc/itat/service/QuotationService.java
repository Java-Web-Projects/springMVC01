package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IQuotationDao;
import zttc.itat.model.Pager;
import zttc.itat.model.Quotation;

@Service("quotationService")
public class QuotationService implements IQuotationService{

	private IQuotationDao quotationDao;
	
	public IQuotationDao getQuotationDao() {
		return quotationDao;
	}
	@Resource
	public void setQuotationDao(IQuotationDao quotationDao) {
		this.quotationDao = quotationDao;
	}

	public void add(Quotation quotation) {
		quotationDao.add(quotation);
	}

	public void update(Quotation quotation) {
		quotationDao.update(quotation);
	}

	public void delete(int quotationNO) {
		quotationDao.delete(quotationNO);
	}

	public Quotation load(int quotationNO) {
		return quotationDao.load(quotationNO);
	}

	public List<Quotation> list() {
		return quotationDao.list();
	}

	public Pager<Quotation> find() {
		return quotationDao.find();
	}

}
