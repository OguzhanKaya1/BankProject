package bank.project.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditRequest {

	private int creditType;
	private String creditName;
	private int creditAmount;
	private int repaymentPeriod;
	private double creditInterest;
	private double creditTotalAmount;
	private String creditStatus;

}
