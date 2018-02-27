package ng.transnova.repository;

import ng.transnova.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer>
{
}
