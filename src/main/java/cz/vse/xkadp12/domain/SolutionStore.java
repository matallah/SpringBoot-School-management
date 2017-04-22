package cz.vse.xkadp12.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CB_SOLUTION_STORE")
public class SolutionStore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean opened = true;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Solution> solutions; // submitted
    @OneToOne
    private Assignment assignment;
    @OneToMany
    private List<StudyGroup> studyGroups;

    public SolutionStore() {
    }

    public SolutionStore(Assignment assignment) {
        this.opened = true;
        this.assignment = assignment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }
}
