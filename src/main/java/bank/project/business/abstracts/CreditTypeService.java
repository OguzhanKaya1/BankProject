package bank.project.business.abstracts;

import java.util.List;

import bank.project.business.responses.GetCreditTypeResponse;

public interface CreditTypeService {

	void add(String name, double minAmount, double maxAmount, int aralikSayisi, List<Double> intervalMinArray,
			List<Double> intervalMaxArray, List<Double> intervalInterestArray);

	List<GetCreditTypeResponse> getAllCreditTypes();

}
