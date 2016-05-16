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
import zttc.itat.model.Product;
import zttc.itat.model.Quotation;
import zttc.itat.service.ICustomerService;
import zttc.itat.service.IProductService;
import zttc.itat.service.IQuotationService;

@Controller
@RequestMapping("/quotation")
public class QuotationController {
	private IQuotationService quotationService;
	private IProductService productService;
	private ICustomerService customerService;
	
	

	public IProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public ICustomerService getCustomerService() {
		return customerService;
	}
	@Resource
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
	public IQuotationService getQuotationService() {
		return quotationService;
	}
	@Resource
	public void setQuotationService(IQuotationService quotationService) {
		this.quotationService = quotationService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
		binder.registerCustomEditor(Customer.class, new CustomerEditor(customerService));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
	
	
	@RequestMapping(value={"/quotations","/"},method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers", quotationService.find());
		return "quotation/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new Quotation());
		model.addAttribute("products",productService.find());
		model.addAttribute("customers",customerService.find());
		return "quotation/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Quotation quotation,BindingResult br){
			if(br.hasErrors()){
				return "quotation/add";
			}
			quotationService.add(quotation);
			return "redirect:/quotation/quotations";
	}
	
	@RequestMapping(value="/{quotationNO}",method=RequestMethod.GET)
	public String show(@PathVariable int quotationNO,Model model){
		model.addAttribute(quotationService.load(quotationNO));
		return "quotation/show";
	}
	
	@RequestMapping(value="/{quotationNO}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int quotationNO){
		quotationService.delete(quotationNO);
		return "redirect:/quotation/quotations";
	}
	
	
	@RequestMapping(value="/{quotationNO}/update",method=RequestMethod.GET)
	public String update(@PathVariable int quotationNO,Model model){
		model.addAttribute(quotationService.load(quotationNO));
		model.addAttribute("productss",productService.find());
		model.addAttribute("customerss",customerService.find());
		return "quotation/update";
	}
	
	@RequestMapping(value="/{quotationNO}/update",method=RequestMethod.POST)
	public String update(@PathVariable int quotationNO,@Validated Quotation quotation,BindingResult br,Model model){
/*		if(br.hasErrors()) {
			return "quotation/update";
		}
*/
		Quotation quo=quotationService.load(quotationNO);
		quo.setQuotationMan(quotation.getQuotationMan());
		quo.setOtherInfo(quotation.getOtherInfo());
		quo.setQuotationTime(quotation.getQuotationTime());
		quo.setCustomer(quotation.getCustomer());
		quo.setProduct(quotation.getProduct());
		quotationService.update(quo);
		return "redirect:/quotation/quotations";
		
	}
	
}
