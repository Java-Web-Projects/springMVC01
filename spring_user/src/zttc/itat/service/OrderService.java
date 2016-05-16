package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IOrderDao;
import zttc.itat.model.Order;
import zttc.itat.model.Pager;

@Service("orderService")
public class OrderService implements IOrderService{
	private IOrderDao orderDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}
	
	@Resource
	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void add(Order order) {
		orderDao.add(order);
	}

	public void update(Order order) {
		orderDao.update(order);
	}

	public void delete(int orderNO) {
		orderDao.delete(orderNO);
	}

	public Order load(int orderNO) {
		return orderDao.load(orderNO);
	}

	public List<Order> list() {
		return orderDao.list();
	}

/*	public List<Order> findByProNO(int productNO) {
		return orderDao.loadByProNO(productNO);
	}
*/
	public Pager<Order> find() {
		return orderDao.find();
	}
	
	
}
