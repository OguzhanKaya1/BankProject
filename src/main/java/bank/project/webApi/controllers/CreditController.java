package bank.project.webApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.project.business.abstracts.CreditService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/credit")
public class CreditController {

	private CreditService creditService;

}
