package ng.transnova.repository;

import ng.transnova.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	public Customer findByPhoneNumberAndPassword(@Param("phoneNumber") String phoneNumber, @Param("password") String password);
}
