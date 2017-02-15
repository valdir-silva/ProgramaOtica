package repositorios;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Produto;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.IdNaoExisteException;
import exceptions.PersistenceMechanismException;
//import exceptions.RemocaoNaoConcluidaException;
//import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaceGrafica.JInicio;
import interfaces.IRepositorioProduto;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;

public class RepositorioProdutoBanco implements IRepositorioProduto {
	private static RepositorioProdutoBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	private JInicio instanceInicio = JInicio.getInstance();
	
	private RepositorioProdutoBanco(String server, String user, String key) {
		try {
			pm = instanceInicio.getInstance(server, user, key);//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioProdutoBanco getInstance(String server, String user, String key) {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioProdutoBanco(server, user, key);
		}
		return instance;
	}
	
	public void inserir (Produto produto) throws RepositorioException, RepositorioJaExisteException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("INSERT INTO produto (marca, valor_compra, valor_venda, nome, quantidade)"
					+ "VALUES ('"+ produto.getMarca() + "', '"+ produto.getValorCompra() 
					+ "', '" + produto.getValorVenda() + "', '" + produto.getNome() + "', '" + produto.getQuantidade() + "')");	
		
			JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
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
			if(procurarProduto(id) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from produto WHERE id = '" + id + "'");
				JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
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
		} catch (IdNaoExisteException e) {
			e.printStackTrace();
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
			if (procurarProduto(produto.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("UPDATE produto SET marca = '"+ produto.getMarca() + "', valor_compra ='"
				+ produto.getValorCompra() + "', valor_venda ='" 
				+ produto.getValorVenda() + "', nome ='" + produto.getNome() + "', quantidade ='" + produto.getQuantidade() 
				+ "' WHERE id = '" 
				+ produto.getId() +"'");
				
				JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
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
		} catch (IdNaoExisteException e) {
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		
	}
	
	public Produto procurarProduto (int id) throws RepositorioException, TamanhoException, IdNaoExisteException {
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
				produto.setQuantidade(resultset.getInt("quantidade"));
			}
			resultset.close();
			
			if(produto != null) 
				return produto;
			else throw new IdNaoExisteException();
		

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
	
	public RepositorioProdutoArray todosProdutos() throws TamanhoException {
		
		RepositorioProdutoArray produtos = new RepositorioProdutoArray();
		try {
			Statement statement;
			ResultSet resultset;
			statement = (Statement) pm.getCommunicationChannel();
			resultset = statement.executeQuery("SELECT * FROM produto ");
			
			while (resultset.next()){
				Produto produto = new Produto();
				
				produto.setId(resultset.getInt("id"));
				produto.setMarca(resultset.getString("marca"));  
				produto.setValorCompra(resultset.getFloat("valor_compra"));
				produto.setValorVenda(resultset.getFloat("valor_venda"));
				produto.setNome(resultset.getString("nome"));
				produto.setQuantidade(resultset.getInt("quantidade"));
				
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
