package com.estramipyme.estramipyme_API.controllers;

import com.estramipyme.estramipyme_API.Repositories.StudentRepository;
import com.estramipyme.estramipyme_API.models.Students;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentRepository studentRepository;

    // Obtener todos los estudiantes
    @GetMapping
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    // Obtener un estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable Integer id) {
        Optional<Students> student = studentRepository.findById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo estudiante
    @PostMapping
    public Students createStudent(@RequestBody Students student) {
        return studentRepository.save(student);
    }

    // Actualizar un estudiante
    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable Integer id, @RequestBody Students studentDetails) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Students updatedStudent = student.get();
            updatedStudent.setNombre(studentDetails.getNombre());
            updatedStudent.setApellido(studentDetails.getApellido());

            // Gestionar el Optional de email
            studentDetails.getEmail().ifPresent(updatedStudent::setEmail);

            // Gestionar el Optional de telefono
            studentDetails.getTelefono().ifPresent(updatedStudent::setTelefono);

            updatedStudent.setPassword(studentDetails.getPassword());
            updatedStudent.setTypeUserId(studentDetails.getTypeUserId());
            updatedStudent.setEmpresaId(studentDetails.getEmpresaId());

            studentRepository.save(updatedStudent);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        Optional<Students> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
