package br.com.caelum.contas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InfraController {
	
	private Connection connection;
	
	@Autowired
	public InfraController(DataSource ds){
		try {
			this.connection = ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@RequestMapping("/tabelas")
	public String criaBanco() throws SQLException {

		PreparedStatement st1 = this.connection.prepareStatement("DROP TABLE IF EXISTS contas");
		st1.execute();

		PreparedStatement st11 = this.connection.prepareStatement("create table contas (id int, descricao varchar(255), valor double, paga boolean, dataPagamento datetime, tipo varchar(20), PRIMARY KEY (id))");
		st11.execute();
		
		PreparedStatement st2 = this.connection.prepareStatement("DROP TABLE IF EXISTS usuarios");
		st2.execute();

		PreparedStatement st22 = this.connection.prepareStatement("create table usuarios (login VARCHAR(255),senha VARCHAR(255));");
		st22.execute();

		PreparedStatement st3 = this.connection.prepareStatement("insert into usuarios (login, senha) values ('admin', 'admin');");
		st3.execute();
		
		this.connection.close();
		
		return "infra-ok";

	}
}
