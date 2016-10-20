package programa;

public class RepositorioFornecedorArray implements IRepositorioFornecedor {
	private Fornecedor[] fornecedor;
	private int indice;
	
	public RepositorioFornecedorArray () {
		fornecedor = new Fornecedor[100];
	}
	
	public void inserirFornecedor (Fornecedor fornecedor) {
		if (this.fornecedor[indice] == null){//se a posição esta vaga coloque
			this.fornecedor[indice] = fornecedor;
			indice++;			
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.fornecedor.length; i++){
				if (this.fornecedor[i] == null){
					this.fornecedor[indice] = fornecedor;
					indice++;
					break;
				}
			}
		}
	}
	
	public boolean removerFornecedor (int id) {
		boolean found = false;
		for (int i = 0;i < this.fornecedor.length;i++){
			if (this.fornecedor[i].getId() == id){
				this.fornecedor[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		//if (found) {
		//	System.out.println("Fornecedor removido com sucesso!!");
		//}else {//throw FornecedorNotFound;
		//	System.out.println("Fornecedor nao encontrado!!");
		//}
		return found;
	}
	
	public void atualizarFornecedor (Fornecedor fornecedor) {
		boolean found = false;
		for (int i = 0;i < this.fornecedor.length;i++){
			if (this.fornecedor[i].getId() == fornecedor.getId()){
				this.fornecedor[i] = fornecedor;
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Fornecedor atualizado com sucesso!!");
		}else {//throw FornecedorNotFound;
			System.out.println("Fornecedor nao encontrado!!");
		}
	}
	
	public Fornecedor procurarFornecedor (int id) {
		for (int i = 0; i < this.fornecedor.length; i++){
			if(this.fornecedor[i].getId() == id) {
				return this.fornecedor[i];
			}
		}
		return null;//null se n existir esse fornecedor
	}
}
