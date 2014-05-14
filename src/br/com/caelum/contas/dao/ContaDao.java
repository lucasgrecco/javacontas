package br.com.caelum.contas.dao;

import java.util.List;

import br.com.caelum.contas.modelo.Conta;

public interface ContaDAO {

	Conta buscaPorId(Long id);

	List<Conta> lista();

	void adiciona(Conta t);

	void altera(Conta t);

	void remove(Conta t);

	void paga(Long id);
}
