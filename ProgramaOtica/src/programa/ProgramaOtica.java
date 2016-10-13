package programa;

import javax.swing.JOptionPane;

public class ProgramaOtica {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean run = true;
		EntradaDeDados dados = new EntradaDeDados();//carregar os dados
		IRepositorioCliente guarda = new RepositorioClienteArray();
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
							Cliente temp1 = new Cliente();
							temp1.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							temp1.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
							temp1.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							temp1.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							temp1.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
							temp1.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
							temp1.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
							temp1.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
							guarda.inserirCliente(temp1);
							break;
						case 2://atualizar
							Cliente temp2 = new Cliente();
							temp2.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							temp2.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
							temp2.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							temp2.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							temp2.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
							temp2.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
							temp2.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
							temp2.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
							guarda.atualizarCliente(temp2);
							break;
						case 3://remover (testar se funciona sem o temp3 já que o metodo é void)
							Cliente temp3 = new Cliente();
							int deletaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							guarda.removerCliente(deletaC);
							break;
						case 4://procurar
							Cliente temp4 = new Cliente();
							int buscaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							temp4 = guarda.procurarCliente(buscaC);
							System.out.printf("nome: %s\nnascimento: %s\ncpf: %s\ntelefone: %s\ncep: %s\nestado: %s\ncidade: %s\nrua: %s\n", 
									temp4.getNome(),temp4.getNascimento(),temp4.getCpf(),temp4.getTelefone(),temp4.getCep(),temp4.getEstado(),temp4.getCidade(),temp4.getRua());
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
