package com.estramipyme.estramipyme_API.controllers;

import com.estramipyme.estramipyme_API.models.Teacher;
import com.estramipyme.estramipyme_API.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //consulta todos
    @GetMapping
    public List<Teacher> getAll(){
        return  teacherService.getTeachers();
    }
    //consul Id
    @GetMapping ("{id}")
    public Teacher getId(@PathVariable Long id) {
        return teacherService.getTeacherId(id);
    }
    //crear teacher
    @PostMapping
    public  Teacher create (@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }
    //Actualizar
    @PutMapping ("/{id}")
    public Teacher updateTeacher (@RequestBody Teacher teacher, @PathVariable Long id){
        teacher.setIdTeacher(id);
        return teacherService.updateTeacher(teacher);
    }
    //delete
    @DeleteMapping("/{id}")
    public  void  deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherId(id);
    }
}
