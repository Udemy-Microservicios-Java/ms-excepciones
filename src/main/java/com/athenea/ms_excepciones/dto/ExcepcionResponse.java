package com.athenea.ms_excepciones.dto;

public class ExcepcionResponse {

    private String codigo;
    private String codigoHttp;
    private String tipo;
    private String mensaje;

    public ExcepcionResponse() {
    }

    public ExcepcionResponse(String codigo, String codigoHttp, String tipo, String mensaje) {
        this.codigo = codigo;
        this.codigoHttp = codigoHttp;
        this.tipo = tipo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodigoHttp() {
        return codigoHttp;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensaje() {
        return mensaje;
    }
}
