package br.edu.iff.ecommerce.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerView {
	
	@GetMapping("/mainview")
	public String mainview() {
		return "index";
	}

}
