package br.com.caelum.contas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.contas.modelo.Conta;

@Transactional
@Repository
public class ContaDaoImpl implements ContaDao {
//	@Autowired
//	private EntityManagerFactory manager;

	@PersistenceContext
	private EntityManager manager;
	
	
//	protected EntityManager getEntityManager() {
//		return manager.createEntityManager();
//	}

	public void adiciona(Conta conta) {
		manager.persist(conta);

	}

	public void remove(Conta conta) {
		Conta contaRemover = buscaPorId(conta.getId());
		manager.remove(contaRemover);
	}

	public void altera(Conta conta) {
		manager.merge(conta);
	}

	@SuppressWarnings("unchecked")
	public List<Conta> lista() {
		return manager.createQuery("select c from Conta c")
				.getResultList();
	}

	public Conta buscaPorId(Long id) {
		return manager.find(Conta.class, id);
	}

	public void paga(Long id) {

		Conta conta = buscaPorId(id);
		conta.setPaga(true);
		conta.setDataPagamento(Calendar.getInstance());
		manager.merge(conta);
	}

}
