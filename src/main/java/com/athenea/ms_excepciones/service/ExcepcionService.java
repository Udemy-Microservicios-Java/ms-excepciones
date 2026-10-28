package com.athenea.ms_excepciones.service;

import com.athenea.ms_excepciones.dto.ExcepcionResponse;
import com.athenea.ms_excepciones.repository.ExcepcionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ExcepcionService {

    private final ExcepcionRepository excepcionRepository;

    public ExcepcionService(ExcepcionRepository excepcionRepository) {
        this.excepcionRepository = excepcionRepository;
    }

    @Transactional(readOnly = true)
    public Optional<ExcepcionResponse> buscarPorCodigo(String codigo) {
        return excepcionRepository.findByCodigo(codigo)
                .map(excepcion -> new ExcepcionResponse(
                        excepcion.getCodigo(),
                        excepcion.getCodigoHttp(),
                        excepcion.getTipo(),
                        excepcion.getMensaje()));
    }
}
