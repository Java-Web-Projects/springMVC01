package zttc.itat.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.Product;
import zttc.itat.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	private IProductService productService;

	public IProductService getProductService() {
		return productService;
	}

	@Resource
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	
//register the propertyEditor
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
	}
	
	
	@RequestMapping(value={"products","/"},method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("pagers", productService.find());
		return "product/list";
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new Product());
		return "product/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated Product pro,BindingResult br){
		if(br.hasErrors()){
			return "product/add";
			
		}
		productService.add(pro);
		return "redirect:/product/products";
	}
	
	@RequestMapping(value="/{productNO}",method=RequestMethod.GET)
	public String show(@PathVariable int productNO,Model model){
		model.addAttribute(productService.load(productNO));
		return "product/show";
	}
	
	@RequestMapping(value="/{productNO}/update",method=RequestMethod.GET)
	public String update(@PathVariable int productNO,Model model){
		model.addAttribute(productService.load(productNO));
		return "product/update";
	}
	
	@RequestMapping(value="/{productNO}/update",method=RequestMethod.POST)
	public String update(@PathVariable int productNO,@Validated Product pro,BindingResult br,Model model){
		if(br.hasErrors()){
			return "product/update";
		}
		Product npro=productService.load(productNO);
		npro.setPrice(pro.getPrice());
		npro.setProname(pro.getProname());
		npro.setImage(pro.getImage());
		productService.update(npro);
		
		return "redirect:/product/products";
	}
	
	@RequestMapping(value="/{productNO}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int productNO){
		productService.delete(productNO);
		return "redirect:/product/products";
	}

}