package bank.project.business.requests;

import bank.project.entities.concretes.CreditInterval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditIntervalRequest {

	private CreditInterval addCreditIntervalRequest;

}
