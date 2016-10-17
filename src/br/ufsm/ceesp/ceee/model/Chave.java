package br.ufsm.ceesp.ceee.model;

/**
 * Created by Alisson on 17/10/2016.
 */
public class Chave {

    private Long id;
    private String tipoUnidade;
    private String estado;
    private String telecomandada;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelecomandada() {
        return telecomandada;
    }

    public void setTelecomandada(String telecomandada) {
        this.telecomandada = telecomandada;
    }
}
