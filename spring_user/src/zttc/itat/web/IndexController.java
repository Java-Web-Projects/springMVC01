package zttc.itat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import zttc.itat.model.User;
import zttc.itat.service.IUserService;

@Controller
@SessionAttributes("loginUser")
public class IndexController {
	private IUserService userService;
	
	
	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model) {
		User u = userService.login(username, password);
		boolean is_admin=u.isAdmin();
		String uname=u.getUsername();
		System.out.println(uname);
		System.out.println(is_admin);
		model.addAttribute("loginUser", u);
		if(is_admin){
			return "redirect:/user/users";
		}else
		return "redirect:/product/products";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
		model.asMap().remove("loginUser");
		session.invalidate();
		return "redirect:/login";
	}
}
