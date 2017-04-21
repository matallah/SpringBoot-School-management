package cz.vse.xkadp12.repositories;

import cz.vse.xkadp12.domain.SolutionStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionStoreRepository extends CrudRepository<SolutionStore, Long> {

}
