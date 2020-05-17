package projeto.calc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.calc02.model.Pegada;
import projeto.calc02.repository.PegadaRepository;

@Service
public class PegadaService {
	@Autowired
	PegadaRepository pegadaRepo;
	
	public List<Pegada> getPegadas(Integer id){
		
		return pegadaRepo.findByUsuarioId(id);
	}
	
	public List<Pegada> listarTodos(){
		return pegadaRepo.findAll();
	}
	
	public void salvar(Pegada pegada) {
		pegadaRepo.save(pegada);
	}
}
