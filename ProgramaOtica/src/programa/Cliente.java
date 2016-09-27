package programa;

import javax.swing.JOptionPane;

public class Cliente {
	String nome, aux, nascimento, cpf, rg;
	String estado, cidade, rua, cep, telefone;
	int numero, codigo;
	
	public void cadastrar() {
		nome = JOptionPane.showInputDialog("Digite o seu nome:");
		nascimento = JOptionPane.showInputDialog("Digite a sua data de nascimento:");
		cpf = JOptionPane.showInputDialog("Digite o seu cpf:");
		rg = JOptionPane.showInputDialog("Digite o seu rg:");
		estado = JOptionPane.showInputDialog("Digite o estado em que você mora:");
		cidade = JOptionPane.showInputDialog("Digite o cidade em que você mora:");
		rua = JOptionPane.showInputDialog("Digite a sua rua:");
		cep = JOptionPane.showInputDialog("Digite seu CEP:");
		aux = JOptionPane.showInputDialog("Digite o número da sua casa :");
		numero = Integer.parseInt(aux);
		telefone = JOptionPane.showInputDialog("Digite seu telefone:");
		codigo++;
	}
}
