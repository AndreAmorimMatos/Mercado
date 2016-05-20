package br.com.caelum.tarefas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;

@Controller
public class Controlador {

	@RequestMapping("menu")
	public String form(){
		return "menu";
	}
	
	@RequestMapping("incluir")
	public String inclui_mercado(){
		return "incluir_mercado";
	}
	
	@RequestMapping("adicionaCompra")
	public String a(Lista_Mercado mercado){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(mercado);
		return "incluir_mercado";
	}

	@RequestMapping("listar")
	public String lista(Model model){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("linhas", dao.lista());
		return "listar_mercado";
	}
	
	@RequestMapping("mostraAlteracao")
	public String mostra(int cod_lista, Model model){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("lista", dao.buscaPorCod_Lista(cod_lista));
		return "mostra_alteracao";
	}
	
	@RequestMapping("alteraMercado")	
	public String altera(Lista_Mercado lista){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(lista);
		return "redirect:listar";
	}

	@RequestMapping("remove")	
	public String remove(Lista_Mercado lista){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(lista);
		return "redirect:listar";
	}
}