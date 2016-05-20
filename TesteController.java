package br.com.caelum.tarefas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteController {
	@RequestMapping("/testeSpring")
	public String execute(){
		System.out.println("Carregando Mapa");
		return "testemvc";
	}
}