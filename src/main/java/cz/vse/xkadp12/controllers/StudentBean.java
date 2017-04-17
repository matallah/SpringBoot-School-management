package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Student;
import cz.vse.xkadp12.domain.StudyGroup;
import cz.vse.xkadp12.services.StudentService;
import cz.vse.xkadp12.utils.FacesMessageFactory;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentBean {

    @ManagedProperty(value = "#{studentService}")
    private StudentService studentService;

    private Student student = new Student();
    private List<Student> students = new ArrayList<>();
    private List<Student> selectedStudents = new ArrayList<>();

    @PostConstruct
    public void loadStudents() {
        students = studentService.findAll();
    }

    public List<Student> getStudents() {
        return students;
    }

    public String saveStudent() {
        studentService.saveStudent(student);
        students = studentService.findAll();
        student = new Student();
        FacesContext.getCurrentInstance().addMessage(null, FacesMessageFactory.saveSuccessfull());
        return "studentsOverview";
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
