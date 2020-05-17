package projeto.calc02.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import projeto.calc02.model.Pegada;
import projeto.calc02.model.Usuario;
import projeto.calc02.service.PegadaService;

@Controller
@SessionAttributes("btnParam")
public class PegadaController {
	
	@Autowired
	private PegadaService pegadaService;
	
	@GetMapping("/minha_conta")
	public ModelAndView minhaConta(HttpServletRequest request, ModelAndView mv) {
		mv = new ModelAndView("minha_conta");
		
		mv.addObject(new Usuario());
		mv.addObject(new Pegada());
		
		Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogado");
		List<Pegada> pegadas = pegadaService.getPegadas(u.getId());
		
		mv.addObject("pegadas", pegadas);
		
		return mv;
	}
	
	@PostMapping("/minha_conta")
	public String listar_pegada(HttpServletRequest request, Pegada pegada) {
		pegadaService.salvar(pegada);		
		return "redirect:/minha_conta";		
	}
	
	@GetMapping("/exibir")
	public String buttonSelect(Model model, @RequestParam("input") String input) {
		ModelAndView mv = new ModelAndView("minha_conta");
		mv.addObject(new Pegada());
		model.addAttribute("btnParam", input);			
		return "redirect:/minha_conta";
	}	
}
