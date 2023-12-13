package bank.project.webApi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bank.project.business.abstracts.CustomerService;
import bank.project.business.requests.CreateCustomerRequest;
import bank.project.business.requests.UpdateCustomerRequest;
import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.business.responses.GetCustomerByNameResponse;
import bank.project.business.responses.GetCustomerBySurnameResponse;
import bank.project.business.responses.GetCustomerByTcResponse;
import bank.project.business.responses.GetCustomerDetailsResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@SessionAttributes({ "searchByCustomerName", "searchByCustomerSurname", "searchByCustomerTc" })
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

	// Search Metodu Başlangıcı
	@GetMapping("/bankProjectSearchCustomer.html")
	public String searchCustomer() {
		return "bankProjectSearchCustomer.html";
	}

	@PostMapping("/searchByCustomerName")
	public String searchByCustomerName(@RequestBody String searchByCustomerName, Model model) {
		model.addAttribute("searchByCustomerName", searchByCustomerName);
		return "redirect:/searchByName";
	}

	@GetMapping("/searchByName")
	public String getCustomerByName(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			SessionStatus sessionStatus) {
		String searchByCustomerName = (String) model.getAttribute("searchByCustomerName");
		int size = 10;
		Page<GetCustomerByNameResponse> foundedCustomers = this.customerService.getCustomerByName(searchByCustomerName,
				PageRequest.of(page, size));

		model.addAttribute("customer", foundedCustomers.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", foundedCustomers.getTotalPages());

		return "bankProjectShowSearchedCustomerByName.html";
	}

	@PostMapping("/searchByCustomerSurname")
	public String searchByCustomerSurname(@RequestBody String searchByCustomerSurname, Model model) {
		model.addAttribute("searchByCustomerSurname", searchByCustomerSurname);
		return "redirect:/searchBySurname";
	}

	@GetMapping("/searchBySurname")
	public String getCustomerBySurname(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			SessionStatus sessionStatus) {
		String searchByCustomerSurname = (String) model.getAttribute("searchByCustomerSurname");
		int size = 10;
		Page<GetCustomerBySurnameResponse> foundedCustomers = this.customerService
				.getCustomerBySurname(searchByCustomerSurname, PageRequest.of(page, size));

		model.addAttribute("customer", foundedCustomers.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", foundedCustomers.getTotalPages());

		return "bankProjectShowSearchedCustomerBySurname.html";
	}

	@PostMapping("/searchByCustomerTc")
	public String searchByCustomerTc(@RequestBody String searchByCustomerTc, Model model) {
		model.addAttribute("searchByCustomerTc", searchByCustomerTc);
		return "redirect:/searchByTc";
	}

	@GetMapping("/searchByTc")
	public String getCustomerByTc(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			SessionStatus sessionStatus) {
		String searchByCustomerTc = (String) model.getAttribute("searchByCustomerTc");
		int size = 10;
		Page<GetCustomerByTcResponse> foundedCustomers = this.customerService.getCustomerByTc(searchByCustomerTc,
				PageRequest.of(page, size));

		model.addAttribute("customer", foundedCustomers.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", foundedCustomers.getTotalPages());

		return "bankProjectShowSearchedCustomerByTc.html";
	}
	// Search Metodu Bitişi

	// CustomerDetils Metodu
	@GetMapping("/customerDetails/{customerId}")
	public String showCustomerDetails(@PathVariable int customerId, Model model) {

		GetCustomerDetailsResponse detailsResponse = this.customerService.customerDetailsResponse(customerId);
		model.addAttribute("customer", detailsResponse.getCustomerDetails());
		model.addAttribute("credits", detailsResponse.getCreditsDetails());
		model.addAttribute("updateCustomerRequest", new UpdateCustomerRequest());

		return "bankProjectShowCustomerDetails.html";
	}
	// Customer Details Metodu Bitişi

	// Customer Update Metodu
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("updateCustomerRequest") UpdateCustomerRequest updateCustomerRequest) {
		this.customerService.updateCustomer(updateCustomerRequest);
		return "redirect:/customerDetails/" + updateCustomerRequest.getUpdateCustomer().getId();
	}

}

//
//
//
//
//
//
//
//
//