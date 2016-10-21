package programa;

public interface IRepositorioVenda {
	public void inserirVenda (Venda venda);
	public boolean removerVenda (int id);
	public void atualizarVenda (Venda venda);
	public Venda procurarVenda (int id);

}
