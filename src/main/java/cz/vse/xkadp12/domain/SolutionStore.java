package cz.vse.xkadp12.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CB_SOLUTION_STORE")
public class SolutionStore {

    @Id
    private Long id;
    private boolean opened = true;

    public SolutionStore() {
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
}
