package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Assignment;
import cz.vse.xkadp12.services.AssignmentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class AssignmentBean {

    @ManagedProperty(value = "#{assignmentService}")
    private AssignmentService assignmentService;

    private Assignment assignment = new Assignment();

    public void saveAssignment() {
        assignmentService.saveAssignment(assignment);
        resetAssignment();
        // send email
    }

    private void resetAssignment() {
        this.assignment = new Assignment();
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
}
