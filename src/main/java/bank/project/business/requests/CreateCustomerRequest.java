package bank.project.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

	private String customerName;
	private String customerSurname;
	private String customerTc;
	private String customerAddress;
	private String customerGender;
}
