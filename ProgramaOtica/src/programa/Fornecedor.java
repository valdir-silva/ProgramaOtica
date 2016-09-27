package programa;

import javax.swing.JOptionPane;

public class Fornecedor {
	int codigo;
	String nome, aux, cpf, rg, telefone;
	public void cadastrar(){ 
		nome = JOptionPane.showInputDialog("Digite o nome do fornecedor:");
		cpf = JOptionPane.showInputDialog("Digite seu CPF:");
		rg = JOptionPane.showInputDialog("Digite o seu RG:");
		aux = JOptionPane.showInputDialog("Digite o código do fornecedor:");
		codigo = Integer.parseInt(aux);
		telefone = JOptionPane.showInputDialog("Digite o nome do fornecedor:");
	}
}
