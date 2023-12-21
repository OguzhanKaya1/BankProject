package bank.project.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bank.project.business.abstracts.CreditTypeService;
import bank.project.business.responses.GetCreditTypeResponse;
import bank.project.core.utilities.mappers.ModelMapperService;
import bank.project.dataAccess.abstracts.CreditIntervalRepository;
import bank.project.dataAccess.abstracts.CreditTypeRepository;
import bank.project.entities.concretes.CreditInterval;
import bank.project.entities.concretes.CreditType;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditTypeManager implements CreditTypeService {

	private CreditTypeRepository creditTypeRepository;
	private CreditIntervalRepository creditIntervalRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(String name, double minAmount, double maxAmount, int aralikSayisi, List<Double> intervalMinArray,
			List<Double> intervalMaxArray, List<Double> intervalInterestArray) {

		CreditType creditType = new CreditType();
		creditType.setCreditName(name);
		creditType.setCreditMinAmount(minAmount);
		creditType.setCreditMaxAmount(maxAmount);
		this.creditTypeRepository.save(creditType);

		creditType = this.creditTypeRepository.findBycreditName(name);

		List<CreditInterval> creditIntervals = new ArrayList<CreditInterval>();
		for (int i = 0; i < aralikSayisi; i++) {
			CreditInterval creditInterval = new CreditInterval();
			creditInterval.setCreditStartAmount(intervalMinArray.get(i));
			creditInterval.setCreditEndAmount(intervalMaxArray.get(i));
			creditInterval.setCreditInterestRate(intervalInterestArray.get(i));
			creditInterval.setCreditTypeInterval(creditType);

			creditIntervals.add(creditInterval);
		}

		for (CreditInterval interval : creditIntervals) {
			CreditInterval creditInterval1 = new CreditInterval();
			creditInterval1 = interval;
			this.creditIntervalRepository.save(creditInterval1);
		}

	}

	@Override
	public List<GetCreditTypeResponse> getAllCreditTypes() {

		List<CreditType> creditTypes = this.creditTypeRepository.findAll();
		List<GetCreditTypeResponse> creditTypeResponses = new ArrayList<GetCreditTypeResponse>();

		for (CreditType creditType : creditTypes) {
			GetCreditTypeResponse creditTypeResponse = new GetCreditTypeResponse();
			creditTypeResponse.setGetCreditTypeResponse(creditType);
			creditTypeResponse.setGetCreditIntervalsResponse(creditType.getCreditIntervals());
			creditTypeResponses.add(creditTypeResponse);
		}

		return creditTypeResponses;
	}

}
