package br.com.caelum.contas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.contas.modelo.Conta;

@Repository
public class ContaDaoImpl implements ContaDao {
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

	public void adiciona(Conta conta) {
		getEntityManager().persist(conta);

	}

	public void remove(Conta conta) {
		Conta contaRemover = buscaPorId(conta.getId());
		getEntityManager().remove(contaRemover);
	}

	public void altera(Conta conta) {
		getEntityManager().merge(conta);
	}

	@SuppressWarnings("unchecked")
	public List<Conta> lista() {
		return getEntityManager().createQuery("select c from Conta c")
				.getResultList();
	}

	public Conta buscaPorId(Long id) {
		return getEntityManager().find(Conta.class, id);
	}

	public void paga(Long id) {

		Conta conta = buscaPorId(id);
		conta.setPaga(true);
		conta.setDataPagamento(Calendar.getInstance());
		getEntityManager().merge(conta);
	}

}
