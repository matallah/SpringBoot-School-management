package cz.vse.xkadp12.repositories;

import cz.vse.xkadp12.domain.Solution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends CrudRepository<Solution, Long>{
}
