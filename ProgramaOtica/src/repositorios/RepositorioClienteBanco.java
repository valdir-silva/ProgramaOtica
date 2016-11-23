package repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import base.Cliente;
import base.Endereco;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import interfaces.IRepositorioCliente;
import exceptions.RepositorioException;

public class RepositorioClienteBanco implements IRepositorioCliente {
	private static RepositorioClienteBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioClienteBanco() {//private pra instanciar corretamente
		try {
			pm = PersistenceMechanismRDBMS.getInstance();//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized static RepositorioClienteBanco getInstance() {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioClienteBanco();
		}
		return instance;
	}
	
	public void inserir (Cliente cliente) throws RepositorioException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("INSERT IN TO cliente (estado, cidade, rua, cep, nascimento, nome, cpf, telefone)"
					+ "VALUES ('"+ cliente.getEndereco().getEstado() + "', '" + cliente.getEndereco().getCidade() 
					+ "', '" + cliente.getEndereco().getRua() + "', '" + cliente.getEndereco().getCep()
					+ "', '" + cliente.getNascimento() + "', '" + cliente.getNome()+ "', '" + cliente.getCpf()
					+ "', '" + cliente.getTelefone()+ "')");
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
	
	public void removerCliente (int id) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("DELETE from cliente WHERE id = '" + id + "'");
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
	
	public void atualizar (Cliente cliente) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("UPDATE cliente SET estado ='"+ cliente.getEndereco().getEstado() 
					+ "', cidade = '" + cliente.getEndereco().getCidade() 
					+ "', rua ='" + cliente.getEndereco().getRua() + "', cep = '" + cliente.getEndereco().getCep()
					+ "', nascimento ='" + cliente.getNascimento() + "', nome ='" 
					+ cliente.getNome()+ "', cpf ='" + cliente.getCpf() + "', telefone ='" + cliente.getTelefone() + "'");
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
	
	public Cliente procurarCliente (int id) throws RepositorioException, TamanhoException {
		Cliente cliente = null; 
		Endereco endereco = null;
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM cliente WHERE id ='"+ id + "'");
			if (resultset.next()){
				cliente = new Cliente();
				endereco = new Endereco();
				
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
	
}
