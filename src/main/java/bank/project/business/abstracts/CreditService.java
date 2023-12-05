package bank.project.business.abstracts;

import java.util.List;

import bank.project.business.requests.CreateCreditRequest;
import bank.project.business.responses.GetAllCreditsResponse;

public interface CreditService {

	void add(CreateCreditRequest createCreditRequest, int customerId);

	List<GetAllCreditsResponse> getAll();
	

}
