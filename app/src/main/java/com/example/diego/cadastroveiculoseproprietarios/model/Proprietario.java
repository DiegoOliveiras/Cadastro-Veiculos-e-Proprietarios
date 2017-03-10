package com.example.diego.cadastroveiculoseproprietarios.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Diego on 10/03/2017.
 */

public class Proprietario extends SugarRecord {
    private String nome;
    private String endereco;
    private String telefone;
    private String data;

    public Proprietario(){

    }

    public Proprietario(String nome, String endereco, String telefone, String data){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() { return data; }

    public void setData(String data) {
        this.data = data;
    }
}
