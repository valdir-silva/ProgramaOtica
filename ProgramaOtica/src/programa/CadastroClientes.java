package programa;

public class CadastroClientes implements IRepositorioCliente{
	IRepositorioCliente repositorioCliente;
	Cliente cliente;
	
	public CadastroClientes (IRepositorioCliente repositorioCliente) {
		this.repositorioCliente = repositorioCliente;
	}
	
	public void inserirCliente (Cliente cliente) {
		repositorioCliente.inserirCliente(cliente);
	}
	
	public void removerCliente (int id) {
		repositorioCliente.removerCliente(id);
	}
	
	public void atualizarCliente (Cliente cliente) {
		repositorioCliente.atualizarCliente(cliente);
	}
	
	public Cliente procurarCliente (int id) {
		return repositorioCliente.procurarCliente(id);
	}
}
