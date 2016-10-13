package programa;

import javax.swing.JOptionPane;

public class ProgramaOtica {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;
		boolean run = true;
		while (run){
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1. Cadastrar Produto\n 2. Cadastrar Fornecedor\n 3. Cadastrar Cliente\n 4. Comprar\n 5. Acompanhar\n 0. Encerrar Programa"));
			switch (opcao) {
				case 0:
					JOptionPane.showMessageDialog(null, "Programa encerrado\n    BYE");
					run = false;
					break;
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
					break;
			}
		}
	}

}
