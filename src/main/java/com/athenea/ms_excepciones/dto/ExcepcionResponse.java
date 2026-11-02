package com.athenea.ms_excepciones.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcepcionResponse {

    private String codigo;
    private String codigoHttp;
    private String tipo;    
    private String mensaje;
}
