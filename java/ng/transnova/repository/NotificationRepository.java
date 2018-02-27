package ng.transnova.repository;

import ng.transnova.models.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Integer>
{
}
