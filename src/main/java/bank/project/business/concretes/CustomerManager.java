package bank.project.business.concretes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bank.project.business.abstracts.CustomerService;
import bank.project.business.requests.CreateCustomerRequest;
import bank.project.business.requests.UpdateCustomerRequest;
import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.business.responses.GetCustomerByNameResponse;
import bank.project.business.responses.GetCustomerBySurnameResponse;
import bank.project.business.responses.GetCustomerByTc;
import bank.project.business.responses.GetCustomerByTcResponse;
import bank.project.business.responses.GetCustomerDetails;
import bank.project.core.utilities.mappers.ModelMapperService;
import bank.project.dataAccess.abstracts.CustomerRepository;
import bank.project.entities.concretes.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		Customer customer = this.modelMapperService.forRequests().map(createCustomerRequest, Customer.class);
		this.customerRepository.save(customer);

	}

	@Override
	public GetCustomerByTc findByCustomerTc(String searchTc) {
		Customer customer = this.customerRepository.findByCustomerTc(searchTc);
		GetCustomerByTc response = this.modelMapperService.forResponses().map(customer, GetCustomerByTc.class);
		return response;
	}

	@Override
	public void updateCustomer(UpdateCustomerRequest updateCustomerRequest, String searchTc) {
		// Burada eski customer tc'si alınmalı
		Customer customer = this.customerRepository.findByCustomerTc(searchTc);
		// Veritabanına Güncelleme Kaydı
		Customer customerResponse = this.modelMapperService.forRequests().map(updateCustomerRequest, Customer.class);
		customerResponse.setId(customer.getId());
		this.customerRepository.save(customerResponse);

	}

	@Override
	public Page<GetAllCustomerResponseWithStatusCount> getAllCustomerWithStatusCount(int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		return this.customerRepository.findAllCustomersWithStatusCount(pageable);
	}

	@Override
	public Page<GetCustomerByNameResponse> getCustomerByName(String customerName, Pageable pageable) {

		Page<Customer> customers = this.customerRepository.findBycustomerNameContaining(customerName, pageable);
		Page<GetCustomerByNameResponse> response = customers.map(customer -> new GetCustomerByNameResponse(customer));
		return response;
	}

	@Override
	public Page<GetCustomerBySurnameResponse> getCustomerBySurname(String customerSurname, Pageable pageable) {
		Page<Customer> customers = this.customerRepository.findBycustomerSurnameContaining(customerSurname, pageable);
		Page<GetCustomerBySurnameResponse> response = customers
				.map(customer -> new GetCustomerBySurnameResponse(customer));
		return response;
	}

	@Override
	public Page<GetCustomerByTcResponse> getCustomerByTc(String customerTc, Pageable pageable) {
		Page<Customer> customers = this.customerRepository.findBycustomerTcEquals(customerTc, pageable);
		Page<GetCustomerByTcResponse> response = customers.map(customer -> new GetCustomerByTcResponse(customer));
		return response;
	}

	@Override
	public GetCustomerDetails getCustomerDetails(int id) {

		Customer customer = this.customerRepository.findCustomerWithCredits(id);
		return new GetCustomerDetails(customer, customer.getCredits());
	}

}
