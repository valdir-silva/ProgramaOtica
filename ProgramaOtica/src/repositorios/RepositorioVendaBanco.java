package repositorios;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import base.Venda;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
//import exceptions.RemocaoNaoConcluidaException;
//import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioVenda;
import exceptions.RepositorioException;

public class RepositorioVendaBanco implements IRepositorioVenda {
	private static RepositorioVendaBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioVendaBanco() {
		try {
			pm = PersistenceMechanismRDBMS.getInstance();//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioVendaBanco getInstance() {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioVendaBanco();
		}
		return instance;
	}
	
	public void inserir (Venda venda) throws RepositorioException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("INSERT INTO venda (cliente, produto)"
					+ "VALUES ('" + "')");
		} catch(PersistenceMechanismException e){
		    throw new RepositorioException(e);
		} catch (SQLException e) {
		    throw new RepositorioException(e);
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
	}
	
	public void removerVenda (int id) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("DELETE from venda WHERE id = '" + id + "'");
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		
	}
	
	public void atualizar (Venda venda) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("UPDATE venda SET cliente ='" + venda.getCliente() + "', produto ='" 
			+ venda.getProduto() + "' WHERE id = '" + venda.getId() + "'");
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		
	}
	
	public Venda procurarVenda (int id) throws RepositorioException, TamanhoException {
		Venda venda = null; 
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM venda WHERE id ='"+ id + "'");
			if (resultset.next()){
				venda = new Venda();
				
				//venda.setCliente(resultset.getString("cliente"));
				//venda.setProduto(resultset.getString("produto"));
			}

		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		
		return venda;
	}
	
}
