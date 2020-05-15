package projeto.calc02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import projeto.calc02.model.Bairro;
import projeto.calc02.model.CompararBairro;
import projeto.calc02.model.Usuario;
import projeto.calc02.repository.BairrosRepository;
import projeto.calc02.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private BairrosRepository bairroRepo;
	
	@GetMapping(value = {"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastroGet() {
		ModelAndView mv = new ModelAndView("/cadastro");
		
		List<Usuario> usuarios = usuarioRepo.findAll();
		List<Bairro> bairros = bairroRepo.findAll();
		bairros.sort(new CompararBairro());
		
		mv.addObject("bairros", bairros);
		
		mv.addObject("usuarios", usuarios);
		
		mv.addObject(new Bairro());
		mv.addObject(new Usuario());
		
		return mv;
	}
	
	@GetMapping("/informacoes")
	public String informacoes() {
		return "informacoes";
	}	
	
	@PostMapping("/cadastro")
	public String cadastroPost(Usuario usuario) {
		usuarioRepo.save(usuario);
		return "/login";
	}
	
	
	
}