package zttc.itat.web;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.Customer;
import zttc.itat.model.Order;
import zttc.itat.model.Product;
import zttc.itat.service.ICustomerService;
import zttc.itat.service.IOrderService;
import zttc.itat.service.IProductService;

@Controller
@RequestMapping("/order")
public class OrderController {

	private IOrderService orderService;
	private IProductService productService;
	private ICustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
		binder.registerCustomEditor(Customer.class, new CustomerEditor(customerService));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
	
	public ICustomerService getCustomerService() {
		return customerService;
	}
	@Resource
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public IProductService getProductService() {
		return productService;
	}
	
	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public IOrderService getOrderService() {
		return orderService;
	}
	@Resource
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value={"/orders","/"},method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers", orderService.find());
//		model.addAttribute("products", productService.list());
		return "order/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new Order());
	
		model.addAttribute("products",productService.find());
		model.addAttribute("customers",customerService.find());
		return "order/add";
	}
	
//	@SuppressWarnings("unused")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add( @Validated Order order,BindingResult br){
/*		if(br.hasErrors()) {
			return "order/add"; 
		}
*/		
		
		System.out.println("we are here");
		
		orderService.add(order);
		return "redirect:/order/orders";
	}
	
	@RequestMapping(value="/{orderNO}",method=RequestMethod.GET)
	public String show(@PathVariable int orderNO,Model model){
		model.addAttribute( orderService.load(orderNO));
		return "order/show";
	}
	
	@RequestMapping(value="/{orderNO}/update",method=RequestMethod.GET)
	public String update(@PathVariable int orderNO,Model model){
		model.addAttribute(orderService.load(orderNO));
		model.addAttribute("productss",productService.find());
		model.addAttribute("customerss",customerService.find());
		return "order/update";
	}
	
	@RequestMapping(value="/{orderNO}/update",method=RequestMethod.POST)
	public String update(@PathVariable int orderNO,@Validated Order order,BindingResult br,Model model){
/*		if(br.hasErrors()) {
			return "order/update";
		}
*/
		Order od=orderService.load(orderNO);
		od.setOtherInfo(order.getOtherInfo());
		od.setQuantity(order.getQuantity());
		od.setProduct(order.getProduct());
		od.setCustomer(order.getCustomer());
		od.setOrderTime(order.getOrderTime());
		orderService.update(od);
		return "redirect:/order/orders";
	}
	
	@RequestMapping(value="/{orderNO}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int orderNO){
		orderService.delete(orderNO);
		return "redirect:/order/orders";
	}
}
