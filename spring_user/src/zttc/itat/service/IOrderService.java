package zttc.itat.service;

import java.util.List;

import zttc.itat.model.Order;
import zttc.itat.model.Pager;

public interface IOrderService {
	public void add(Order order);
	public void update(Order order);
	public void delete(int orderNO);
	public Order load(int orderNO);
	public List<Order> list();
//	public List<Order> findByProNO(int productNO);
	public Pager<Order> find();
}
