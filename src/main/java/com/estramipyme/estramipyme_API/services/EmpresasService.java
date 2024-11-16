package com.estramipyme.estramipyme_API.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estramipyme.estramipyme_API.Repositories.EmpresasRepository;
import com.estramipyme.estramipyme_API.models.Empresas;

@Service
public class EmpresasService {

    @Autowired
    private EmpresasRepository empresasRepository;

    public List<Empresas> getAllEmpresas() {
        return empresasRepository.findAll();
    }

    public Empresas getEmpresaById(Long id) {
        return empresasRepository.findById(id).orElse(null);
    }

    public Empresas saveEmpresa(Empresas empresa) {
        // Validamos si el Test asociado es nulo o su ID es nulo
        if (empresa.getTestId() == null || empresa.getTestId().getIdTest() == null) {
            throw new RuntimeException("El test no es válido.");
        }
        // Validamos si el Sector asociado es nulo o su ID es nulo
        if (empresa.getSector() == null || empresa.getSector().getId() == null) {
            throw new RuntimeException("El sector no es válido.");
        }
        // Si las validaciones son correctas, guardamos la empresa
        return empresasRepository.save(empresa);
    }
    
    public Empresas updateEmpresa(Long id, Empresas empresaDetails) {
        Empresas empresa = empresasRepository.findById(id).orElse(null);
        if (empresa != null) {
            // Actualizamos solo si el Test no es nulo
            if (empresaDetails.getTestId() != null) {
                empresa.setTestId(empresaDetails.getTestId());
            }
            // Actualizamos solo si el Sector no es nulo
            if (empresaDetails.getSector() != null) {
                empresa.setSector(empresaDetails.getSector());
            }
            // Actualizamos el nombre de la empresa y el tamaño de la compañía
            empresa.setNombreEmpresa(empresaDetails.getNombreEmpresa());
            empresa.setSizeCompany(empresaDetails.getSizeCompany());
            // Guardamos los cambios
            return empresasRepository.save(empresa);
        }
        return null;
    }
    

    public void deleteEmpresa(Long id) {
        empresasRepository.deleteById(id);
    }
}