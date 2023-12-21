package bank.project.webApi.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bank.project.business.abstracts.CreditTypeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CreditController {

	private CreditTypeService creditTypeService;

	@GetMapping("/bankProjectGetCreditPage.html")
	public String getCreditPage() {

		return "bankProjectGetCreditPage";
	}

	@GetMapping("/bankProjectAddCredit.html")
	public String returnAddCredit() {

		return "bankProjectAddCredit";

	}

	@PostMapping("/registerCredit")
	public String addCredit(@RequestParam String creditName, @RequestParam double minAmount,
			@RequestParam double maxAmount, @RequestParam int aralikSayisi,
			@RequestParam("intervalMinArray") List<Double> intervalMinArray,
			@RequestParam("intervalMaxArray") List<Double> intervalMaxArray,
			@RequestParam("intervalInterestArray") List<Double> intervalInteresArray) {

		this.creditTypeService.add(creditName, minAmount, maxAmount, aralikSayisi, intervalMinArray, intervalMaxArray,
				intervalInteresArray);

		return "redirect:/bankProjectAddCredit";
	}

	@GetMapping("/getCreditTypes")
	public String getCreditTypes(Model model) {

		model.addAttribute("getAllCreditTypes", this.creditTypeService.getAllCreditTypes());

		return "bankProjectGetAllCreditTypes";

	}

}
