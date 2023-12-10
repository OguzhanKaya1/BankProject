package bank.project.business.responses;

import java.util.List;

import bank.project.entities.concretes.Credit;
import bank.project.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerDetails {

	private Customer customer;
	private List<Credit> credits;

}
