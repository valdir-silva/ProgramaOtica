package repositorios;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import base.Produto;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
//import exceptions.RemocaoNaoConcluidaException;
//import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioProduto;
import exceptions.RepositorioException;

public class RepositorioProdutoBanco implements IRepositorioProduto {
	private static RepositorioProdutoBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioProdutoBanco() {
		try {
			pm = PersistenceMechanismRDBMS.getInstance();//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioProdutoBanco getInstance() {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioProdutoBanco();
		}
		return instance;
	}
	
	public void inserir (Produto produto) throws RepositorioException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("INSERT INTO produto (marca, valor_compra, valor_venda, nome)"
					+ "VALUES ('"+ produto.getMarca() + "', '"+ produto.getValorCompra() 
					+ "', '" + produto.getValorVenda() + "', '" + produto.getNome() + "')");
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
	
	public void removerProduto (int id) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("DELETE from produto WHERE id = '" + id + "'");
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
	
	public void atualizar (Produto produto) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("UPDATE produto SET marca = '"+ produto.getMarca() + "', valor_compra ='"
			+ produto.getValorCompra() + "', valor_venda ='" 
			+ produto.getValorVenda() + "', nome ='" + produto.getNome() + "' WHERE id = '" 
			+ produto.getId() +"'");
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
	
	public Produto procurarProduto (int id) throws RepositorioException, TamanhoException {
		Produto produto = null; 
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM cliente WHERE id ='"+ id + "'");
			if (resultset.next()){
				produto = new Produto();
				
				produto.setMarca(resultset.getString("marca"));
				produto.setValorCompra(resultset.getFloat("valor_compra"));
				produto.setValorVenda(resultset.getFloat("valor_venda"));
				produto.setNome(resultset.getString("nome"));
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
		
		return produto;
	}
	
}
