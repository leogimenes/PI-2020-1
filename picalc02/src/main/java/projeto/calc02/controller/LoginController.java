package projeto.calc02.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import projeto.calc02.model.Usuario;
import projeto.calc02.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv;
		HttpSession session = request.getSession();
		if(session.getAttribute("usuarioLogado") != null) {
			mv = new ModelAndView("index");
			if(!response.isCommitted())				
				response.sendRedirect("/index");
			return mv;
		}
		
		mv = new ModelAndView("login");
		
		mv.addObject(new Usuario());
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();		
		return "/index";
	}
	
	
	@PostMapping("/fazerLogin")
	public String fazerLogin(HttpServletRequest request, Usuario usuario) {
		if(loginService.logar(usuario)) {
			usuario = loginService.updateId(usuario);
			System.out.println(usuario.getId());
			request.getSession().setAttribute("usuarioLogado", usuario);
			return "redirect:minha_conta";
		}
		else {
			return "/login";
		}
	}
	
	@GetMapping("/fazerLogin")
	public String indexLogin() {
		return "/index";
	}
}
