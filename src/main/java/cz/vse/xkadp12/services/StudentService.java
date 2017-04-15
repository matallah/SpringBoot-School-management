package cz.vse.xkadp12.services;

import cz.vse.xkadp12.domain.Student;
import cz.vse.xkadp12.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 7.4.2017.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return (List) studentRepository.findAll();
    }

    public List<Student> findByClassName(String studyGroupName) {
        return (List) studentRepository.findByStudyGroupName(studyGroupName);
    }
}
