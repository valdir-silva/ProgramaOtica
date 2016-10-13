package repositorios;

import programa.Fornecedor;

public class RepositorioFornecedor implements IRepositorioFornecedor {
	private Fornecedor[] fornecedor;
	private int indice;
	
	public RepositorioFornecedor () {
		fornecedor = new Fornecedor[100];
	}
	
	public void inserirFornecedor (Fornecedor fornecedor) {
		this.fornecedor[indice] = fornecedor;
		indice++;
	}
	
	public void removerFornecedor (int id) {
		boolean found = false;
		for (int i = 0;i < this.fornecedor.length;i++){
			if (this.fornecedor[i].getId() == id){
				this.fornecedor[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (found) {
			System.out.println("Fornecedor removido com sucesso!!");
		}else {//throw FornecedorNotFound;
			System.out.println("Fornecedor nao encontrado!!");
		}
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
