package repositorios;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.ItemVenda;
import base.Venda;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.IdNaoExisteException;
import exceptions.PersistenceMechanismException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.TamanhoException;
import interfaceGrafica.JInicio;
import interfaces.IRepositorioVenda;
import programa.Fachada;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;

public class RepositorioVendaBanco implements IRepositorioVenda {
	private static RepositorioVendaBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	private JInicio instanceInicio = JInicio.getInstance();
	private String server;
	private String user;
	private String key;
	
	private RepositorioVendaBanco(String server, String user, String key) {
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
	
	public static RepositorioVendaBanco getInstance(String server, String user, String key) {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioVendaBanco(server, user, key);
		}
		return instance;
	}
	
	public void inserir (Venda venda) throws RepositorioException, NullPointerException, TamanhoException, QuantidadeProdutoInvalidaException, SemPosicaoParaInserirException {
		//Statement é usado para utilizar os comandos sql no java.
		Fachada fachada = Fachada.getInstance(server, user, key);
		int i = 0;
		try {
			if (fachada.procurarCliente(venda.getIdCliente()) != null) {//se o cliente existir
				//para buscar os itens da venda terá que
				//ir em repositorio Item venda bannco
				venda.setId(gerarId());
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO venda (id, id_cliente, total, data)"
						+ "VALUES ('" + venda.getId() + "', '" + venda.getIdCliente() + "', '" 
						+ venda.getTotal() + "', '" + venda.getData() +"')");
				
				ItemVenda[] itensVenda = venda.getVendas();
				while(itensVenda[i] != null) {//inserir o id_venda dos itens venda
					fachada.inserir(itensVenda[i]);
					fachada.InserirIdVenda(itensVenda[i].getId(), venda.getId());
					i++;
				}
						
				
				JOptionPane.showMessageDialog(null, "Venda inserida com sucesso");
			}else throw new NullPointerException();

		} catch(PersistenceMechanismException e){
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
	
	public void removerVenda (int id) throws RepositorioException {
		try {
			if(procurarVenda(id) != null) {
				Fachada fachada = Fachada.getInstance(server, user, key);
				RepositorioItemVendaArray vendas = new RepositorioItemVendaArray();
				String [][] dados = null;
				
				vendas = fachada.todosItensVenda(id);
				dados = vendas.todosItensVenda();
				
				for(int i = 0; i < dados.length; i++) {
					if(dados[i][0] != null)
						fachada.removerItemVenda(Integer.parseInt(dados[i][0]));
				}
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from venda WHERE id = '" + id + "'");
				
				JOptionPane.showMessageDialog(null, "Venda removida com sucesso");
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
	
	public void atualizar (Venda venda) throws RepositorioException, TamanhoException {
		ItemVenda IVenda = new ItemVenda();
		int i = 0;
		try {
			//recebo uma venda e passo apenas o id do cliente e do produto, para o banco
			Fachada fachada = Fachada.getInstance(server,user,key);
			//se venda, cliente e produto existirem, atualize
			if (procurarVenda(venda.getId()) != null) {
				if (fachada.procurarCliente(venda.getIdCliente()) != null) {
					while(venda.getVendas()[i] != null) {
						IVenda = venda.getVendas()[i];
						fachada.inserir(IVenda);
						i++;
					}
					
					Statement statement = (Statement) pm.getCommunicationChannel();
					statement.executeUpdate("UPDATE venda SET id_cliente ='" + venda.getIdCliente() 
						+ "', total ='" + venda.getTotal() + "', data ='" + venda.getData()
						+ "' WHERE id = '" + venda.getId() + "'");
					
					JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso");
				} else //se cliente não existir
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
		} catch (SemPosicaoParaInserirException e) {
			e.printStackTrace();
		} catch (QuantidadeProdutoInvalidaException e) {
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
	}
	
	public Venda procurarVenda (int id) throws RepositorioException, TamanhoException, IdNaoExisteException {
		Venda venda = null;
		
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM venda WHERE id ='"+ id + "'");
			if (resultset.next()){
				venda = new Venda();
				// se for trabalhar com o cliente e n com seu id use resultset.getObject(id);
				venda.setId(resultset.getInt("id"));
				venda.setIdCliente(resultset.getInt("id_cliente"));
				venda.setTotal(resultset.getFloat("total"));
				venda.setData(resultset.getString("data"));
			}
			resultset.close();
			
			if(venda != null)
				return venda;
			return null;

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
					venda.setIdCliente(resultset.getInt("id_cliente"));
					venda.setTotal(resultset.getFloat("total"));
					venda.setData(resultset.getString("data"));
					
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
	
	public int gerarId() throws TamanhoException, RepositorioException, IdNaoExisteException {
		int id = 1;
		
		while(procurarVenda(id) != null) {//pega o ultimo id disponível
			id++;
		}
		return id;
	}
	
}
