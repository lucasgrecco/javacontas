package br.com.caelum.contas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.contas.modelo.Usuario;

@Repository
public class UsuarioDaoImpl {
	
	@Autowired
	private EntityManagerFactory manager;

	@PersistenceUnit
//	@PersistenceContext(unitName="contas-unit")
	public void setEntityManagerFactory(EntityManagerFactory manager) {
		this.manager = manager;
	}

	protected EntityManager getEntityManager() {
		return manager.createEntityManager();
	}
	
	@SuppressWarnings("unused")
	public boolean existeUsuario(Usuario usuario) {
		boolean encontrado = false;
		Usuario bUsuario = getEntityManager().find(Usuario.class, usuario.getId());
		
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário nao deve ser nulo");
		}
		
		if(bUsuario != null){
			encontrado =  true;
		}
		
		return encontrado;
	}

	public void insere(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário nao deve ser nulo");
		}
		
		getEntityManager().persist(usuario);
	}
}

