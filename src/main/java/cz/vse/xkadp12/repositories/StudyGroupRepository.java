package cz.vse.xkadp12.repositories;

import cz.vse.xkadp12.domain.StudyGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends CrudRepository<StudyGroup, Long> {

}
