package com.carlos.Java.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    //pergunta para o edu dps
    @Autowired //cria a bagaca pra mim!
    PessoaDAO pdao;

    public void inserirPessoa(Pessoa pes){
        pdao.inserirPessoa(pes);
    }

    public List<Map<String,Object>> puxarTodosPessoas(){
        return pdao.puxarTodosPessoas();
    }

    public Map<String,Object> puxarPessoa(int id){
        return pdao.puxarPessoa(id);
    }

    public void atualizarPessoa(Pessoa pes,int id){
        pdao.atualizarPessoa(pes, id);
    }

    public void deletar(int id){
        pdao.deletar(id);
    }
}
