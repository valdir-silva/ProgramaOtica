package repositorios;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Produto;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
//import exceptions.RemocaoNaoConcluidaException;
//import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioProduto;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;

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
	
	public void inserir (Produto produto) throws RepositorioException, RepositorioJaExisteException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			if (procurarProduto(produto.getId()) == null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO produto (marca, valor_compra, valor_venda, nome)"
						+ "VALUES ('"+ produto.getMarca() + "', '"+ produto.getValorCompra() 
						+ "', '" + produto.getValorVenda() + "', '" + produto.getNome() + "')");	
			}else {
				RepositorioJaExisteException e = new RepositorioJaExisteException();
				throw e;
			}
			
		} catch(PersistenceMechanismException e){
		    throw new RepositorioException(e);
		} catch (SQLException e) {
		    throw new RepositorioException(e);
		} catch (TamanhoException e) {
			e.printStackTrace();
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
	}
	
	public void removerProduto (int id) throws RepositorioException {
		try {
			Produto produto = new Produto();
			if(procurarProduto(produto.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from produto WHERE id = '" + id + "'");				
			}else {
				NullPointerException e = new NullPointerException();
				throw e;
			}
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (TamanhoException e) {
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
	}
	
	public void atualizar (Produto produto) throws RepositorioException {
		try {
			if (procurarProduto(produto.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("UPDATE produto SET marca = '"+ produto.getMarca() + "', valor_compra ='"
				+ produto.getValorCompra() + "', valor_venda ='" 
				+ produto.getValorVenda() + "', nome ='" + produto.getNome() + "' WHERE id = '" 
				+ produto.getId() +"'");				
			}else {//se produto não existir
				NullPointerException e = new NullPointerException();
				throw e;
			}
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (TamanhoException e) {
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
	}
	
	public Produto procurarProduto (int id) throws RepositorioException, TamanhoException {
		Produto produto = null; 
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM produto WHERE id ='"+ id + "'");
			if (resultset.next()){
				produto = new Produto();
				
				produto.setId(resultset.getInt("id"));
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
	
	public RepositorioProdutoArray todosProdutos() throws TamanhoException {
		
		RepositorioProdutoArray produtos = null;
		try {
			Statement statement;
			ResultSet resultset;
			statement = (Statement) pm.getCommunicationChannel();
			resultset = statement.executeQuery("SELECT * FROM produto ");
			
			while (resultset.next()){
				produtos = new RepositorioProdutoArray();
				Produto produto = new Produto();
				
				produto.setId(resultset.getInt("id"));
				produto.setMarca(resultset.getString("marca"));  
				produto.setValorCompra(resultset.getFloat("valor_compra"));
				produto.setValorVenda(resultset.getFloat("valor_venda"));
				produto.setNome(resultset.getString("nome"));
				
				try {
					produtos.inserir(produto);
				} catch (SemPosicaoParaInserirException e) {
					e.printStackTrace();
				}
			}
			resultset.close();
		
		} catch (PersistenceMechanismException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return produtos;			
	}

}
