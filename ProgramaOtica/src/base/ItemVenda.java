package base;

public class ItemVenda extends Identificacao {
	private int idVenda;
	private int IdProduto;
	private int quantidade;
	

	public ItemVenda() {
		super();
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setId(int id) {
		super.setId(id);
	}

	public int getIdProduto() {
		return IdProduto;
	}
	
	public void setIdProduto(int idProduto) {
		IdProduto = idProduto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
}
