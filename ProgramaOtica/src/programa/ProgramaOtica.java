package programa;

import javax.swing.JOptionPane;

public class ProgramaOtica {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean run = true;
		EntradaDeDados dados = new EntradaDeDados();//carregar os dados
		while (run){
			int opcao;
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1. Cliente\n 2. Fornecedor\n 3. Produto\n 4. Venda\n 0. Encerrar Programa"));
			switch (opcao) {
				case 0:
					JOptionPane.showMessageDialog(null, "Programa encerrado\n    BYE");
					run = false;
					break;
				case 1://Cliente
					int opcaoCliente;
					opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog("    CLIENTE\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch (opcaoCliente){
						case 0://voltar menu
							break;
						case 1://inserir
							
							break;
						case 2://atualizar
							
							break;
						case 3://remover
							break;
						case 4://procurar
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 2://Fornecedor
					int opcaoFornecedor;
					break;
				case 3://Produto
					int opcaoProduto;
					break;
				case 4://Venda
					int opcaoVenda;
					break;
				default:
					JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
					break;
			}
		}
	}

}
