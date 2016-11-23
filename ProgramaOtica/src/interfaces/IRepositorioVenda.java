package interfaces;

import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;

public interface IRepositorioVenda {
	public void inserir (Venda venda) throws SemPosicaoParaInserirException;
	public void removerVenda (int id) throws RemocaoNaoConcluidaException;
	public void atualizar (Venda venda) throws NullPointerException;
	public Venda procurarVenda (int id) throws NullPointerException;
}
