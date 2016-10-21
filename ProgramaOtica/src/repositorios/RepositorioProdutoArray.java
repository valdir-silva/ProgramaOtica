package repositorios;

import base.Produto;
import interfaces.IRepositorioProduto;

public class RepositorioProdutoArray implements IRepositorioProduto{
	private Produto[] produto;
	private int indice;
	
	public RepositorioProdutoArray () {
		this.produto = new Produto[100];
	}
	
	public void inserirProduto (Produto produto) {
		if (this.produto[indice] == null){//se a posição esta vaga coloque
			this.produto[indice] = produto;
			produto.setId(indice);
			indice++;			
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.produto.length; i++){
				if (this.produto[i] == null){
					this.produto[indice] = produto;
					indice++;
					break;
				}
			}
		}
	}
	
	public boolean removerProduto (int id) {
		boolean found = false;
		for (int i = 0;i < this.produto.length;i++) {
			if (this.produto[i].getId() == id) {
				this.produto[i] = null;
				found = true;
				indice--;
				break;
			}
		}
		/*
	 	if (found) {
			System.out.println("Produto removido com sucesso!!");
		}else {//throw ProdutoNotFound;
			System.out.println("Produto nao encontrado!!");
		}*/
		return found;
	}
	public void atualizarProduto (Produto produto) {
		boolean found = false;
		for (int i = 0;i < this.produto.length;i++) {
			if (this.produto[i].getId() == produto.getId()) {
				this.produto[i] = produto;
				found = true;
			}
		}
		if (found) {
			System.out.println("Produto removido com sucesso!!");
		}else {//throw ProdutoNotFound;
			System.out.println("Produto nao encontrado!!");
		}
	}
	
	public Produto procurarProduto (int id) {
		for (int i = 0;i < this.produto.length;i++) {
			if (this.produto[i].getId() == id) {
				return this.produto[i];
			}
		}
		return null;
	}

}
