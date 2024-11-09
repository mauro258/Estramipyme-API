package com.estramipyme.estramipyme_API.services;

import com.estramipyme.estramipyme_API.Repositories.TeacherRepository;
import com.estramipyme.estramipyme_API.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    //consulta varios
    public List<Teacher> getTeachers(){
        return teacherRepo.findAll();
    }
    //consulta por Id
    public  Teacher getTeacherId(Long id){
        return teacherRepo.findById(id).orElse(null);
    }
    //crea profesores
    public  Teacher addTeacher(Teacher teacher){
        return teacherRepo.save(teacher);
    }
    //Edita profesores
    public  Teacher updateTeacher(Teacher teacher){
        return  teacherRepo.save(teacher);
    }
    //Elimina profe
    public  void deleteTeacherId (Long id){
        teacherRepo.deleteById(id);
    }


}
