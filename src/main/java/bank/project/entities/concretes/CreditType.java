package bank.project.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "creditType")
@AllArgsConstructor
@NoArgsConstructor
public class CreditType {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "creditName")
	private String creditName;

	@Column(name = "creditMinAmount")
	private double creditMinAmount;

	@Column(name = "creditMaxAmount")
	private double creditMaxAmount;

	@OneToMany(mappedBy = "creditType")
	private List<Credit> credits;

	@OneToMany(mappedBy = "creditTypeInterval")
	private List<CreditInterval> creditIntervals;

}
