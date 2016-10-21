package programa;

public class Produto {
	private int id;
	private String nome;
	private String marca;
	private float valorCompra;
	private float valorVenda;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public float getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public float getValorVenda() {
		return valorVenda;
	}
	
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
}