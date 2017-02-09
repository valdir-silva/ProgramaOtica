package repositorios;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Cliente;
import base.Endereco;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
import exceptions.TamanhoException;
import interfaceGrafica.JInicio;
import interfaces.IRepositorioCliente;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;

public class RepositorioClienteBanco implements IRepositorioCliente {
	private static RepositorioClienteBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	private JInicio instanceInicio = new JInicio();
	
	private RepositorioClienteBanco(String server, String user, String key) {
		try {
			pm = instanceInicio.getMinhaInstancia(server,user,key);//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioClienteBanco getInstance(String server, String user, String key) {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioClienteBanco(server, user, key);
		}
		return instance;
	}
	
	public void inserir (Cliente cliente) throws RepositorioException, RepositorioJaExisteException {
		//Statement é usado para utilizar os comandos sql no java.
		try {
			if (procurarCliente(cliente.getId()) == null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO cliente (estado, cidade, rua, cep, nascimento, nome, cpf, telefone)"
						+ "VALUES ('"+ cliente.getEndereco().getEstado() + "', '" + cliente.getEndereco().getCidade() 
						+ "', '" + cliente.getEndereco().getRua() + "', '" + cliente.getEndereco().getCep()
						+ "', '" + cliente.getNascimento() + "', '" + cliente.getNome()+ "', '" + cliente.getCpf()
						+ "', '" + cliente.getTelefone()+ "')");
				
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
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso");
	}
	
	public void removerCliente (int id) throws RepositorioException {
		try {
			if(procurarCliente(id) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from cliente WHERE id = '" + id + "'");
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
		JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
	}
	
	public void atualizar (Cliente cliente) throws RepositorioException {
		try {
			if (procurarCliente(cliente.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("UPDATE cliente SET estado ='"+ cliente.getEndereco().getEstado() 
						+ "', cidade = '" + cliente.getEndereco().getCidade() 
						+ "', rua ='" + cliente.getEndereco().getRua() + "', cep = '" + cliente.getEndereco().getCep()
						+ "', nascimento ='" + cliente.getNascimento() + "', nome ='" 
						+ cliente.getNome()+ "', cpf ='" + cliente.getCpf() + "', telefone ='" + cliente.getTelefone() 
						+ "' WHERE id = '" + cliente.getId() + "'");
				
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
		JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
	}
	
	public Cliente procurarCliente (int id) throws RepositorioException, TamanhoException {
		Cliente cliente = null; 
		Endereco endereco = null;
		
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM cliente WHERE id ='"+ id + "'");
			if (resultset.next()){
				cliente = new Cliente();
				endereco = new Endereco();
				
				cliente.setId(resultset.getInt("id"));
				cliente.setCpf(resultset.getString("cpf"));
				endereco.setCep(resultset.getString("cep"));
				endereco.setCidade(resultset.getString("cidade"));
				endereco.setEstado(resultset.getString("estado"));
				endereco.setRua(resultset.getString("rua"));
				cliente.setEndereco(endereco);
				cliente.setNascimento(resultset.getString("nascimento"));
				cliente.setNome(resultset.getString("nome"));
				cliente.setTelefone(resultset.getString("telefone"));
			}
			resultset.close();

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
		
		return cliente;
	}

	public RepositorioClienteArray todosClientes() throws TamanhoException {
		
		RepositorioClienteArray clientes = new RepositorioClienteArray();
		try {
			Statement statement;
			ResultSet resultset;
			statement = (Statement) pm.getCommunicationChannel();
			resultset = statement.executeQuery("SELECT * FROM cliente ");
			
			while (resultset.next()){
				Cliente cliente = new Cliente();
				Endereco endereco = new Endereco();
				
				cliente.setId(resultset.getInt("id"));
				cliente.setCpf(resultset.getString("cpf"));
				endereco.setCep(resultset.getString("cep"));
				endereco.setCidade(resultset.getString("cidade"));
				endereco.setEstado(resultset.getString("estado"));
				endereco.setRua(resultset.getString("rua"));
				cliente.setEndereco(endereco);
				cliente.setNascimento(resultset.getString("nascimento"));
				cliente.setNome(resultset.getString("nome"));
				cliente.setTelefone(resultset.getString("telefone"));
				
				try {//insere em clientes todos os clientes
					clientes.inserir(cliente);
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
		return clientes;
	}
	
}
