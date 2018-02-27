package ng.transnova.controllers;

import java.util.List;
import javax.validation.Valid;
import ng.transnova.models.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ng.transnova.repository.StationRepository;

@Controller
@RequestMapping(value = "stations")
public class StationController
{
	@Autowired
	StationRepository stationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String stations(Model model)
	{
		List<Station> stations = (List<Station>) stationRepository.findAll();
		model.addAttribute("stations", stations);
		return "stations";
	}

	public String newStation(Model model, @ModelAttribute @Valid Station station)
	{
		stationRepository.save(station);
		return "success";

	}
}
