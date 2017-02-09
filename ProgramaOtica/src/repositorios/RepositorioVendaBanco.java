package repositorios;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Venda;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
import exceptions.TamanhoException;
import interfaces.IRepositorioVenda;
import programa.Fachada;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;

public class RepositorioVendaBanco implements IRepositorioVenda {
	private static RepositorioVendaBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioVendaBanco(String server, String user, String key) {
		try {
			pm = PersistenceMechanismRDBMS.getInstance(server, user, key);//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioVendaBanco getInstance(String server, String user, String key) {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioVendaBanco(server, user, key);
		}
		return instance;
	}
	
	public void inserir (Venda venda) throws RepositorioException, NullPointerException, TamanhoException {
		//Statement é usado para utilizar os comandos sql no java.
		try {
			if (procurarVenda(venda.getId()) == null){
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO venda (id_cliente, id_produto)"
						+ "VALUES ('" + venda.getCliente() + "', '" 
						+ venda.getProduto() +"')");
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
		} catch (RepositorioJaExisteException e1) {
			
			e1.printStackTrace();
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso");				
	}
	
	public void removerVenda (int id) throws RepositorioException {
		try {
			if(procurarVenda(id) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from venda WHERE id = '" + id + "'");				
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
		JOptionPane.showMessageDialog(null, "Venda removida com sucesso");
	}
	
	public void atualizar (Venda venda) throws RepositorioException, TamanhoException {
		try {
			//recebo uma venda e passo apenas o id do cliente e do produto, para o banco
			Fachada fachada = Fachada.getInstance("","",""); // ERROOOOOOOOOOOOOOOOOOOOR
			//se venda, cliente e produto existirem, atualize
			if (procurarVenda(venda.getId()) != null) {
				if (fachada.procurarCliente(venda.getCliente()) != null) {
					if(fachada.procurarProduto(venda.getProduto()) != null) {
						Statement statement = (Statement) pm.getCommunicationChannel();
						statement.executeUpdate("UPDATE venda SET id_cliente ='" + venda.getCliente() 
							+ "', id_produto ='" + venda.getProduto() 
							+ "' WHERE id = '" + venda.getId() + "'");
					}else {//se produto não existir
						NullPointerException e = new NullPointerException();
						throw e;
					}
				}else {//se cliente não existir
					NullPointerException e = new NullPointerException();
					throw e;
				}
			}else {//se a venda não existir
				NullPointerException e = new NullPointerException();
				throw e;
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
		JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso");
	}
	
	public Venda procurarVenda (int id) throws RepositorioException, TamanhoException {
		Venda venda = null;
		
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM venda WHERE id ='"+ id + "'");
			if (resultset.next()){
				venda = new Venda();
				// se for trabalhar com o cliente e n com seu id use resultset.getObject(id);
				venda.setId(resultset.getInt("id"));
				venda.setCliente(resultset.getInt("id_cliente"));
				venda.setProduto(resultset.getInt("id_produto"));
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
	
	public RepositorioVendaArray todasVendas() throws TamanhoException {
		
		RepositorioVendaArray vendas = new RepositorioVendaArray();
		try {
			Statement statement;
			ResultSet resultset;
			statement = (Statement) pm.getCommunicationChannel();
			resultset = statement.executeQuery("SELECT * FROM venda ");
			
			while (resultset.next()){
				Venda venda = new Venda();
				
				try {//insere em clientes todos os clientes
					venda.setId(resultset.getInt("id"));
					venda.setCliente(resultset.getInt("id_cliente"));
					venda.setProduto(resultset.getInt("id_produto"));
				
					vendas.inserir(venda);
				} catch (NullPointerException | RepositorioException | SemPosicaoParaInserirException e) {
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
	
}
