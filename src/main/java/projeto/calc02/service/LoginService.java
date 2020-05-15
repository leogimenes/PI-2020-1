package projeto.calc02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.calc02.model.Usuario;
import projeto.calc02.repository.UsuarioRepository;

@Service
public class LoginService {
	@Autowired
	UsuarioRepository usuarioRepo;
	
	public boolean logar(Usuario usuario) {
		return usuarioRepo.findOneByNomeIndividualAndCpfIndividual(usuario.getNomeIndividual(), usuario.getCpfIndividual()) != null;
	}
}
