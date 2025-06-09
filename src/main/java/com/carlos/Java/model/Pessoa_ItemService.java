package com.carlos.Java.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pessoa_ItemService {

@Autowired //cria a bagaca pra mim!
    Pessoa_ItemDAO psidao;

    public void inserirPessoa_item(Pessoa_Item psi){
        psidao.inserirPessoa_item(psi);
    }

    public List<Map<String,Object>> puxarTodosPessoa_Item(){
        return psidao.puxarTodosPessoa_item();
    }

    public Map<String,Object> puxarPessoa_Item(int id){
        return psidao.puxarPessoa_item(id);
    }

    public void atualizarPessoa_Item(Pessoa_Item psi,int id){
        psidao.atualizarPessoa(psi, id);
    }

    public void deletar(int id){
        psidao.deletar(id);
    }
    
}
