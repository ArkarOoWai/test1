package user.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import user.repository.UserdbRepository;
import user.model.UserBean;

@Controller
@RequestMapping("/user")
public class RegisterController {

	//@Autowired
	//UserdbRepository userrepo;

	@GetMapping(value = "/register")
	public ModelAndView showRegister() {
		return new ModelAndView("registerdb", "bean", new UserBean());
	}

	@PostMapping(value = "/create")
	public String createUser(@ModelAttribute("bean") UserBean bean, Model m) {
		UserdbRepository userrepo=new UserdbRepository();
		int result = userrepo.insertUser(bean);
		if (result > 0) {
			return "redirect:/";
		} else {
			m.addAttribute("error", "Register Fail");
			return "redirect:/user/register";
		}
	}
}
