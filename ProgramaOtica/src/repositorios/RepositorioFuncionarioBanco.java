package repositorios;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import base.Funcionario;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
import exceptions.TamanhoException;
import interfaces.IRepositorioFuncionario;
import exceptions.RepositorioException;

public class RepositorioFuncionarioBanco implements IRepositorioFuncionario {
	private static RepositorioFuncionarioBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioFuncionarioBanco() {
		try {
			pm = PersistenceMechanismRDBMS.getInstance();//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioFuncionarioBanco getInstance() {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioFuncionarioBanco();
		}
		return instance;
	}
	
	public void inserir (Funcionario funcionario) throws RepositorioException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("INSERT INTO funcionario (nome, cpf, telefone)"
					+ "VALUES ('" + funcionario.getNome()+ "', '" + funcionario.getCpf()
					+ "', '" + funcionario.getTelefone()+ "')");
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
	
	public void removerFuncionario (int id) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("DELETE from funcionario WHERE id = '" + id + "'");
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
	
	public void atualizar (Funcionario funcionario) throws RepositorioException {
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			statement.executeUpdate("UPDATE funcionario SET  nome ='" + funcionario.getNome()
			+ "', cpf ='" + funcionario.getCpf() + "', telefone ='" + funcionario.getTelefone() 
					+ "' WHERE id = '" + funcionario.getId() + "'");
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
	
	public Funcionario procurarFuncionario (int id) throws RepositorioException, TamanhoException {
		Funcionario funcionario = null; 
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM funcionario WHERE id ='"+ id + "'");
			if (resultset.next()){
				funcionario = new Funcionario();
				
				funcionario.setCpf(resultset.getString("cpf"));
				funcionario.setNome(resultset.getString("nome"));
				funcionario.setTelefone(resultset.getString("telefone"));
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
		
		return funcionario;
	}
	
}
