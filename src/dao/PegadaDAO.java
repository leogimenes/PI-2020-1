package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PegadaIndividual;

public class PegadaDAO {

	private static final int ID = 1;
	private static final int NOME_INDIVIDUAL = 2;
	private static final int CPF_INDIVIDUAL = 3;
	private static final int TEMP_CARRO = 4;
	private static final int TEMP_BUS = 5;
	private static final int VOL_LIXO = 6;
	private static final int PEGADA_TOTAL = 7;
	private static final int CEP_INDIVIDUAL = 8;
	private static final int COMPLEMENTO_INDIVIDUAL = 9;
	private static final int ID_BAIRRO = 10;
	
	
	public static void criar(PegadaIndividual to) {
		String sqlInsert = "INSERT INTO Pegada_Individual(Nome_Individual, CPF_Individual, Temp_Carro, Temp_bus, Vol_Lixo, Pegada_Total, CEP_Individual, Complemento_Individual, Bairro_idBairro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNomeIndividual());
			stm.setString(2, to.getCpfIndividual());
			stm.setInt(3, to.getTempCarro());
			stm.setInt(4, to.getTempBus());
			stm.setInt(5, to.getVolLixo());
			stm.setDouble(6, to.getPegadaTotal());
			stm.setString(7, to.getCepIndividual());
			stm.setString(8, to.getComplementoIndividual());
			stm.setInt(9, to.getIdBairro());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					to.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void atualizar(PegadaIndividual to) {
		String sqlUpdate = "UPDATE Pegada_Individual SET Nome_Individual=?, CPF_Individual=?, Temp_Carro=?, Temp_bus=?, Vol_Lixo=?, Pegada_Total=?, CEP_Individual=?, Complemento_Individual=?, Bairro_idBairro=? WHERE idPegada_Individual=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNomeIndividual());
			stm.setString(2, to.getCpfIndividual());
			stm.setInt(3, to.getTempCarro());
			stm.setInt(4, to.getTempBus());
			stm.setInt(5, to.getVolLixo());
			stm.setDouble(6, to.getPegadaTotal());
			stm.setString(7, to.getCepIndividual());
			stm.setString(8, to.getComplementoIndividual());
			stm.setInt(9, to.getIdBairro());
			stm.setInt(10, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void excluir(PegadaIndividual to) {
		String sqlDelete = "DELETE FROM Pegada_Individual WHERE idPegada_Individual = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static PegadaIndividual carregar(int id) {
		PegadaIndividual to = new PegadaIndividual();
		String sqlSelect = "SELECT idPegada_Individual, Nome_Individual, CPF_Individual, Temp_Carro, Temp_bus, Vol_Lixo, Pegada_Total, CEP_Individual, Complemento_Individual FROM Pegada_Individual WHERE idPegada_Individual =?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(ID));
					to.setNomeIndividual(rs.getString(NOME_INDIVIDUAL));
					to.setCpfIndividual(rs.getString(CPF_INDIVIDUAL));
					to.setTempCarro(rs.getInt(TEMP_CARRO));
					to.setTempBus(rs.getInt(TEMP_BUS));
					to.setVolLixo(rs.getInt(VOL_LIXO));
					to.setPegadaTotal(rs.getDouble(PEGADA_TOTAL));
					to.setCepIndividual(rs.getString(CEP_INDIVIDUAL));
					to.setComplementoIndividual(rs.getString(COMPLEMENTO_INDIVIDUAL));
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	/*
	public static ArrayList<PegadaIndividual> listarTodos(){
		String sqlSelect = "SELECT id, nome, populacao, area FROM PegadaIndividual";
		ArrayList<PegadaIndividual> to = new ArrayList<>();

		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				ResultSet rs = stm.executeQuery();){
			while(rs.next()) {
				PegadaIndividual container = new PegadaIndividual();
				container.setId(rs.getInt("id"));
				container.setNome(rs.getString("nome"));
				container.setPopulacao(rs.getLong("populacao"));
				container.setArea(rs.getDouble("area"));
				to.add(container);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return to;
	}*/
}
