package br.com.caelum.contas.dao;

import br.com.caelum.contas.modelo.Usuario;

public interface UsuarioDao {
	
	boolean existeUsuario(Usuario usuario);
	void insere(Usuario usuario);
}

