package repository;

import model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    Optional<Workspace> findById(long id);
    List<Workspace> findAll();
    Optional<Workspace> deleteById(long id);
}
