package repository;

import model.Workingspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface WorkingspaceRepository extends JpaRepository<Workingspace, Long> {
    Optional<Workingspace> findById(long id);
    List<Workingspace> findAll();
    Optional<Workingspace> deleteBy(long id);
}
