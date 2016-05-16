package zttc.itat.dao;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.model.Product;

public interface IProductDao {
	public void add(Product product);
	public void update(Product product);
	public void delete(Integer productNO);
	public Product load(Integer productNO);
	public List<Product> list();
	public Pager<Product> find();
	public Product loadByProname(String proname);
}