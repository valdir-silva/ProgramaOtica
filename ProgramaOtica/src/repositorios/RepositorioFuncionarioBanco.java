package repositorios;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Funcionario;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.IdNaoExisteException;
import exceptions.PersistenceMechanismException;
import exceptions.TamanhoException;
import interfaceGrafica.JInicio;
import interfaces.IRepositorioFuncionario;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;

public class RepositorioFuncionarioBanco implements IRepositorioFuncionario {
	private static RepositorioFuncionarioBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	private JInicio instanceInicio = new JInicio();
	
	private RepositorioFuncionarioBanco(String server, String user, String key) {
		try {
			pm = instanceInicio.getMinhaInstancia(server, user, key);//instancia a conexão
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioFuncionarioBanco getInstance(String server, String user, String key) {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioFuncionarioBanco(server, user, key);
		}
		return instance;
	}
	
	public void inserir (Funcionario funcionario) throws RepositorioException, RepositorioJaExisteException {
		//Statement é usado para utilizar os comandos sql no java
		try {
			if (procurarFuncionario(funcionario.getId()) == null){
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO funcionario (nome, cpf, telefone)"
						+ "VALUES ('" + funcionario.getNome()+ "', '" + funcionario.getCpf()
						+ "', '" + funcionario.getTelefone()+ "')");
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
		} catch (IdNaoExisteException e) {
			e.printStackTrace();
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso");
	}
	
	public void removerFuncionario (int id) throws RepositorioException {
		try {
			if(procurarFuncionario(id) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from funcionario WHERE id = '" + id + "'");				
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
		JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
	}
	
	public void atualizar (Funcionario funcionario) throws RepositorioException {
		try {
			if (procurarFuncionario(funcionario.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("UPDATE funcionario SET  nome ='" + funcionario.getNome()
				+ "', cpf ='" + funcionario.getCpf() + "', telefone ='" + funcionario.getTelefone() 
						+ "' WHERE id = '" + funcionario.getId() + "'");
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
		JOptionPane.showMessageDialog(null, "funcionario atualizado com sucesso");
	}
	
	public Funcionario procurarFuncionario (int id) throws RepositorioException, TamanhoException, IdNaoExisteException {
		Funcionario funcionario = null; 
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM funcionario WHERE id ='"+ id + "'");
			if (resultset.next()){
				funcionario = new Funcionario();
				
				funcionario.setId(resultset.getInt("id"));
				funcionario.setCpf(resultset.getString("cpf"));
				funcionario.setNome(resultset.getString("nome"));
				funcionario.setTelefone(resultset.getString("telefone"));
			}
			resultset.close();
			
			if(funcionario != null)
				return funcionario;
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
	
	public RepositorioFuncionarioArray todosFuncionarios() throws TamanhoException {
		RepositorioFuncionarioArray funcionarios = null;
		try {
			Statement statement;
			ResultSet resultset;
			statement = (Statement) pm.getCommunicationChannel();
			resultset = statement.executeQuery("SELECT * FROM funcionario ");
			
			while (resultset.next()){
				funcionarios = new RepositorioFuncionarioArray();
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(resultset.getInt("id"));
				funcionario.setNome(resultset.getString("nome"));  
				funcionario.setTelefone(resultset.getString("telefone"));
				funcionario.setCpf(resultset.getString("cpf"));
				
				try {
					funcionarios.inserir(funcionario);
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
		return funcionarios;
	}
	
}
