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
        return empresasRepository.save(empresa);
    }

    public Empresas updateEmpresa(Long id, Empresas empresaDetails) {
        Empresas empresa = empresasRepository.findById(id).orElse(null);
        if (empresa != null) {
            empresa.setNombreEmpresa(empresaDetails.getNombreEmpresa());
            empresa.setSizeCompany(empresaDetails.getSizeCompany());
            empresa.setTestId(empresaDetails.getTestId());
            empresa.setSector(empresaDetails.getSector()); 
            return empresasRepository.save(empresa);
        }
        return null;
    }

    public void deleteEmpresa(Long id) {
        empresasRepository.deleteById(id);
    }
}