package bank.project.business.requests;

import bank.project.entities.concretes.CreditType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditTypeRequest {

	private CreditType addCreditType;

}
