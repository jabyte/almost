package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ng.transnova.repository.StationRepository;
import ng.transnova.repository.TripRepository;

@Controller
@RequestMapping(value = "/")
public class HomeController
{
	@Autowired
	StationRepository stationRepository;

	@Autowired
	TripRepository tripRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index()
	{
		return "index";
	}

	@RequestMapping(value = "schedules", method = RequestMethod.GET)
	public String schedles(Model model)
	{
		model.addAttribute("trips", tripRepository.findAll());
		return "schedules";
	}

	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String about()
	{
		return "about";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String contact()
	{
		return "contact";
	}
}
