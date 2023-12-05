package bank.project.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.project.business.abstracts.CreditService;
import bank.project.business.requests.CreateCreditRequest;
import bank.project.business.responses.GetAllCreditsResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/credit")
public class CreditController {

	private CreditService creditService;

	@GetMapping("/getAll")
	public List<GetAllCreditsResponse> getAll() {

		return this.creditService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateCreditRequest createCreditRequest, int customerId) {
		this.creditService.add(createCreditRequest, customerId);
	}

}
