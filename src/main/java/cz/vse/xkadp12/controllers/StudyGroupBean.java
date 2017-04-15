package cz.vse.xkadp12.controllers;

import cz.vse.xkadp12.domain.Student;
import cz.vse.xkadp12.domain.StudyGroup;
import cz.vse.xkadp12.services.StudentService;
import cz.vse.xkadp12.services.StudyGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudyGroupBean {

    Logger logger = LoggerFactory.getLogger(StudyGroupBean.class);

    @ManagedProperty(value =  "#{studentService}")
    private StudentService studentService;
    @ManagedProperty(value = "#{studyGroupService}")
    private StudyGroupService studyGroupService;

    private List<StudyGroup> studyGroups;
    private StudyGroup studyGroup = new StudyGroup();

    @PostConstruct
    public void loadStudyGroups() {
        logger.debug("Post construct called..." + this.getClass().getName());
        studyGroups = studyGroupService.findAll();
    }

    public List<StudyGroup> getStudyGroups() {
        if(studyGroups.isEmpty()) {
            StudyGroup dummyStudyGroup1 = new StudyGroup("Test Stduy group 1");
            StudyGroup dummyStudyGroup2 = new StudyGroup("Test Stduy group 2");
            StudyGroup dummyStudyGroup3 = new StudyGroup("Test Stduy group 3");
            studyGroups.addAll(Arrays.asList(dummyStudyGroup1, dummyStudyGroup2, dummyStudyGroup3));
        } else {
            studyGroups = studyGroupService.findAll();
        }

        return studyGroups;
    }

    public List<Student> getStudentsForStudyGroup(String studdyGroupName) {
       return studentService.findByClassName(studdyGroupName);
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public StudyGroupService getStudyGroupService() {
        return studyGroupService;
    }

    public void setStudyGroupService(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    public String saveStudyGroup() {
        logger.info("Saving StudyGroup: " + studyGroup.toString());
        if(studyGroup == null) {
            FacesContext.getCurrentInstance().addMessage("Name is required", new FacesMessage("Please provide a valid student group name"));
            return "overview";
        }
        studyGroupService.saveStudyGroup(studyGroup);
        logger.info("Study group successfully saved...");
        studyGroup = new StudyGroup();
        return "overview";
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }
}
