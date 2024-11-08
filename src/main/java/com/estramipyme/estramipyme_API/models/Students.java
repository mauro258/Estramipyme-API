package com.estramipyme.estramipyme_API.models;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private Long type_user_id;
    private Long empresa_id;

    // Ejemplo de un atributo relacionado como lista
    @ElementCollection
    private List<String> cursos;

    // Constructor vacío
    public Students() {}

    // Constructor con todos los campos
    public Students(String nombre, String apellido, String email, String password, String telefono, Long type_user_id, Long empresa_id, List<String> cursos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.type_user_id = type_user_id;
        this.empresa_id = empresa_id;
        this.cursos = cursos;
    }

    // Métodos getters y setters

    public Integer getStudentId() {
        return student_id;
    }

    public void setStudentId(Integer student_id) {
        this.student_id = student_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getTypeUserId() {
        return type_user_id;
    }

    public void setTypeUserId(Long type_user_id) {
        this.type_user_id = type_user_id;
    }

    public Long getEmpresaId() {
        return empresa_id;
    }

    public void setEmpresaId(Long empresa_id) {
        this.empresa_id = empresa_id;
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }
}