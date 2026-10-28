package com.athenea.ms_excepciones.controller;

import com.athenea.ms_excepciones.dto.ExcepcionResponse;
import com.athenea.ms_excepciones.service.ExcepcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/excepciones")
public class ExcepcionController {

    private final ExcepcionService excepcionService;

    public ExcepcionController(ExcepcionService excepcionService) {
        this.excepcionService = excepcionService;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ExcepcionResponse> buscarPorCodigo(@PathVariable String codigo) {
        return excepcionService.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
