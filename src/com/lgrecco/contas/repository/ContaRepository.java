package com.lgrecco.contas.repository;

import java.io.Serializable;

import br.com.caelum.contas.modelo.Conta;

public interface ContaRepository extends Repository<Conta, Serializable>{
	
	Conta buscaPorData(Conta conta);

}
