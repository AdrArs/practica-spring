package com.codigo.adrianariasantaurco.service;

import com.codigo.adrianariasantaurco.entity.EmpresaEntity;
import com.codigo.adrianariasantaurco.request.EmpresaRequest;

import java.util.List;

public interface EmpresaService {
    EmpresaEntity crear(EmpresaRequest empresaRequest);
    EmpresaEntity buscarxId(Long id);
    List<EmpresaEntity> buscarAll();
    EmpresaEntity actualizar(Long id, EmpresaRequest empresaRequest);
    EmpresaEntity borrar(Long id);
}
