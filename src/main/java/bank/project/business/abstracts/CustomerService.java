package bank.project.business.abstracts;

import org.springframework.data.domain.Page;

import bank.project.business.requests.CreateCustomerRequest;
import bank.project.business.requests.UpdateCustomerRequest;
import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.business.responses.GetCustomerByName;
import bank.project.business.responses.GetCustomerBySurname;
import bank.project.business.responses.GetCustomerByTc;

public interface CustomerService {

	void add(CreateCustomerRequest createCustomerRequest);

	GetCustomerByTc findByCustomerTc(String searchTc);

	void updateCustomer(UpdateCustomerRequest updateCustomerRequest, String searchTc);

	Page<GetAllCustomerResponseWithStatusCount> getAllCustomerWithStatusCount(int page, int size);

	Page<GetCustomerByName> getCustomerByName(int page, int size, String customerName);

	Page<GetCustomerBySurname> getCustomerBySurname(int page, int size, String customerSurname);

	Page<GetCustomerByTc> getCustomerByTc(int page, int size, String customerTc);

}
