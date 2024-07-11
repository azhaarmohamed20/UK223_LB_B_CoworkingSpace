package repository;

import model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findById(long id);
    List<Booking> findAll();
    Optional<Booking> deleteBy(long id);
}
