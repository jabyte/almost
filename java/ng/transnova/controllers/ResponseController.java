package ng.transnova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "responses")
public class ResponseController
{
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String displaySuccess()
	{
		return "responses/success";
	}

	@RequestMapping(value = "alert", method = RequestMethod.GET)
	public String displayAlert()
	{
		return "responses/alert";
	}
}
