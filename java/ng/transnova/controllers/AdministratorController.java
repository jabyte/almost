package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.AdministratorRepository;
import ng.transnova.repository.CouponRepository;
import ng.transnova.repository.CustomerRepository;
import ng.transnova.repository.StaffRepository;
import ng.transnova.repository.StationRepository;
import ng.transnova.repository.TicketRepository;
import ng.transnova.repository.TripRepository;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "admin")
public class AdministratorController
{
	@Autowired
	AdministratorRepository administratorRepository;

	@Autowired
	StationRepository stationRepository;

	@Autowired
	TripRepository tripRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	CouponRepository couponRepository;

	@Autowired
	StaffRepository staffRepository;

	@RequestMapping(value = "")
	public String displayAdministrators(Model model)
	{
		model.addAttribute(administratorRepository.findAll());
		return "admin/dashboard";
	}

	@RequestMapping(value = "station", method = RequestMethod.GET)
	public String displayStations(Model model)
	{
		model.addAttribute("stations", stationRepository.findAll());
		return "admin/station/view";
	}

	@RequestMapping(value = "trip", method = RequestMethod.GET)
	public String displayTrips(Model model)
	{
		model.addAttribute("trips", tripRepository.findAll());
		return "admin/trip/view";
	}

	@RequestMapping(value = "customers", method = RequestMethod.GET)
	public String displayCustomers(Model model)
	{
		model.addAttribute("customers", customerRepository.findAll());
		return "admin/customers/view";
	}

	@RequestMapping(value = "coupons", method = RequestMethod.GET)
	public String displayCoupons(Model model)
	{
		model.addAttribute("coupons", couponRepository.findAll());
		return "admin/coupons/view";
	}

	@RequestMapping(value = "staffs", method = RequestMethod.GET)
	public String displayStaffs(Model model)
	{
		model.addAttribute("staffs", staffRepository.findAll());
		return "admin/staffs/view";
	}

	@RequestMapping(value = "tickets", method = RequestMethod.GET)
	public String displayTickets(Model model)
	{
		model.addAttribute("tickets", ticketRepository.findAll());
		return "admin/tickets/view";
	}
}
