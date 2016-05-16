package zttc.itat.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.Customer;
import zttc.itat.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private ICustomerService customerService;

	public ICustomerService getCustomerService() {
		return customerService;
	}

	@Resource
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value={"/customers","/"},method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers", customerService.find());
		return "customer/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new Customer());
		return "customer/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Customer customer,BindingResult br){
		if(br.hasErrors()) {
			return "customer/add";
		}
		customerService.add(customer);
		return "redirect:/customer/customers";
	}
	
	@RequestMapping(value="/{customerNO}",method=RequestMethod.GET)
	public String show(@PathVariable Integer customerNO,Model model) {
		model.addAttribute(customerService.load(customerNO));
		return "customer/show";
	}
	
	@RequestMapping(value="/{customerNO}/update",method=RequestMethod.GET)
	public String update(@PathVariable Integer customerNO,Model model) {
		model.addAttribute(customerService.load(customerNO));
		return "customer/update";
	}
	
	@RequestMapping(value="/{customerNO}/update",method=RequestMethod.POST)
	public String update(@PathVariable Integer customerNO,@Validated Customer customer,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "customer/update";
		}
		Customer cs = customerService.load(customerNO);
		cs.setCustomerName(customer.getCustomerName());
		cs.setAddress(customer.getAddress());
		cs.setRelationman(customer.getRelationman());
		cs.setPhone(customer.getPhone());
		cs.setOtherInfo(customer.getOtherInfo());
		customerService.update(cs);
		return "redirect:/customer/customers";
	}
	
	@RequestMapping(value="/{customerNO}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable Integer customerNO) {
		customerService.delete(customerNO);
		return "redirect:/customer/customers";
	}
	
	
	
	
	
}
