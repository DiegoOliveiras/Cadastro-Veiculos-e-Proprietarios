package com.example.diego.cadastroveiculoseproprietarios.model;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Diego on 10/03/2017.
 */

public class Veiculo extends SugarRecord {
    @Unique
    private Long id;

    private String placa;
    private String modelo;
    private String ano;
    private Proprietario proprietario;

    public Veiculo(){}

    public Veiculo(String modelo, String ano, String placa, Proprietario proprietario){
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
