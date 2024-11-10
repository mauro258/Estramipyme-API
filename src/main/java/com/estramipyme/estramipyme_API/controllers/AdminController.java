package com.estramipyme.estramipyme_API.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estramipyme.estramipyme_API.models.Admin;
import com.estramipyme.estramipyme_API.services.AdminService;

@RestController
@RequestMapping("/api/administradores")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAdmins() {
        try {
            List<Admin> admins = adminService.findAll();
            return ResponseEntity.ok(admins);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Ocurrió un error inesperado al obtener los administradores");
        }
    }

     @GetMapping("/{id}")
    public ResponseEntity<?> getAdminById(@PathVariable Long id) {
        try {
            Admin admin = adminService.findById(id);
            if (admin == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                     .body("Administrador no encontrado con ID: " + id);
            }
            return ResponseEntity.ok(admin);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Ocurrió un error inesperado");
        }
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        try {
            Admin savedAdmin = adminService.save(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }

    @PutMapping("/{id}")
public ResponseEntity<?> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
    try {
        Admin existing = adminService.findById(id);
        if (existing != null) {
            admin.setId(id);
            Admin updatedAdmin = adminService.save(admin);
            return ResponseEntity.ok(updatedAdmin);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Administrador con ID " + id + " no encontrado.");
    } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Ocurrió un error inesperado al intentar actualizar el administrador.");
    }
}



@DeleteMapping("/{id}")
public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
    try {
        Admin existing = adminService.findById(id);
        if (existing != null) {
            adminService.deleteById(id);
            return ResponseEntity.ok("Administrador con ID " + id + " eliminado correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Administrador con ID " + id + " no encontrado.");
    } catch (Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Ocurrió un error inesperado al intentar eliminar el administrador.");
    }
}

}
