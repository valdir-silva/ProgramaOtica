package interfaces;

import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.RepositorioException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public interface IRepositorioVenda {
	public void inserir (Venda venda) throws SemPosicaoParaInserirException, RepositorioException;
	public void removerVenda (int id) throws RemocaoNaoConcluidaException, RepositorioException;
	public void atualizar (Venda venda) throws NullPointerException, RepositorioException;
	public Venda procurarVenda (int id) throws NullPointerException, RepositorioException, TamanhoException;
}
