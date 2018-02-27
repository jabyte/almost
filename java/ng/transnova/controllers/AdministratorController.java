package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.AdministratorRepository;

@Controller
@RequestMapping(value = "administrators")
public class AdministratorController
{
	@Autowired
	AdministratorRepository administratorRepository;

	@RequestMapping(value = "dashboard")
	public String displayAdministrators(Model model)
	{
		model.addAttribute(administratorRepository.findAll());
		return "administrators/dashboard";
	}
}
