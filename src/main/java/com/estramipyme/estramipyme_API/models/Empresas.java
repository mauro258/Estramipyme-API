package com.estramipyme.estramipyme_API.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empresa", nullable = false)
    private String nombreEmpresa;

    @Column(name = "size_company")
    private int sizeCompany;

    @Column(name = "test_id")
    private Long testId;

   
   @JoinColumn(name = "sector_id")
    private int sector;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getSizeCompany() {
        return sizeCompany;
    }

    public void setSizeCompany(int sizeCompany) {
        this.sizeCompany = sizeCompany;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public int getSector() {
   return sector;
    }

   public void setSector(int sector) {
   this.sector = sector;
   }
}

    