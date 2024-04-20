package com.codigo.adrianariasantaurco.controller;

import com.codigo.adrianariasantaurco.entity.EmpresaEntity;
import com.codigo.adrianariasantaurco.request.EmpresaRequest;
import com.codigo.adrianariasantaurco.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practica/empresa")
@AllArgsConstructor
@Tag(
        name = "API PARA LA CREACIÓN DE EMPRESAS",
        description = "Esta api te permite crear, modificar, obtener y eliminar empresas."
)
public class EmpresaController {

    private EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(
            summary = "Crear una nueva empresa",
            description = "Para usar este endPoint tienes que enviar un objeto empresa, el cual se guardara en Base de datos"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empresa creada exitosamente",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Request mal realizado",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaRequest request) {
        return ResponseEntity.ok(empresaService.crear(request));
    }

    @GetMapping("/buscarxId/{id}")
    @Operation(
            summary = "Buscar una nueva empresa por medio de ID",
            description = "Para usar este endPoint tienes que enviar el ID de una empresa por la URL"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empresa encontrada",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Request mal realizado",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.buscarxId(id));
    }

    @PutMapping("/actualizar/{id}")
    @Operation(
            summary = "Actualizar los datos de una empresa ubicándola por medio de su ID",
            description = "Para usar este endPoint tienes que enviar el ID de una empresa por la URL y" +
                    " los datos campos a actualizar en formato json"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Datos de la empresa actualizados exitosamente",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Request mal realizado",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id,
                                                    @RequestBody EmpresaRequest request) {
        return ResponseEntity.ok(empresaService.actualizar(id, request));
    }

    @DeleteMapping("/borrar/{id}")
    @Operation(
            summary = "Eliminar(eliminado lógico) una empresa ubicándola por medio de su ID",
            description = "Para usar este endPoint tienes que enviar el ID de una empresa por la URL"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empresa eliminada exitosamente",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Request mal realizado",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<EmpresaEntity> borrar(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.borrar(id));
    }

    @GetMapping("/buscarall")
    @Operation(
            summary = "Buscar todas las empresas existentes en la base de datos",
            description = "Para usar este endPoint no necesitas ninguna variable"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de empresa obtenida exitosamente",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = EmpresaEntity.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Request mal realizado",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<EmpresaEntity>> buscarAll() {
        return ResponseEntity.ok(empresaService.buscarAll());
    }
}
