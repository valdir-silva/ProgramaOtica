package base;

public class Venda extends Identificacao {
	private int IdCliente;
	private float total;
	private String data;
	private ItemVenda[] vendas = new ItemVenda[10];
	
	public Venda() {
		super();
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setId(int id) {
		super.setId(id);
	}

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public ItemVenda[] getVendas() {
		return vendas;
	}

	public void setVendas(ItemVenda[] vendas) {
		this.vendas = vendas;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
