package bank.project.business.rules;

import org.springframework.stereotype.Service;

import bank.project.dataAccess.abstracts.CustomerRepository;
import bank.project.entities.concretes.Customer;

@Service
public class BusinessRulesManager implements BusinessRulesService {

	private CustomerRepository customerRepository;

	public BusinessRulesManager(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer checkCustomerByTc(String searchTc) {
		if (this.customerRepository.findByCustomerTc(searchTc) != null) {
			System.out.println("Gelen searchTc: " + searchTc);
			Customer customer = this.customerRepository.findByCustomerTc(searchTc);
			return customer;
		} else {
			throw new RuntimeException("Tc Eşleşmedi");
		}
	}

	private String savedName = null;

	public String saveCustomerName(String customerName) {

		if (customerName != null) {
			savedName = customerName;
		}

		return savedName;
	}

}
