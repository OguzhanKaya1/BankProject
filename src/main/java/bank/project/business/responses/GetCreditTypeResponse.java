package bank.project.business.responses;

import java.util.List;

import bank.project.entities.concretes.CreditInterval;
import bank.project.entities.concretes.CreditType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCreditTypeResponse {

	private CreditType getCreditTypeResponse;
	private List<CreditInterval> getCreditIntervalsResponse;
}
