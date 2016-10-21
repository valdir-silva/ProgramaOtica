package programa;

public class RepositorioFuncionario implements IRepositorioFuncionario {
	private Funcionario[] funcionario;
	private int indice;
	
	public RepositorioFuncionario () {
		funcionario = new Funcionario[100];
	}
			
	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		if (this.funcionario[indice] == null){//se a posição esta vaga coloque
			this.funcionario[indice] = funcionario;
			funcionario.setId(indice);
			indice++;
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.funcionario.length; i++){
				if (this.funcionario[i] == null){
					this.funcionario[indice] = funcionario;
					indice++;
					break;
				}
			}
		}
	}

	@Override
	public boolean removerFuncionario(int id) {
		boolean found = false;
		for (int i = 0;i < this.funcionario.length;i++){
			if (this.funcionario[i].getId() == id){
				this.funcionario[i] = null;
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

	@Override
	public void atualizarFuncionario(Funcionario funcionario) {
		boolean found = false;
		for (int i = 0;i < this.funcionario.length;i++){
			if (this.funcionario[i].getId() == funcionario.getId()){
				this.funcionario[i] = funcionario;
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

	@Override
	public Funcionario procurarFuncionario(int id) {
		for (int i = 0; i < this.funcionario.length; i++){
			if(this.funcionario[i].getId() == id) {
				return this.funcionario[i];
			}
		}
		return null;//null se n existir esse fornecedor
	}
}
