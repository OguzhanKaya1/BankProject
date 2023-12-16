package bank.project.business.abstracts;

import bank.project.business.requests.CreateCreditRequest;

public interface CreditService {

	abstract void add(CreateCreditRequest createCreditRequest, int customerId);

}
