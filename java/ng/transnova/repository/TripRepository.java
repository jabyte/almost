package ng.transnova.repository;

import ng.transnova.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TripRepository extends CrudRepository<Trip, Integer>
{

}
