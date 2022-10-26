package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
//		return "redirect:/app/index"; Se reinician los parametros del controlador al que redireccionamos. Puede redireccionar a una pagina externa
//		return "redirect:http://www.google.com"; 
		return "forward:/app/index"; //Se mantienen los parametros, no se reinician. 
									 //La url no cambia a /app/index/ al contrario que con el redirect
									 // Forward es mas recomendable que redirect pero solo sirve para rutas de dentro del proyecto, no para paginas externas
	}
}
