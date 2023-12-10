package bank.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bank.project.business.responses.GetAllCustomerResponseWithStatusCount;
import bank.project.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c LEFT JOIN FETCH c.credits")
	List<Customer> findAllCustomersWithCredits();

	Customer findByCustomerTc(String searchTc);

	@Query("SELECT NEW bank.project.business.responses.GetAllCustomerResponseWithStatusCount(c, "
			+ "(SELECT COUNT(cr) FROM c.credits cr WHERE cr.creditStatus = 'active')) " + "FROM Customer c")
	Page<GetAllCustomerResponseWithStatusCount> findAllCustomersWithStatusCount(Pageable pageable);

	Page<Customer> findBycustomerNameContaining(String customerName, Pageable pageable);

	Page<Customer> findBycustomerSurnameContaining(String customerSurname, Pageable pageable);

	Page<Customer> findBycustomerTcEquals(String customerTc, Pageable pageable);

	@Query("Select c From Customer c LEFT JOIN FETCH c.credits WHERE c.id=id ")
	Customer findCustomerWithCredits(@Param("id") int id);
}
