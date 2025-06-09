package com.carlos.Java.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ItemDAO {
    
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    	@PostConstruct
	    private void initialize() {
		    jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirItem(Item itm){
        String sql = "INSERT INTO item (nome, descricao) VALUES (?,?)";
        Object[] dados = new Object[2];
        dados[0] = itm.getNome();
        dados[1] = itm.getDescricao();
        jdbc.update(sql, dados);
    }

    public List<Map<String,Object>> puxarTodosItens(){
        String sql = "SELECT * FROM item;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarItem(int id){
        String sql = "SELECT * FROM item WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM item where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarItem(Item itm, int id){
        String sql = "UPDATE item SET nome = ?, descricao = ? WHERE id = ?";
        Object[] dados = new Object[3];
        dados[0] = itm.getNome();
        dados[1] = itm.getDescricao();
        dados[2] = id;
        jdbc.update(sql, dados);
    }
}
