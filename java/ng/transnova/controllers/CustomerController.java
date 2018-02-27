package ng.transnova.controllers;

import javax.persistence.EntityManager;
import ng.transnova.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.CustomerRepository;
import ng.transnova.repository.PaymentRepository;
import ng.transnova.repository.TicketRepository;

@Controller
@RequestMapping(value = "customer")
public class CustomerController
{
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	EntityManager em;

	@RequestMapping(value = "customer/dashboard")
	public String displayDashboard(Model model)
	{
		Customer customer = em.createNamedQuery("Customer.findByPhoneNumber", Customer.class).getSingleResult();

		model.addAttribute("customer", customer);
		model.addAttribute("payments", paymentRepository.findAll());
		model.addAttribute("tickets", ticketRepository.findAll());
		return "customer/dashboard";
	}
}
