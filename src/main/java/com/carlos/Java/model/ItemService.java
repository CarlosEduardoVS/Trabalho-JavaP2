package com.carlos.Java.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    
    @Autowired //cria a bagaca pra mim!
    ItemDAO idao;

    public void inserirItem(Item itm){
        idao.inserirItem(itm);
    }

    public List<Map<String,Object>> puxarTodosItens(){
        return idao.puxarTodosItens();
    }

    public Map<String,Object> puxaritem(int id){
        return idao.puxarItem(id);
    }

    public void atualizarItem(Item itm,int id){
        idao.atualizarItem(itm, id);
    }

    public void deletar(int id){
        idao.deletar(id);
    }
}
