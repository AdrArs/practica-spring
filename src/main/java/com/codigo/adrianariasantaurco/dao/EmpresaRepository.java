package com.codigo.adrianariasantaurco.dao;

import com.codigo.adrianariasantaurco.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
