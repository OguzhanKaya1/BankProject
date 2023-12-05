package bank.project.business.rules;

import org.springframework.stereotype.Service;

import bank.project.dataAccess.abstracts.CustomerRepository;
import bank.project.entities.concretes.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessRulesManager implements BusinessRulesService {

	private CustomerRepository customerRepository;

	public Customer checkCustomerByTc(String searchTc) {
		if (this.customerRepository.findByCustomerTc(searchTc) != null) {
			System.out.println("Gelen searchTc: " + searchTc);
			Customer customer = this.customerRepository.findByCustomerTc(searchTc);
			return customer;
		} else {
			throw new RuntimeException("Tc Eşleşmedi");
		}
	}

}
