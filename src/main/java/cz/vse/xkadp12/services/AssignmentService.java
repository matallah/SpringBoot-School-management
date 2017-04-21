package cz.vse.xkadp12.services;

import cz.vse.xkadp12.domain.Assignment;
import cz.vse.xkadp12.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public void saveAssignment(Assignment assignment){
        assignmentRepository.save(assignment);
    }

    public AssignmentRepository getAssignmentRepository() {
        return assignmentRepository;
    }

    public void setAssignmentRepository(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }
}
