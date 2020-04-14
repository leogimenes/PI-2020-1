package service;

import dao.PegadaDAO;
import model.PegadaIndividual;

public class PegadaService {
	
	public void create(PegadaIndividual to) {
		PegadaDAO.criar(to);
	}
	
	public void update(PegadaIndividual to) {
		PegadaDAO.atualizar(to);
	}
	
	public void delete(PegadaIndividual to) {
		PegadaDAO.excluir(to);
	}
	
	public PegadaIndividual read(int id) {
		PegadaIndividual to = PegadaDAO.carregar(id);
		return to;
	}
}
