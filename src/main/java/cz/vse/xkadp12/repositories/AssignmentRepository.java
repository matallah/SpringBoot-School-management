package cz.vse.xkadp12.repositories;

import cz.vse.xkadp12.domain.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment, Long> {

}
