package cz.vse.xkadp12.domain;

import javax.persistence.*;

@Entity
@Table(name = "CB_SOLUTION")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student author;

    public Solution() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getAuthor() {
        return author;
    }

    public void setAuthor(Student author) {
        this.author = author;
    }
}
