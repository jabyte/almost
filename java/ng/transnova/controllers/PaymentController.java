package ng.transnova.controllers;

import ng.transnova.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.PaymentRepository;

@Controller
@RequestMapping(value = "payment")
public class PaymentController
{
	@Autowired
	PaymentRepository paymentRepository;

	public String payment(Model model)
	{
		model.addAttribute(paymentRepository.findAll());
		return "payment";
	}

	public String newPayment(Model model, @ModelAttribute @Validated Payment payment)
	{
		paymentRepository.save(payment);
		return "payment";
	}
}
