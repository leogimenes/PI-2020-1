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

import projeto.calc02.model.Bairro;
import projeto.calc02.model.Pegada;
import projeto.calc02.model.Usuario;
import projeto.calc02.service.BairrosService;
import projeto.calc02.service.PegadaService;

@Controller
@SessionAttributes("btnParam")
public class PegadaController {

	@Autowired
	private PegadaService pegadaService;
	@Autowired
	private BairrosService bairrosService;

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
		Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogado");
		pegada.setUsuario(u);
		pegada.setPegadaTotal((pegada.getDistanciaCarro()) + pegada.getDistanciaBus() + pegada.getPesoLixo());
		pegada.setBairro(u.getBairro());
		pegadaService.salvar(pegada);
		return "redirect:/minha_conta";
	}

	@GetMapping("/exibir")
	public String buttonSelect(Model model, @RequestParam("input") String input) {
		model.addAttribute("btnParam", input);
		return "redirect:/minha_conta";
	}

	/*
	 * Mapa de emissão
	 * 
	 * 
	 * 
	 */
	@GetMapping("/mapa")
	public ModelAndView mapaDeEmissao(@RequestParam(value = "inputBairro", required = false, defaultValue = " ") String inputBairro, HttpServletRequest request, ModelAndView mv) {
		mv = new ModelAndView("mapa");
		mv.addObject("pegada", new Pegada());
		mv.addObject("inputBairro", inputBairro);
		
		List<Pegada> pegadas = pegadaService.getSomaPegadasPorBairro();
		mv.addObject("pegadas", pegadas);
		
		if (!inputBairro.isBlank()) {
			Pegada pegada = new Pegada();
			Bairro bairro = bairrosService.getBairro(inputBairro);
			pegada = pegadaService.somarTodosPorBairro(bairro);
			mv.addObject("pegada", pegada);
		}
		
		return mv;
	}
	
	/*
	@GetMapping("/bairro")
	public String selecionarBairro(Model model, @RequestParam("inputBairro") int inputBairro, HttpServletRequest request) {
		Pegada pegada = new Pegada();
		model.addAttribute("inputBairro", inputBairro);
		if (inputBairro != 0) {
			pegada.setPegadaTotal(pegadaService.somarTodosPorBairroId(inputBairro));
			model.addAttribute("pegada", pegada);
		}
		
		return "redirect:/mapa";
	}
	
	*/
}
