package repositorios;

import base.ItemVenda;

import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public class RepositorioItemVendaArray {
	private ItemVenda[] venda;
	private int indice;
	
	public RepositorioItemVendaArray () {
		this.venda = new ItemVenda[100];
	}
	
	public void inserir (ItemVenda venda) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.venda[indice] == null){//se a posição esta vaga coloque
			this.venda[indice] = venda;
			found = true;
			indice++;	
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.venda.length; i++){
				if (this.venda[i] == null){
					this.venda[indice] = venda;
					found = true;
					indice++;
					break;
				}
			}
		}
		if (!found) {// se nao inserio
			SemPosicaoParaInserirException e = new SemPosicaoParaInserirException();
			throw e;
		}
	}
	
	public void removerItemVenda (int id) {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == id) {
				this.venda[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (!found) {//se não removeu!!
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public void atualizar (ItemVenda venda) throws NullPointerException {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == venda.getId()) {
				this.venda[i] = venda;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public ItemVenda procurarItemVenda (int id) throws NullPointerException {
		for (int i = 0; i < this.venda.length; i++){
			if(this.venda[i].getId() == id) {
				return this.venda[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}
	
	public String[][] todosItensVenda() throws TamanhoException {
		int i = 0;
		String[][] vendas = new String [venda.length][9];
		
		while (venda[i] != null){
			
			vendas[i][0] = Integer.toString(venda[i].getId());
			vendas[i][1] = Integer.toString(venda[i].getIdVenda());
			vendas[i][2] = Integer.toString(venda[i].getIdProduto());
			vendas[i][3] = Integer.toString(venda[i].getQuantidade());
			
			i++;
		}
		return vendas;
	}	
}
