package com.carlos.Java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Item {
    
    private int id;
    private String nome, descricao;

    public Item() {

    }


    public Item(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


    public Item(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Item converterUmItem (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String descricao = (String) registro.get("descricao");
        Item itm = new Item(id,nome,descricao);
        return itm;
    }

    public static List<Item> converterNItens(List<Map<String,Object>> registros){
        List<Item> aux = new ArrayList<Item>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmItem(reg));
        }
        return aux;
    }
}
