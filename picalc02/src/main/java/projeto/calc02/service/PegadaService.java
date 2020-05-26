package projeto.calc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.calc02.model.Bairro;
import projeto.calc02.model.Pegada;
import projeto.calc02.model.Usuario;
import projeto.calc02.repository.PegadaRepository;

@Service
public class PegadaService {
	@Autowired
	PegadaRepository pegadaRepo;
	
	public List<Pegada> getPegadas(Long id){
		
		return pegadaRepo.findByUsuarioId(id);
	}
	
	public List<Pegada> listarTodos(){
		return pegadaRepo.findAll();
	}
	
	public void salvar(Pegada pegada) {
		pegadaRepo.save(pegada);
	}
	
	public Double somarTodosPorUsuario(Usuario usuario) {
		
		return pegadaRepo.somaUsuarioPegadas(usuario);
	}
	
	public Double somarTodosPorBairro(Bairro bairro) {
		String s = "" + pegadaRepo.somaBairroPegadas(bairro);
		if(s.equals("null")) {
			return 0.0;
		}
		return Double.parseDouble(s);
	}
	
	public Double somarTodosPorBairroId(Long bairro) {
		
		return pegadaRepo.somaBairroPegadas(bairro);
	}
}
