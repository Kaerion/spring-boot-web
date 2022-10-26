package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	//RequestParam obtiene parametros de la url con ?var=value
	@GetMapping("/string")
	public String params(@RequestParam(name = "texto", required = false, defaultValue = "Valor por defecto") String texto, Model model) {
		model.addAttribute("resultado", "El resultado es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
//	@GetMapping("/mix-params")
//	public String params(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
//		model.addAttribute("resultado", "El saludo es: '"+saludo+"' y el numero es '" + numero +"'");
//		return "params/ver";
//	}
	
	@GetMapping("/mix-params")
	public String params(HttpServletRequest request, Model model) {
		model.addAttribute("resultado", "El saludo es: '"+request.getParameter("saludo")+"' y el numero es '" + request.getParameter("numero") +"'");
		return "params/ver";
	}

}
