package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.StationRepository;
import ng.transnova.repository.TicketRepository;

@Controller
@RequestMapping(value = "customer/{id}/trips")
public class BookingController
{
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	StationRepository stationRepository;

	public String displayBookings(Model model)
	{
		model.addAttribute("tickets", ticketRepository.findAll());
		return "tickets";
	}

	public String addNewBooking(Model model)
	{
		return "";
	}
}
