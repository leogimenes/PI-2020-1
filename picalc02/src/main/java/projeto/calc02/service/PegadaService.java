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
	
	public Pegada somarTodosPorBairro(Bairro bairro) {
		Double carros = verificaNulos("" + pegadaRepo.somaBairroCarros(bairro));
		Double bus = verificaNulos("" + pegadaRepo.somaBairroBus(bairro));
		Double lixo = verificaNulos("" + pegadaRepo.somaBairroLixo(bairro));
		Double pegadaT = verificaNulos("" + pegadaRepo.somaBairroPegadas(bairro));
		Pegada pegada = new Pegada(carros, bus, lixo, pegadaT);
		return pegada;
	}
	
	public Double somarTodosPorBairroId(Long bairro) {
		
		return pegadaRepo.somaBairroPegadas(bairro);
	}
	
	public List<Pegada> getSomaPegadasPorBairro() {
		return pegadaRepo.sumPegadasByBairroId();
	}
	
	private Double verificaNulos(String s) {
		if(s.equals("null")) {
			return 0.0;
		}
		return Double.parseDouble(s);
	}
}
