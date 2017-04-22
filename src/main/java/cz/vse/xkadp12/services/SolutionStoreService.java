package cz.vse.xkadp12.services;

import cz.vse.xkadp12.domain.SolutionStore;
import cz.vse.xkadp12.repositories.SolutionStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionStoreService {

    @Autowired
    private SolutionStoreRepository solutionStoreRepository;

    public void saveSolutionStore(SolutionStore solutionStore) {
        solutionStoreRepository.save(solutionStore);
    }

    public List<SolutionStore> findAll() {
        return (List) solutionStoreRepository.findAll();
    }

    public SolutionStore findByAssignmentId(Long id) {
        return solutionStoreRepository.findByAssignmentId(id);
    }

    public SolutionStoreRepository getSolutionStoreRepository() {
        return solutionStoreRepository;
    }

    public void setSolutionStoreRepository(SolutionStoreRepository solutionStoreRepository) {
        this.solutionStoreRepository = solutionStoreRepository;
    }


}
