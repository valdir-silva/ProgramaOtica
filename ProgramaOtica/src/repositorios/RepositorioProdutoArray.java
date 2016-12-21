package repositorios;

import base.Produto;


import exceptions.SemPosicaoParaInserirException;

public class RepositorioProdutoArray {
	private Produto[] produto;
	private int indice;
	
	public RepositorioProdutoArray () {
		this.produto = new Produto[100];
	}
	
	public void inserir (Produto produto) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.produto[indice] == null){//se a posição esta vaga coloque
			this.produto[indice] = produto;
			found = true;
			indice++;			
		}else {//se não estiver procure em todas as posições do array se tem posisao livre
			for (int i = 0; i < this.produto.length; i++){
				if (this.produto[i] == null){
					this.produto[indice] = produto;
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
	
	public void removerProduto (int id) {
		boolean found = false;
		for (int i = 0;i < this.produto.length;i++) {
			if (this.produto[i].getId() == id) {
				this.produto[i] = null;
				found = true;
				indice--;
				break;
			}
		}
		if (!found) {//se não removeu!!
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public void atualizar (Produto produto) throws NullPointerException {
		boolean found = false;
		for (int i = 0;i < this.produto.length;i++) {
			if (this.produto[i].getId() == produto.getId()) {
				this.produto[i] = produto;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public Produto procurarProduto (int id) throws NullPointerException{
		for (int i = 0;i < this.produto.length;i++) {
			if (this.produto[i].getId() == id) {
				return this.produto[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}

	public String[][] todosProdutos() {
		int i = 0;
		String[][] produtos = new String [produto.length][9];
		
		while (produto[i] != null){
			
			produtos[i][0] = Integer.toString(produto[i].getId());
			produtos[i][1] = produto[i].getNome();
			produtos[i][2] = produto[i].getMarca();
			produtos[i][3] = Float.toString(produto[i].getValorCompra());
			produtos[i][4] = Float.toString(produto[i].getValorVenda());
			
			i++;
		}
		return produtos;
	}
}
