package com.athenea.ms_excepciones.service;

import com.athenea.ms_excepciones.dto.ExcepcionResponse;
import com.athenea.ms_excepciones.entity.AbExcepcion;
import com.athenea.ms_excepciones.repository.ExcepcionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExcepcionServiceTest {

    @Mock
    private ExcepcionRepository excepcionRepository;

    @InjectMocks
    private ExcepcionService excepcionService;

    @Test
    void buscarPorCodigoDevuelveElMensaje() {
        AbExcepcion guardada = new AbExcepcion();
        guardada.setCodigo("ERC-047");
        guardada.setCodigoHttp("409");
        guardada.setTipo("ERROR");
        guardada.setMensaje("El correo ya está registrado.");
        when(excepcionRepository.findByCodigo("ERC-047")).thenReturn(Optional.of(guardada));

        Optional<ExcepcionResponse> respuesta = excepcionService.buscarPorCodigo("ERC-047");

        assertThat(respuesta).isPresent();
        assertThat(respuesta.get().getCodigo()).isEqualTo("ERC-047");
        assertThat(respuesta.get().getMensaje()).isEqualTo("El correo ya está registrado.");
    }

    @Test
    void buscarPorCodigoVacioCuandoNoExiste() {
        when(excepcionRepository.findByCodigo("NO-EXISTE")).thenReturn(Optional.empty());

        Optional<ExcepcionResponse> respuesta = excepcionService.buscarPorCodigo("NO-EXISTE");

        assertThat(respuesta).isEmpty();
    }
}