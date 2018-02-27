package ng.transnova.controllers;

import java.util.List;
import javax.validation.Valid;
import ng.transnova.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ng.transnova.repository.StationRepository;
import ng.transnova.repository.TicketRepository;

@Controller
@RequestMapping(value = "tickets")
public class TicketController
{
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	StationRepository stationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String tickets(Model model)
	{
		List<Ticket> tickets = (List<Ticket>) ticketRepository.findAll();
		model.addAttribute(tickets);
		return "ticket";
	}

	public String newTicket(Model model, @ModelAttribute @Valid Ticket ticket, Errors errors)
	{
		if (errors.hasErrors()) {
//			String source = (String) model.getParameter("source");
//			String destination = (String) model.getParameter("destination");
//			String departureDate = (String) model.getParameter("departure_date");
//			String departureTime = (String) model.getParameter("departure_time");
//
//			Station srcStation = stationRepository.find(Integer.parseInt(source));
//			Station desStation = stationRepository.find(Integer.parseInt(destination));
//			String[] dt = departureDate.split("-");
//
//			Date depDate = new Date(Integer.parseInt(dt[2]), Integer.parseInt(dt[1]), Integer.parseInt(dt[0]));
//
//			Ticket ticket = new Ticket();
//			Customer customer = new Customer();
//			customer.setCustomerId(1);

//			ticket.setCustomerId(customer);
//			ticket.setSourceStationId(srcStation);
//			ticket.setDestinationStationId(desStation);
//			ticket.setDateBooked(depDate);
//			ticket.setDeparcherTime(departureTime);
			ticketRepository.save(ticket);
			return "responses/success";
		}
		model.addAttribute(errors);
		return "redirect:/responses/alert";
	}
}
