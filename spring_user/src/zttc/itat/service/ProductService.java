package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IProductDao;
import zttc.itat.model.Pager;
import zttc.itat.model.Product;
import zttc.itat.model.ProductException;

@Service("productService")
public class ProductService implements IProductService {

	private IProductDao productDao;
	
	
	public IProductDao getProductDao() {
		return productDao;
	}
	
		
	@Resource
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	public void add(Product product) {
		Product pro=productDao.loadByProname(product.getProname());
		if(pro!=null) throw new ProductException("this product is already exist");
		productDao.add(product);
	}

	public void update(Product product) {
		productDao.update(product);
	}

	public void delete(Integer productNO) {
		productDao.delete(productNO);
	}

	public Product load(Integer productNO) {
		return productDao.load(productNO);
	}

	public List<Product> list() {
		return productDao.list();
	}

	public Pager<Product> find() {
		return productDao.find();
	}

}
