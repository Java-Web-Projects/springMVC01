package zttc.itat.service;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.model.Product;

public interface IProductService {
	public void add(Product product);
	public void update(Product product);
	public void delete(Integer productNO);
	public Product load(Integer productid);
	public List<Product> list();
	public Pager<Product> find();
}
