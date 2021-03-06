package ng.transnova.controllers;

import java.util.List;
import ng.transnova.models.Payment;
import ng.transnova.models.Ticket;
import ng.transnova.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ng.transnova.repository.CustomerRepository;
import ng.transnova.repository.PaymentRepository;
import ng.transnova.repository.TicketRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping(value = "login")
public class LoginController
{
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String displayLoginPage()
	{
		return "login";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String handleAuthentication(Model model, @RequestParam String phoneNumber, @RequestParam String password)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password);
		Customer customer = customerRepository.findByPhoneNumberAndPassword(phoneNumber, password);

		if (customer == null) {
			model.addAttribute("errors", "Username or password incorrect.");
			return "login";
		} else {
			model.addAttribute("customer", customer);
			model.addAttribute("tickets", (List<Ticket>) ticketRepository.findAll());
			model.addAttribute("payments", (List<Payment>) paymentRepository.findAll());

			return "dashboard";
		}
	}
}
