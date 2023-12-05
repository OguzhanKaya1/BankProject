package bank.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.business.responses.GetCustomerByName;
import bank.project.business.responses.GetCustomerBySurname;
import bank.project.business.responses.GetCustomerByTc;
import bank.project.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c LEFT JOIN FETCH c.credits")
	List<Customer> findAllCustomersWithCredits();

	Customer findByCustomerTc(String searchTc);

	@Query("SELECT NEW bank.project.business.responses.GetAllCustomerResponseWithStatusCount(c, "
			+ "(SELECT COUNT(cr) FROM c.credits cr WHERE cr.creditStatus = 'active')) " + "FROM Customer c")
	Page<GetAllCustomerResponseWithStatusCount> findAllCustomersWithStatusCount(Pageable pageable);

	Page<GetCustomerByName> findByCustomerName(String customerName, Pageable pageable);

	Page<GetCustomerBySurname> findByCustomerSurname(String customerSurname, Pageable pageable);

	Page<GetCustomerByTc> findByCustomerTcEquals(String customerTc, Pageable pageable);
}
