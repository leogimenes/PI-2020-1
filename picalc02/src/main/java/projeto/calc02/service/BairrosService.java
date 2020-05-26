package projeto.calc02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.calc02.model.Bairro;
import projeto.calc02.repository.BairrosRepository;

@Service
public class BairrosService {
	
	@Autowired
	BairrosRepository bairrosRepo;
	
	public Bairro getBairro(String nome) {
		return bairrosRepo.findOneByNomeBairro(nome);
	}
}
