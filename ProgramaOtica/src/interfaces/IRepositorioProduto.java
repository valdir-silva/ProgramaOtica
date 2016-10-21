package interfaces;

import base.Produto;

public interface IRepositorioProduto {
	public void inserirProduto (Produto produto);
	public boolean removerProduto (int id);
	public void atualizarProduto (Produto produto);
	public Produto procurarProduto (int id);
}
