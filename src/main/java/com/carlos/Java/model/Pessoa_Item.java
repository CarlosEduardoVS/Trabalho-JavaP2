package com.carlos.Java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pessoa_Item {
    
    private int id, pessoa_id, item_id;
    private String nome_pessoa, nome_item;

    public Pessoa_Item() {

    }

    public Pessoa_Item(int item_id, int pessoa_id) {
        this.item_id = item_id;
        this.pessoa_id = pessoa_id;
    }

    public Pessoa_Item(int id, int item_id, int pessoa_id) {
        this.id = id;
        this.pessoa_id = pessoa_id;
        this.item_id = item_id;
    }

    public Pessoa_Item(int id, String nome_pessoa, String nome_item) {
        this.id = id;
        this.nome_pessoa = nome_pessoa;
        this.nome_item = nome_item;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public String getNome_item() {
        return nome_item;
    }

    public int getId() {
        return id;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public static Pessoa_Item converterUmLigacao (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome_pessoa = (String) registro.get("nome_pessoa");
        String nome_item = (String) registro.get("nome_item");
        Pessoa_Item psi = new Pessoa_Item(id,nome_pessoa,nome_item);
        return psi;
    }

    public static Pessoa_Item converterUmLigacao2 (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        int pessoa_id = (Integer) registro.get("pessoa_id");
        int item_id = (Integer) registro.get("item_id");
        Pessoa_Item psi = new Pessoa_Item(id,pessoa_id,item_id);
        return psi;
    }

    public static List<Pessoa_Item> converterNLigacao(List<Map<String,Object>> registros){
        List<Pessoa_Item> aux = new ArrayList<Pessoa_Item>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmLigacao(reg));
        }
        return aux;
    }
}
