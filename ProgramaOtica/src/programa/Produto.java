package programa;

import javax.swing.JOptionPane;

public class Produto {
	int codigo;
	String nome, aux, marca;
	float valorCompra, valorVenda;
	
	public void cadastrar() { 
		
		nome = JOptionPane.showInputDialog("Digite o nome do produto");
		marca = JOptionPane.showInputDialog("Digite a marca do produto");
		aux = JOptionPane.showInputDialog("Digite o id do produto");
		codigo = Integer.parseInt(aux);
		aux = JOptionPane.showInputDialog("Digite o preco de compra do produto");
		valorCompra = Float.parseFloat(aux);
		aux = JOptionPane.showInputDialog("Digite o preco de venda do produto");
		valorVenda = Float.parseFloat(aux);
		JOptionPane.showMessageDialog(null, "Produto cadastrado:\n" + nome + "\n" + codigo);
	}
}
