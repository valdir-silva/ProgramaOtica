package programa;

public class ControleClientes {
	private IRepositorioCliente clientes;
	
	public ControleClientes (IRepositorioCliente clientes) {
		this.clientes = clientes;
	}
	
	public void inserirCliente (Cliente cliente) {
		if (cliente != null) {
			this.clientes.inserirCliente(cliente);
		} else {
			System.out.println("Este não é um cliente válido!!");
		}
	}
	
	public void atualizarCliente (Cliente cliente) {
		if (cliente != null) {
			this.clientes.inserirCliente(cliente);
		} else {
			System.out.println("Este não é um cliente válido!!");
		}
	}
	
	public Cliente procurarCliente (int id) throws NULLException {
		if (this.clientes.procurarCliente(id) != null) {
			System.out.println("Show Cliente");
		} else {
			System.out.println("Cliente não foi encontrado");
		}
		return null;
		
	}
	
	public void removerCliente (int id) {
		this.clientes.removerCliente(id);
			System.out.println("Cliente removido com sucesso!!");
	}
	
	
}
