package programa;

import javax.swing.JOptionPane;

public class ProgramaOtica {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;
		boolean run = true;
		String leitura;
		while (run){
			Produto lerProduto[] =  (Produto) new Produto();
			Fornecedor lerFornecedor = (Fornecedor) new Fornecedor();
			Cliente lerCliente = (Cliente) new Cliente();
			leitura = JOptionPane.showInputDialog(" 1. Cadastrar Produto\n 2. Cadastrar Fornecedor\n 3. Cadastrar Cliente\n 4. Comprar\n 5. Acompanhar\n 0. Encerrar Programa");
			opcao = Integer.parseInt(leitura);
			switch (opcao) {
				case 0:
					JOptionPane.showMessageDialog(null, "Programa encerrado\n    BYE");
					run = false;
					break;
				case 1:
					lerProduto[0].cadastrar();
					break;
				case 2:
					lerFornecedor.cadastrar();
					break;
				case 3:
					lerCliente.cadastrar();
					break;
				case 4:
					break;
				default:
					JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
					break;
			}
		}
	}

}
