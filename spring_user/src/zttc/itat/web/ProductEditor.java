package zttc.itat.web;

import java.beans.PropertyEditorSupport;

import zttc.itat.service.IProductService;

public class ProductEditor extends PropertyEditorSupport{
	private IProductService productService;
	
	public ProductEditor(IProductService productService){
		this.productService=productService;
	}
	
	public void setAsText(String productid){
		setValue(productService.load(Integer.valueOf(productid)));
	}
}
