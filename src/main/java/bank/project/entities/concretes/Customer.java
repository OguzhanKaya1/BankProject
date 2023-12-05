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

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "customerSurname")
	private String customerSurname;

	@Column(name = "customerTc")
	private String customerTc;

	@Column(name = "customerGender")
	private String customerGender;

	@Column(name = "customerAddress")
	private String customerAddress;

	@OneToMany(mappedBy = "customer")
	private List<Credit> credits;

}
