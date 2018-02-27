package ng.transnova.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ng.transnova.repository.CouponRepository;

@Controller
@RequestMapping(value = "coupons")
public class CouponController
{
	@Autowired
	CouponRepository couponRepository;

	public String displayCoupons(Model model)
	{
		model.addAttribute("Coupons", couponRepository.findAll());
		return "coupon";
	}

	public String addCoupon(Model model)
	{
		return "coupon";
	}
}
