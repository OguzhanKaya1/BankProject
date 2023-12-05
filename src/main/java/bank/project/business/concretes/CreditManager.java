package bank.project.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bank.project.business.abstracts.CreditService;
import bank.project.business.requests.CreateCreditRequest;
import bank.project.business.responses.GetAllCreditsResponse;
import bank.project.core.utilities.mappers.ModelMapperService;
import bank.project.dataAccess.abstracts.CreditRepository;
import bank.project.dataAccess.abstracts.CustomerRepository;
import bank.project.entities.concretes.Credit;
import bank.project.entities.concretes.Customer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditManager implements CreditService {

	private CreditRepository creditRepository;
	private ModelMapperService modelMapperService;
	private CustomerRepository customerRepository;

	@Override
	public void add(CreateCreditRequest createCreditRequest, int customerId) {

		Credit credit = this.modelMapperService.forRequests().map(createCreditRequest, Credit.class);
		Customer customer = this.customerRepository.findById(customerId).orElseThrow();
		credit.setCustomer(customer);
		this.creditRepository.save(credit);

	}

	@Override
	public List<GetAllCreditsResponse> getAll() {
		List<Credit> credits = this.creditRepository.findAll();
		List<GetAllCreditsResponse> creditsResponse = credits.stream()
				.map(credit -> this.modelMapperService.forResponses().map(credit, GetAllCreditsResponse.class))
				.collect(Collectors.toList());

		return creditsResponse;
	}

}
