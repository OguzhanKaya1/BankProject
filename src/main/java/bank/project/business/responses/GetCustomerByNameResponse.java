package bank.project.business.responses;

import bank.project.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerByNameResponse {

	private Customer foundedCustomerByName;

}
