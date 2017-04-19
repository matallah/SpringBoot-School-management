package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Assignment;
import cz.vse.xkadp12.services.AssignmentService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class AssignmentBean {

    @ManagedProperty(value = "#{assignmentService}")
    private AssignmentService assignmentService;

    private Assignment newAssignment;

    public AssignmentService getAssignmentService() {
        return assignmentService;
    }

    public void setAssignmentService(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    public Assignment getNewAssignment() {
        return newAssignment;
    }

    public void setNewAssignment(Assignment newAssignment) {
        this.newAssignment = newAssignment;
    }
}
