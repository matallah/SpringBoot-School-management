package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Solution;
import cz.vse.xkadp12.domain.SolutionStore;
import cz.vse.xkadp12.domain.StudyGroup;
import cz.vse.xkadp12.services.SolutionStoreService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class SolutionStoreBean {

    @ManagedProperty(value = "#{solutionStoreService}")
    private SolutionStoreService solutionStoreService;

    private SolutionStore solutionStore;
    private List<SolutionStore> solutionStores = new ArrayList<>();

    @PostConstruct
    public void init() {
        solutionStores = solutionStoreService.findAll();
    }

    public List<SolutionStore> getSolutionStores() {
        solutionStores = solutionStoreService.findAll();
        return solutionStores;
    }

    public SolutionStore getSolutionStore() {
        return solutionStore;
    }

    public void setSolutionStore(SolutionStore solutionStore) {
        this.solutionStore = solutionStore;
    }

    public SolutionStore getSolutionStoreByAssignmentId(Long assignmentId) {
        return solutionStoreService.findByAssignmentId(assignmentId);
    }

    public void setSolutionStores(List<SolutionStore> solutionStores) {
        this.solutionStores = solutionStores;
    }

    public SolutionStoreService getSolutionStoreService() {
        return solutionStoreService;
    }

    public void setSolutionStoreService(SolutionStoreService solutionStoreService) {
        this.solutionStoreService = solutionStoreService;
    }
}
