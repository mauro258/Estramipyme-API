package com.estramipyme.estramipyme_API.services;

import java.util.List;


import com.estramipyme.estramipyme_API.Repositories.TestRepository;
import com.estramipyme.estramipyme_API.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estramipyme.estramipyme_API.Repositories.EmpresasRepository;
import com.estramipyme.estramipyme_API.models.Empresas;

@Service
public class EmpresasService {

    @Autowired
    private EmpresasRepository empresasRepository;
    @Autowired
    private TestRepository testRepository;


    public List<Empresas> getAllEmpresas() {
        return empresasRepository.findAll();
    }

    public Empresas getEmpresaById(Long id) {
        return empresasRepository.findById(id).orElse(null);
    }
//crear
public Empresas saveEmpresa(Empresas empresa) {
    // Busca y establece la relación Test
    if (empresa.getTest() != null) {
        Test test = testRepository.findById(empresa.getTest().getIdTest()).orElse(null);
        empresa.setTest (test);
    }

    return empresasRepository.save(empresa);
}


    public Empresas updateEmpresa(Long id, Empresas empresaDetails) {
        Empresas empresa = empresasRepository.findById(id).orElse(null);
        if (empresa != null) {
            empresa.setNombreEmpresa(empresaDetails.getNombreEmpresa());
            empresa.setSizeCompany(empresaDetails.getSizeCompany());
            empresa.setTest(empresaDetails.getTest());
            empresa.setSector(empresaDetails.getSector()); 
            return empresasRepository.save(empresa);
        }
        return null;
    }

    public void deleteEmpresa(Long id) {
        empresasRepository.deleteById(id);
    }
}