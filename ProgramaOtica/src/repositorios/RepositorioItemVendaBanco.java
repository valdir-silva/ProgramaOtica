package repositorios;

import java.awt.HeadlessException;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.ItemVenda;
import base.Produto;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.IdNaoExisteException;
import exceptions.PersistenceMechanismException;
import exceptions.QuantidadeEstoqueMenorException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.TamanhoException;
import interfaceGrafica.JInicio;
import interfaces.IRepositorioItemVenda;
import programa.Fachada;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;

public class RepositorioItemVendaBanco implements IRepositorioItemVenda {
	private static RepositorioItemVendaBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	private JInicio instanceInicio = JInicio.getInstance();
	private String server;
	private String user;
	private String key;
	
	private RepositorioItemVendaBanco(String server, String user, String key) {
		try {
			this.server = server;
			this.user = user;
			this.key = key;
			pm = instanceInicio.getInstance(server, user, key);//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioItemVendaBanco getInstance(String server, String user, String key) {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioItemVendaBanco(server, user, key);
		}
		return instance;
	}
	
	public void inserir (ItemVenda venda) throws RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException {
		//Statement é usado para utilizar os comandos sql no java.
		Fachada fachada = Fachada.getInstance(server, user, key);
		try {
			if(produtoExiste(fachada, venda)){
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO item_venda (id_venda, id_produto, quantidade)"
						+ "VALUES ('" + venda.getIdVenda() + "', '" 
						+ venda.getIdProduto() + "', '" + venda.getQuantidade() +"')");						
				JOptionPane.showMessageDialog(null, "Item Venda inserido com sucesso");
			}else
				throw new IdNaoExisteException();

		} catch(PersistenceMechanismException e){
		    throw new RepositorioException(e);
		} catch (SQLException e) {
		    throw new RepositorioException(e);
		} catch (IdNaoExisteException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (QuantidadeEstoqueMenorException e) {
			e.printStackTrace();
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}		
	}
	
	//tambem testa se existe produto suficiente em estoque
	private boolean produtoExiste(Fachada fachada, ItemVenda venda) throws NullPointerException, RepositorioException, TamanhoException, IdNaoExisteException, QuantidadeEstoqueMenorException {
		if(fachada.procurarProduto(venda.getIdProduto()) != null) {//se o produto existir
			int quantidade;
			Produto produto = fachada.procurarProduto(venda.getIdProduto());
			
			quantidade = produto.getQuantidade();//pega quantos produtos tinha
			quantidade -= venda.getQuantidade();//reduz a quantidade que foi comprada
			if(quantidade < 0){
				throw new QuantidadeEstoqueMenorException();
			}
			produto.setQuantidade(quantidade);//
			
			fachada.atualizar(produto);
			return true;
		}
		else
			return false;
	}
	
	public void removerItemVenda (int id) throws RepositorioException {
		try {
			if(procurarItemVenda(id) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from item_venda WHERE id = '" + id + "'");
				
				JOptionPane.showMessageDialog(null, "Item Venda removido com sucesso");
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
	
	public void atualizar (ItemVenda venda) throws RepositorioException, TamanhoException {
		try {
			//recebo uma venda e passo apenas o id do cliente e do produto, para o banco
			Fachada fachada = Fachada.getInstance(server,user,key);
			//se venda, cliente e produto existirem, atualize
			if (procurarItemVenda(venda.getId()) != null) {
				if(produtoExiste(fachada, venda)) {
					Statement statement = (Statement) pm.getCommunicationChannel();
					statement.executeUpdate("UPDATE item_venda SET id_venda ='" + venda.getIdVenda() 
						+ "', id_produto ='" + venda.getIdProduto() + "', quantidade ='" + venda.getQuantidade()
						+ "' WHERE id = '" + venda.getId() + "'");
					
					JOptionPane.showMessageDialog(null, "Item Venda atualizada com sucesso");
				} else //se produto não existir
					throw new IdNaoExisteException();
			} else //se a venda não existir
				throw new IdNaoExisteException();
			
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IdNaoExisteException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (QuantidadeEstoqueMenorException e) {
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
	}
	
	public ItemVenda procurarItemVenda (int id) throws RepositorioException, TamanhoException, IdNaoExisteException {
		ItemVenda venda = null;
		
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM item_venda WHERE id ='"+ id + "'");
			if (resultset.next()){
				venda = new ItemVenda();
				// se for trabalhar com o cliente e n com seu id use resultset.getObject(id);
				venda.setId(resultset.getInt("id"));
				venda.setIdVenda(resultset.getInt("id_venda"));
				venda.setIdProduto(resultset.getInt("id_produto"));
				venda.setQuantidade(resultset.getInt("quantidade"));
			}
			resultset.close();
			
			if(venda != null)
				return venda;
			else //se a venda nao existir 
				throw new IdNaoExisteException();

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
	
	public RepositorioItemVendaArray todosItensVenda() throws TamanhoException {
		
		RepositorioItemVendaArray vendas = new RepositorioItemVendaArray();
		try {
			Statement statement;
			ResultSet resultset;
			statement = (Statement) pm.getCommunicationChannel();
			resultset = statement.executeQuery("SELECT * FROM item_venda ");
			
			while (resultset.next()){
				ItemVenda venda = new ItemVenda();
				
				try {//insere em venda todas as vendas
					venda.setId(resultset.getInt("id"));
					venda.setIdVenda(resultset.getInt("id_venda"));
					venda.setIdProduto(resultset.getInt("id_produto"));
					venda.setQuantidade(resultset.getInt("quantidade"));
				
					vendas.inserir(venda);
				} catch (NullPointerException | SemPosicaoParaInserirException e) {
					e.printStackTrace();
				}
			}
			resultset.close();
		
		} catch (PersistenceMechanismException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return vendas;			
	}

	public void InserirIdVenda(int itemVenda, int idVenda) {	
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("UPDATE item_venda SET id_venda ='" + idVenda + "' WHERE id = '" + itemVenda + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
	}
	
}
