package ng.transnova.controllers;

import javax.validation.Valid;
import ng.transnova.models.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.StaffRepository;

@Controller
@RequestMapping(value = "staffs")
public class StaffController
{
	@Autowired
	StaffRepository staffRepository;

	public String staffs(Model model)
	{
		model.addAttribute(staffRepository.findAll());
		return "staffs";
	}

	public String addStaff(Model model, @ModelAttribute @Valid Staff staff)
	{
		staffRepository.save(staff);
		return "staff";
	}
}
