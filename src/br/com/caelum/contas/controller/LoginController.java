package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

//@Transactional
@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	// @Autowired
	// public LoginController(UsuarioDAO usuarioDAO) {
	// this.usuarioDAO = usuarioDAO;
	// }

	@RequestMapping("/login")
	public String loginForm() {
		return "usuario/login";
	}

	@RequestMapping("/efetua-login")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (usuarioDAO.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "conta/formulario";
		}
		return "redirect:login";
	}

	@RequestMapping("/desloga")
	public String desloga(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
