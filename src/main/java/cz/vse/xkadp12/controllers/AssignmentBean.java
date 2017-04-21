package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Assignment;
import cz.vse.xkadp12.domain.SolutionStore;
import cz.vse.xkadp12.services.AssignmentService;
import cz.vse.xkadp12.services.SolutionStoreService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.time.format.DateTimeFormatter;

@ManagedBean
public class AssignmentBean {

    @ManagedProperty(value = "#{assignmentService}")
    private AssignmentService assignmentService;
    @ManagedProperty(value = "#{solutionStoreService}")
    private SolutionStoreService solutionStoreService;

    private Assignment assignment = new Assignment();

    public void saveAssignment() {


        assignmentService.saveAssignment(assignment);
        // create SolutionStore
        solutionStoreService.saveSolutionStore(createSolutionStore());
        resetAssignment();
        // send email
    }

    private SolutionStore createSolutionStore() {
        return new SolutionStore(assignment);
    }

    private void resetAssignment() {
        this.assignment = new Assignment();
    }

    private void formatDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");

    }

    public AssignmentService getAssignmentService() {
        return assignmentService;
    }

    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment newAssignment) {
        this.assignment = newAssignment;
    }

    public SolutionStoreService getSolutionStoreService() {
        return solutionStoreService;
    }

    public void setSolutionStoreService(SolutionStoreService solutionStoreService) {
        this.solutionStoreService = solutionStoreService;
    }
}
