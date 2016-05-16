package zttc.itat.dao;

import java.util.List;

import zttc.itat.model.Order;
import zttc.itat.model.Pager;

public interface IOrderDao {
	public void add(Order order);
	public void update(Order order);
	public void delete(int orderNO);
	public Order load(int orderNO);
	public List<Order> list();
	public Pager<Order> find();
	
//	public Order loadByProNO(int productNO);
}
