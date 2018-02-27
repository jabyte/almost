package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.NotificationRepository;

@Controller
@RequestMapping(value = "notifications")
public class NotificationController
{
	@Autowired
	NotificationRepository notificationRepository;

	public String notification(Model model)
	{
		model.addAttribute("Notifications", notificationRepository.findAll());
		return "notifications";
	}

	public String newNotification()
	{
		return "";
	}
}
