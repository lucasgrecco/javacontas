package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

//@Transactional
@Controller
public class ContaController {
	
	@Autowired
	private ContaDAO contaDao;

//	@Autowired //Spring vai fazer a inejção
//	public ContaController(ContaDAO contaDao) {
//		this.contaDao = contaDao;
//	}

	@RequestMapping("/formulario-adiciona-conta")
	public String formulario() {
		return "conta/formulario";
	}
	
	@RequestMapping("/adiciona-conta")
	public String adicionaConta(@Valid Conta conta, BindingResult result) {

		if (!result.hasFieldErrors("descricao")) {
			contaDao.adiciona(conta);
		}
		return "conta/formulario";
		// Importante, se feito o redirect, a mensagem
		// de erro não é exibida.
		// return "redirect:/formulario-adiciona-conta";
	}
	
	@RequestMapping("/remove-conta")
	public String removeConta(Conta conta) {
		contaDao.remove(conta);

		return "redirect:lista-contas";
	}

	@RequestMapping("/paga-conta")
	public void finaliza(Long id, HttpServletResponse response) {
		contaDao.paga(id);
		response.setStatus(200);
	}
	
	@RequestMapping("/mostra-conta")
	public String mostra(Long id, Model model) {
		model.addAttribute("conta", contaDao.buscaPorId(id));
		return "conta/mostra-conta";
	}

	@RequestMapping("/altera-conta")
	public String altera(Conta contList<Conta> lista();a) {
		contaDao.altera(conta);
		return "redirect:lista-contas";
	}

	@RequestMapping("/lista-contas")
	public ModelAndView listaConta() {
		List<Conta> contas = contaDao.lista();

		ModelAndView mv = new ModelAndView("conta/lista-contas");
		mv.addObject("contas", contas);

		return mv;
	}

	/**
	 * Versão alternativa utilizando a classe MODEL ao invés da classe
	 * ModelAndView
	 */
	// @RequestMapping("/lista-conta")
	// public String lista(Model mv) {
	// ContaDao dao = new ContaDao();
	// List<Conta> contas = dao.lista();
	//
	// mv.addAttribute("contas", contas);
	// return "conta/lista";
	// }

}
