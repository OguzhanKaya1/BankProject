package bank.project.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

	private String customerName;
	private String customerSurname;
	private String customerTc;
	private String customerGender;
	private String customerAddress;

}
