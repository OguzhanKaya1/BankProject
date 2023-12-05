package bank.project.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCreditsResponse {

	private int creditType;
	private String creditName;
	private int creditAmount;
	private int repaymentPeriod;
	private double interest;
	private double totalAmount;
	private String creditStatus;

}
