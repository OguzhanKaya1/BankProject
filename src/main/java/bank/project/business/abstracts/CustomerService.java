package bank.project.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import bank.project.business.requests.CreateCustomerRequest;
import bank.project.business.requests.UpdateCustomerRequest;
import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.business.responses.GetCustomerByNameResponse;
import bank.project.business.responses.GetCustomerBySurnameResponse;
import bank.project.business.responses.GetCustomerByTc;
import bank.project.business.responses.GetCustomerByTcResponse;
import bank.project.business.responses.GetCustomerDetailsResponse;

public interface CustomerService {

	void add(CreateCustomerRequest createCustomerRequest);

	GetCustomerByTc findByCustomerTc(String searchTc);

	Page<GetAllCustomerResponseWithStatusCount> getAllCustomerWithStatusCount(int page, int size);

	Page<GetCustomerByNameResponse> getCustomerByName(String customerName, Pageable pageable);

	Page<GetCustomerBySurnameResponse> getCustomerBySurname(String customerSurname, Pageable pageable);

	Page<GetCustomerByTcResponse> getCustomerByTc(String customerTc, Pageable pageable);

	GetCustomerDetailsResponse customerDetailsResponse(int customerId);

	void updateCustomer(UpdateCustomerRequest updateCustomerRequest);

	void deleteCustomer(int customerId);

}
