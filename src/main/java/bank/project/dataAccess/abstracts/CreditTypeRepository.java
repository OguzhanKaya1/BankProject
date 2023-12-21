package bank.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.project.entities.concretes.CreditType;

public interface CreditTypeRepository extends JpaRepository<CreditType, Integer> {

	CreditType findBycreditName(String creditName);

}
