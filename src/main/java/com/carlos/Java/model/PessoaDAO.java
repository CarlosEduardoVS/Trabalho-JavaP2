package com.carlos.Java.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PessoaDAO {
    
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    	@PostConstruct
	    private void initialize() {
		    jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirPessoa(Pessoa pes){
        String sql = "INSERT INTO pessoa (nome, email) VALUES (?,?)";
        Object[] dados = new Object[2];
        dados[0] = pes.getNome();
        dados[1] = pes.getEmail();
        jdbc.update(sql, dados);
    }

    public List<Map<String,Object>> puxarTodosPessoas(){
        String sql = "SELECT * FROM pessoa;";
        return jdbc.queryForList(sql);
    } 

    public Map<String,Object> puxarPessoa(int id){
        String sql = "SELECT * FROM pessoa WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

    public void deletar(int id){
        String sql = "DELETE FROM pessoa where id = ?;";
        jdbc.update(sql, id);
    }

    public void atualizarPessoa(Pessoa pes, int id){
        String sql = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
        Object[] dados = new Object[3];
        dados[0] = pes.getNome();
        dados[1] = pes.getEmail();
        dados[2] = id;
        jdbc.update(sql, dados);
    }
}
