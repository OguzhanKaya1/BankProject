package bank.project.business.rules;

import bank.project.entities.concretes.Customer;

public interface BusinessRulesService {

	Customer checkCustomerByTc(String Tc);

}
