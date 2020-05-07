package pl.kobietydokodu.koty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kobietydokodu.koty.CatService;
import pl.kobietydokodu.koty.dto.KotDTO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class KotyController {

	@Autowired
	CatService service;
	
	@RequestMapping(value={	"/", "/lista"})
	public String listaKotow(Model model) {
		model.addAttribute("koty", service.getKoty());
		return "lista";
	}
	
	@RequestMapping("/dodaj")
	public String dodajKota(HttpServletRequest request,  @ModelAttribute("kotDto") @Valid KotDTO kotDto, BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
			service.dodajKota(kotDto);
			return "redirect:/lista";
		}
		return "dodaj";
	}
	
	@RequestMapping("/kot-{id}")
	public String szczegolyKota(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("kot", service.getKotById(id));
		return "szczegoly";
	}
	
}
