package com.codigo.adrianariasantaurco.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaRequest {

    private String razonSocial;
    private char tipoDocumento;
    private String numeroDocumento;
    private String condicion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private boolean esAgenteRetencion;
}
