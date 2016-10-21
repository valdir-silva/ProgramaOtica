package programa;

import javax.swing.JOptionPane;

import base.Cliente;
import base.Endereco;
import base.Funcionario;
import base.Produto;
import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;

public class ProgramaOtica {
	public static void main(String[] args) throws TamanhoException, NullPointerException, SemPosicaoParaInserirException, RemocaoNaoConcluidaException {
		// TODO Auto-generated method stub
		
		boolean run = true;
		Fachada instance = new Fachada();
		Fachada fachada = instance.getInstance();
		
		while (run) {
			int opcao;
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1. Cliente\n 2. Funcionario\n 3. Produto\n 4. Venda\n 0. Encerrar Programa"));
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
							Cliente tempC1 = new Cliente();
							Endereco endereco1 = new Endereco();
							try{
								tempC1.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
								tempC1.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
								tempC1.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
								tempC1.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
								endereco1.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
								endereco1.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
								endereco1.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
								endereco1.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
								tempC1.setEndereco(endereco1);
								fachada.inserir(tempC1);
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (SemPosicaoParaInserirException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 2://atualizar
							Cliente tempC2 = new Cliente();
							Endereco endereco2 = new Endereco();
							try{
								tempC2.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
								tempC2.setNascimento(JOptionPane.showInputDialog("Qual sua data de nascimento?"));
								tempC2.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
								tempC2.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
								endereco2.setCep(JOptionPane.showInputDialog("Qual o seu cep?"));
								endereco2.setEstado(JOptionPane.showInputDialog("Qual o seu estado?"));
								endereco2.setCidade(JOptionPane.showInputDialog("Qual a sua cidade?"));
								endereco2.setRua(JOptionPane.showInputDialog("Qual a sua rua?"));
								tempC2.setEndereco(endereco2);
								fachada.atualizar(tempC2);
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 3://remover
							int deletaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								fachada.removerCliente(deletaC);
							} catch (RemocaoNaoConcluidaException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 4://procurar
							Cliente tempC4 = new Cliente();
							int buscaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								tempC4 = fachada.procurarCliente(buscaC);
								JOptionPane.showMessageDialog(null, "nome: " + tempC4.getNome() +"\nnascimento: " + tempC4.getNascimento() + "\ncpf: " + tempC4.getCpf() 
								+ "\ntelefone: " + tempC4.getTelefone() + "\ncep: " + tempC4.getEndereco().getCep() + "\nestado: " + tempC4.getEndereco().getEstado() 
								+ "\ncidade: " + tempC4.getEndereco().getCidade() + "\nrua: " + tempC4.getEndereco().getRua() + "\n"); 									
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 2://Funcionário
					int opcaoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("    FUNCIONARIO\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch (opcaoFuncionario){
						case 0://voltar menu
							break;
						case 1://inserir
							Funcionario tempF1 = new Funcionario();
							tempF1.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							tempF1.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							tempF1.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							fachada.inserirFuncionario(tempF1);
							break;
						case 2://atualizar
							Funcionario tempF2 = new Funcionario();
							tempF2.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
							tempF2.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
							tempF2.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
							fachada.atualizarFuncionario(tempF2);
							break;
						case 3://remover
							int deletaF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							fachada.removerFuncionario(deletaF);
							break;
						case 4://procurar
							Funcionario tempF4 = new Funcionario();
							int buscaF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempF4 = fachada.procurarFuncionario(buscaF);
							System.out.printf("nome: %s\ncpf: %s\ntelefone: %s\n", 
									tempF4.getNome(),tempF4.getCpf(),tempF4.getTelefone());
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 3://Produto
					int opcaoProduto = Integer.parseInt(JOptionPane.showInputDialog("    PRODUTO\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch (opcaoProduto){
						case 1://inserir
							Produto tempP1 = new Produto();
							tempP1.setNome(JOptionPane.showInputDialog("Qual o nome?"));
							tempP1.setMarca(JOptionPane.showInputDialog("Qual a marca?"));
							tempP1.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Compra?")));
							tempP1.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Venda?")));
							//tempP1.fornecedor.setnome algo assim?  (sugiro id, se pegar kk)
							fachada.inserirProduto(tempP1);
							break;
						case 2://atualizar
							Produto tempP2 = new Produto();
							tempP2.setNome(JOptionPane.showInputDialog("Qual o nome?"));
							tempP2.setMarca(JOptionPane.showInputDialog("Qual a marca?"));
							tempP2.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Compra?")));
							tempP2.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Venda?")));
							// perae que vamo discutir como fazer esse fornecedor aqui (sugiro id, se pegar kk)
							fachada.atualizarProduto(tempP2);
							break;
						case 3://remover
							int deletaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							fachada.removerProduto(deletaP);
							break;
						case 4://procurar
							Produto tempP4 = new Produto();
							int buscaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempP4 = fachada.procurarProduto(buscaP);
							System.out.printf("nome: %s\nmarca: %s\nvalor de compra: %f\nvalor de venda: %f\n", 
									tempP4.getNome(),tempP4.getMarca(),tempP4.getValorCompra(),tempP4.getValorVenda());
							//daqui a pouco vemos isso de fornecedor, kk (que daqui a pouco, olha a hora)
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				case 4://Venda
					int opcaoVenda = Integer.parseInt(JOptionPane.showInputDialog("    VENDA\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 0. Voltar Menu"));
					switch(opcaoVenda){
						case 1://inserir
							Venda tempV1 = new Venda();
							tempV1.setCliente(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
							tempV1.setProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do produto?")));
							fachada.inserirVenda(tempV1);
							break;
						case 2://atualizar
							Venda tempV2 = new Venda();
							tempV2.setCliente(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
							tempV2.setProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do produto?")));
							fachada.atualizarVenda(tempV2);
							break;
						case 3://remover
							int deletaV = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							fachada.removerVenda(deletaV);
							break;
						case 4://procurar
							Venda tempV4 = new Venda();
							int buscaV = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							tempV4 = fachada.procurarVenda(buscaV);
							Cliente cliente = new Cliente();
							Produto produto = new Produto();
							cliente = tempV4.getCliente();
							produto = tempV4.getProduto();
							System.out.printf("nome Cliente: %s\nid: %d\n nome Produto: %s\n", 
									cliente.getNome(),tempV4.getId(),produto.getNome());
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
					break;
			}
		}
	}

}