package com.carlos.Java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pessoa {
    
    private int id;
    private String nome, email;

    public Pessoa() {

    }
    //insert
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    //select
    public Pessoa(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public static Pessoa converterUmPessoa (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String email = (String) registro.get("email");
        Pessoa pes = new Pessoa(id,nome,email);
        return pes;
    }

    public static List<Pessoa> converterNPessoas(List<Map<String,Object>> registros){
        List<Pessoa> aux = new ArrayList<Pessoa>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmPessoa(reg));
        }
        return aux;
    }
}

