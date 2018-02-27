package ng.transnova.controllers;

import ng.transnova.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ng.transnova.repository.CustomerRepository;

@Controller
@RequestMapping(value = "signup")
public class SignupController
{
	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySignupPage(Model model)
	{
		model.addAttribute(new Customer());
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleSignup(Model model, @ModelAttribute Customer customer, @RequestParam String password, @RequestParam String repassword, Errors errors)
	{
		if (errors.hasErrors()) {
			model.addAttribute("errors", errors);
			return "signup";
		} else {
			if (!password.equals(repassword)) {
				model.addAttribute("error", "The two password did not march!");
				return "signup";
			} else {
				try {
					customer.setPassword(Customer.getSHA512SecurePassword(customer.getPassword()));
					customerRepository.save(customer);
					return "redirect:/responses/success";
				} catch (Exception e) {
					System.err.println(e.getCause());
					System.err.println(e.getMessage());
					return "redirect:/responses/alert";
				}
			}
		}
	}
}
