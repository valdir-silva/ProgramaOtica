package programa;

public interface IRepositorioCliente {
	public void inserirCliente (Cliente cliente);
	public void removerCliente (int id);
	public void atualizarCliente (Cliente cliente);
	public Cliente procurarCliente (int id);
}
