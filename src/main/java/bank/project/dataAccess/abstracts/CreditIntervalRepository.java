package bank.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.project.entities.concretes.CreditInterval;

public interface CreditIntervalRepository extends JpaRepository<CreditInterval, Integer> {

}
