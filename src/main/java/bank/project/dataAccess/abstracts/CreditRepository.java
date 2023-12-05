package bank.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.project.entities.concretes.Credit;

public interface CreditRepository extends JpaRepository<Credit, Integer> {

}
