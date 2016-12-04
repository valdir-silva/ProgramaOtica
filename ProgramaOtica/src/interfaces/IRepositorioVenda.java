package interfaces;

import base.Venda;

import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public interface IRepositorioVenda {
	public void inserir (Venda venda) throws SemPosicaoParaInserirException, RepositorioException, NullPointerException, TamanhoException;
	public void removerVenda (int id) throws RepositorioException;
	public void atualizar (Venda venda) throws NullPointerException, RepositorioException, TamanhoException;
	public Venda procurarVenda (int id) throws NullPointerException, RepositorioException, TamanhoException;
}
