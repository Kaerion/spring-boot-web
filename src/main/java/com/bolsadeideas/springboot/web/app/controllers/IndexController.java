package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil") //Cuando no tiene parametro, seria siempre GET
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Quinn");
		usuario.setApellido("Quero Roji");
		usuario.setEmail("quincylamejoh@hotmail.com");
		
		model.addAttribute("title", textoPerfil + usuario.getNombre());
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	@RequestMapping("/listar") //Cuando no tiene parametro, seria siempre GET
	public String listar(Model model) {
		model.addAttribute("title", textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List <Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(new Usuario("Quinn", "Roji Quero", "quinn@hotmail.com"));
		usuarios.add(new Usuario("Diana", "Roji Arias", "roji@hotmail.com"));
		usuarios.add(new Usuario("Jose", "Quero", "quero@hotmail.com"));
		
		return usuarios;
	}
	
}
