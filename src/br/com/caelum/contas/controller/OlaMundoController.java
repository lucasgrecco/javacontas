package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/OlaMundo")
	public String execute(){
		System.out.println("Olá mundo maldito!!!");
		return "ok";
	}
}
