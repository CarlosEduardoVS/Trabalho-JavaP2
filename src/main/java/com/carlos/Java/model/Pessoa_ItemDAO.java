package com.carlos.Java.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class Pessoa_ItemDAO {
    
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    	@PostConstruct
	    private void initialize() {
		    jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirPessoa_item(Pessoa_Item psi){
        String sql = "INSERT INTO pessoa_item (pessoa_id, item_id) VALUES (?,?)";
        Object[] dados = new Object[2];
        dados[0] = psi.getPessoa_id();
        dados[1] = psi.getItem_id();
        jdbc.update(sql, dados);
    }

    public List<Map<String,Object>> puxarTodosPessoa_item(){
        String sql = "SELECT pi.id, p.nome as nome_pessoa, i.nome as nome_item FROM pessoa_item as pi INNER JOIN pessoa as p on pi.pessoa_id = p.id INNER JOIN item as i on pi.item_id = i.id ORDER BY i.nome";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarPessoa_item(int id){
        String sql = "SELECT * FROM pessoa_item WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM pessoa_item where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarPessoa(Pessoa_Item psi, int id){
        String sql = "UPDATE pessoa_item SET pessoa_id = ?, item_id = ? WHERE id = ?";
        Object[] dados = new Object[3];
        dados[0] = psi.getPessoa_id();
        dados[1] = psi.getItem_id();
        dados[2] = id;
        jdbc.update(sql, dados);
    }
}
