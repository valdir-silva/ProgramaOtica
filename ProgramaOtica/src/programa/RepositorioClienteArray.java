package programa;

public class RepositorioClienteArray implements IRepositorioCliente {
	private Cliente[] cliente;
	private int indice;
	
	public RepositorioClienteArray () {
		cliente = new Cliente[100];
	}
	
	public void inserirCliente (Cliente cliente) {
		if (this.cliente[indice] == null){//se a posição esta vaga coloque
			this.cliente[indice] = cliente;
			indice++;			
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.cliente.length; i++){
				if (this.cliente[i] == null){
					this.cliente[indice] = cliente;
					indice++;
					break;
				}
			}
		}

	}
	//se foi removido return true se não false
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
			System.out.println("Removido");
		} else {
			System.out.println("Não removido");
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
	
	public Cliente procurarCliente (int id) throws NULLException {
		for (int i = 0; i < this.cliente.length; i++){
			if(this.cliente[i].getId() == id) {
				return this.cliente[i];
			}
		}
		NULLException e = new NULLException();
		throw e;

		
	}
}
