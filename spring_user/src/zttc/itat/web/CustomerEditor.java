package zttc.itat.web;

import java.beans.PropertyEditorSupport;

import zttc.itat.service.ICustomerService;

public class CustomerEditor extends PropertyEditorSupport{
	private ICustomerService customerService;
	
	public CustomerEditor(ICustomerService customerService){
		this.customerService=customerService;
	}
	
	public void setAsText(String customerid){
		setValue(customerService.load(Integer.valueOf(customerid)));
	}
}
