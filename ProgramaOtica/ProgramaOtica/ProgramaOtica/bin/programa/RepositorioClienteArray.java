package programa;

public class RepositorioClienteArray implements IRepositorioCliente {
	private Cliente[] cliente;
	private int indice;
	
	public RepositorioClienteArray () {
		cliente = new Cliente[100];
	}
	
	public void inserirCliente (Cliente cliente) {
		this.cliente[indice] = cliente;
		indice++;
	}
	
	public void removerCliente (int id) {
		boolean found = false;
		for (int i = 0; i < this.cliente.length; i++){
			if (this.cliente[i].getId() == id) {
				this.cliente[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Cliente removido com sucesso!!");
		}else {//throw ClienteNotFound;
			System.out.println("Cliente nao encontrado!!");
		}
	}
	
	public void atualizarCliente (Cliente cliente) {
		boolean found = false;
		for (int i = 0; i < this.cliente.length; i++){
			if (this.cliente[i].getId() == cliente.getId()) {
				this.cliente[i] = cliente;
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Cliente removido com sucesso!!");
		}else {//throw ClienteNotFound;
			System.out.println("Cliente nao encontrado!!");
		}
	}
	
	public Cliente procurarCliente (int id) {
		for (int i = 0; i < this.cliente.length; i++){
			if(this.cliente[i].getId() == id) {
				return this.cliente[i];
			}
		}
		return null;//null se n existir esse cliente
	}
}
