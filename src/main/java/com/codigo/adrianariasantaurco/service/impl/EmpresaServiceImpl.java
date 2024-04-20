package com.codigo.adrianariasantaurco.service.impl;

import com.codigo.adrianariasantaurco.constants.Constants;
import com.codigo.adrianariasantaurco.dao.EmpresaRepository;
import com.codigo.adrianariasantaurco.entity.EmpresaEntity;
import com.codigo.adrianariasantaurco.request.EmpresaRequest;
import com.codigo.adrianariasantaurco.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private EmpresaRepository empresaRepository;

    @Override
    public EmpresaEntity crear(EmpresaRequest request) {
        EmpresaEntity empresa = new EmpresaEntity();

        return empresaRepository.save(setValuesEmp(request, empresa, Constants.CREATE));
    }

    @Override
    public EmpresaEntity buscarxId(Long id) {
        if (empresaRepository.existsById(id)) {
            return empresaRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public List<EmpresaEntity> buscarAll() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaRequest request) {
        if (empresaRepository.existsById(id)) {
            Optional<EmpresaEntity> empresaEntity = empresaRepository.findById(id);
            return empresaRepository.save(setValuesEmp(
                    request, empresaEntity.get(), Constants.UPDATE));
        }

        return null;
    }


    @Override
    public EmpresaEntity borrar(Long id) {
        if (empresaRepository.existsById(id)) {
            Optional<EmpresaEntity> empresaEntity = empresaRepository.findById(id);

            return empresaRepository.save(setValuesEmp(
                    null, empresaEntity.get(), Constants.DELETE));
        }

        return null;
    }


    private EmpresaEntity setValuesEmp(EmpresaRequest empresaRequest,
                                       EmpresaEntity empresa,
                                       String action) {

        if(empresaRequest != null) {
            empresa.setRazonSocial(empresaRequest.getRazonSocial());
            empresa.setTipoDocumento(empresaRequest.getTipoDocumento());
            empresa.setNumeroDocumento(empresaRequest.getNumeroDocumento());
            empresa.setCondicion(empresaRequest.getCondicion());
            empresa.setDireccion(empresaRequest.getDireccion());
            empresa.setDistrito(empresaRequest.getDistrito());
            empresa.setProvincia(empresaRequest.getProvincia());
            empresa.setDepartamento(empresaRequest.getDepartamento());
            empresa.setEsAgenteRetencion(empresaRequest.isEsAgenteRetencion());
        }

        switch (action) {
            case "CREATE" -> {
                empresa.setEstado(Constants.ACTIVE);
                empresa.setUsuaCrea(Constants.ADMIN);
                empresa.setDateCreate(getTimeStamp());
            }
            case "UPDATE" -> {
                empresa.setUsuaModif(Constants.ADMIN);
                empresa.setDateModif(getTimeStamp());
            }
            case "DELETE" -> {
                empresa.setEstado(Constants.INACTIVE);
                empresa.setUsuaDelet(Constants.ADMIN);
                empresa.setDateDelet(getTimeStamp());
            }
        }

        return empresa;
    }


    private Timestamp getTimeStamp() {
        long currentTime = System.currentTimeMillis();
        return new Timestamp(currentTime);
    }
}