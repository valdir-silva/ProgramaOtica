package repositorios;

import programa.Venda;

public interface IRepositorioVenda {
	public void inserirVenda (Venda venda);
	public void removerVenda (int id);
	public void atualizarVenda (Venda venda);
	public Venda procurarVenda (int id);

}
