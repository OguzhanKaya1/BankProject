package bank.project.webApi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bank.project.business.abstracts.CustomerService;
import bank.project.business.requests.CreateCustomerRequest;
import bank.project.business.requests.UpdateCustomerRequest;
import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.business.responses.GetCustomerByTc;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomerController {

	private CustomerService customerService;

	@GetMapping("/")
	public String bankProje() {
		return "bankProje";
	}

	@GetMapping("/bankProjectCustomerPage.html")
	public String bankProjectCustomerPage() {
		return "bankProjectCustomerPage";
	}

	// AddCustomer Controller Metodu
	@GetMapping("/bankProjectAddCustomer.html")
	public String bankProjectAddCustomer() {
		return "bankProjectAddCustomer";
	}

	@PostMapping("/register")
	public String bankProjectAddCustomer(@ModelAttribute CreateCustomerRequest createCustomerRequest) {
		this.customerService.add(createCustomerRequest);
		return "bankProjectAddCustomer";
	}
	// Add Customer Controller Metodu Bitişi

	// GetAllCustomers Controller Metodu
	@GetMapping("/bankProjectGetAllCustomers.html")
	public String bankProjectGetAllCustomersWithStatusCount(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size, Model model) {

		Page<GetAllCustomerResponseWithStatusCount> getAllCustomerPage = customerService
				.getAllCustomerWithStatusCount(page, size);

		model.addAttribute("getAllCustomers", getAllCustomerPage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", getAllCustomerPage.getTotalPages());
		return "bankProjectGetAllCustomers";
	}
	// GetAllCustomers Controller Metodu Bitişi

	@GetMapping("/bankProjectUpdateCustomer.html")
	public String bankProjectUpdateCustomer() {
		return "bankProjectUpdateCustomer";
	}

	// Update Metodu
	@PostMapping("/search/{tc}")
	public String searchCustomer(Model model, String searchTc) {
		GetCustomerByTc foundedCustomer = this.customerService.findByCustomerTc(searchTc);
		model.addAttribute("customer", foundedCustomer);
		return "bankProjectUpdateCustomer";
	}

	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute UpdateCustomerRequest updateCustomerRequest, String searchTc) {
		this.customerService.updateCustomer(updateCustomerRequest, searchTc);
		return "bankProjectUpdateCustomer.html";
	}
	// Update Metodu Bitişi

	// Müşteri Getir Ekranı Başlangıç


}
