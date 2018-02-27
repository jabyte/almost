package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ng.transnova.repository.CustomerRepository;
import ng.transnova.repository.NotificationRepository;
import ng.transnova.repository.PaymentRepository;
import ng.transnova.repository.TicketRepository;

@Controller
@RequestMapping(value = "dashboard")
public class DashboardController
{
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String dashboard(Model model)
	{
		model.addAttribute("tickets", ticketRepository.findAll());
		model.addAttribute("payments", paymentRepository.findAll());
		model.addAttribute("notifications", notificationRepository.findAll());
		return "dashboard";
	}
}
