package bank.project.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "credits")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "creditAmount")
	private int creditAmount;

	@Column(name = "creditMonthlyRepayment")
	private int creditMonthlyRepayment;

	@Column(name = "repaymentPeriod")
	private int repaymentPeriod;

	@Column(name = "creditTotalInterest")
	private double creditTotalInterest;

	@Column(name = "creditTotalAmount")
	private double creditTotalAmount;

	@Column(name = "creditStatus")
	private String creditStatus;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "creditTypeId")
	private CreditType creditType;

}
