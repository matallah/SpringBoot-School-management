package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Student;
import cz.vse.xkadp12.domain.StudyGroup;
import cz.vse.xkadp12.services.StudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 7.4.2017.
 */
@ManagedBean
@SessionScoped
public class StudentBean {

    @ManagedProperty(value = "#{studentService}")
    private StudentService studentService;

    private List<Student> studnets = new ArrayList<>();
    private List<Student> selectedStudents = new ArrayList<>();

    @PostConstruct
    public void loadStudents() {
        studnets = studentService.findAll();
    }

    public List<Student> getStudnets() {
        if(studnets.isEmpty()) {

            StudyGroup studyGroup = new StudyGroup("Study group 1");
            StudyGroup studyGroup1 = new StudyGroup("Study group 2");

            Student student1 = new Student("Petr Kadlec", studyGroup);
            Student student2 = new Student("John Doe", studyGroup);
            Student student3 = new Student("Obi-Wan Kenobi", studyGroup1);
            Student student4 = new Student("Alois Jirasek", studyGroup1);

            this.studnets.addAll(Arrays.asList(student1, student2, student3, student4));
        }
        return studnets;
    }

    public void setStudnets(List<Student> studnets) {
        this.studnets = studnets;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    public void setSelectedStudents(List<Student> selectedStudents) {
        this.selectedStudents = selectedStudents;
    }
}
