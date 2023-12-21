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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "creditInterval")
public class CreditInterval {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "creditStartAmount")
	private double creditStartAmount;

	@Column(name = "creditEndAmount")
	private double creditEndAmount;

	@Column(name = "creditInterestRate")
	private double creditInterestRate;

	@ManyToOne
	@JoinColumn(name = "creditTypeId")
	private CreditType creditTypeInterval;

}
