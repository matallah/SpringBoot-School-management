package cz.vse.xkadp12.services;

import cz.vse.xkadp12.domain.StudyGroup;
import cz.vse.xkadp12.repositories.StudyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository studyGroupRepository;

    public List<StudyGroup> findAll(){
        return (List) studyGroupRepository.findAll();
    }

}
