package com.fuimonosapp.service;

import com.fuimonosapp.domain.Departamento;
import com.fuimonosapp.domain.Municipio;
import com.fuimonosapp.repository.DepartamentoRepository;
import com.fuimonosapp.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MunicipiosService {

    private final DepartamentoRepository departamentoRepository;
    private final MunicipioRepository municipioRepository;

    private static final Integer PAGE_SIZE = 10;

    @Autowired
    public MunicipiosService(DepartamentoRepository departamentoRepository,
                             MunicipioRepository municipioRepository) {
        this.departamentoRepository = departamentoRepository;
        this.municipioRepository = municipioRepository;
    }

    @Transactional
    public Page<Municipio> obtenerMunicipiosPor(Integer departamentoId, Integer currentPage) {
        Departamento departamento = departamentoRepository.getOne(departamentoId);
        return municipioRepository.findByDepartamento(departamento, PageRequest.of(currentPage, PAGE_SIZE));
    }

    @Transactional
    public void save(Municipio municipio) {
        municipioRepository.save(municipio);
    }

    @Transactional
    public void delete(Integer municipioId) {
        municipioRepository.deleteById(municipioId);
    }

}
