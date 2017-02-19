package programa;

import java.awt.HeadlessException;



import javax.swing.JOptionPane;

import base.Cliente;
import base.Endereco;
import base.Funcionario;
import base.ItemVenda;
import base.Produto;
import base.Venda;
import exceptions.IdNaoExisteException;
import exceptions.QuantidadeProdutoInvalidaException;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;
import exceptions.SemPosicaoParaInserirException;
import exceptions.TamanhoException;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioFuncionarioArray;
import repositorios.RepositorioItemVendaArray;
import repositorios.RepositorioProdutoArray;
import repositorios.RepositorioVendaArray;

public class ProgramaOtica {
	public static void main(String[] args) throws TamanhoException, NullPointerException, SemPosicaoParaInserirException, RepositorioException {
		String server = "jdbc:mysql://localhost:3306/programa";
		String user = "root";
		String key = "";
//		String server = "jdbc:mysql://whiteofdark.com:3306/whiteofd_programa";
//		String user = "whiteofd_ark";
//		String key = "1!2@3#";
		
		boolean run = true;//start false to use the loggin
		Fachada fachada = Fachada.getInstance(server, user, key);
				
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
					opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog("    CLIENTE\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 5. Todos\n 0. Voltar Menu"));
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
							} catch (RepositorioJaExisteException e) {
								e.printStackTrace();
							}
							break;
						case 2://atualizar
							Cliente tempC2 = new Cliente();
							Endereco endereco2 = new Endereco();
							try{
								tempC2.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
								if (fachada.procurarCliente(tempC2.getId()) != null) {
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
								}else {
									NullPointerException e = new NullPointerException();
									throw e;
								}
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (HeadlessException e) {
								e.printStackTrace();
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							} 
							break;
						case 3://remover
							int deletaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								fachada.removerCliente(deletaC);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 4://procurar
							Cliente tempC4 = new Cliente();
							int buscaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								tempC4 = fachada.procurarCliente(buscaC);
								JOptionPane.showMessageDialog(null,"id do cliente: " + tempC4.getId() + "\nnome: " + tempC4.getNome() +"\nnascimento: " + tempC4.getNascimento() + "\ncpf: " + tempC4.getCpf() 
								+ "\ntelefone: " + tempC4.getTelefone() + "\ncep: " + tempC4.getEndereco().getCep() + "\nestado: " + tempC4.getEndereco().getEstado() 
								+ "\ncidade: " + tempC4.getEndereco().getCidade() + "\nrua: " + tempC4.getEndereco().getRua() + "\n");
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							}
							break;
						case 5://Mostrar todos
							int i = 0;
							RepositorioClienteArray clientes = new RepositorioClienteArray();
							String[][] tempC5= null;
							clientes = fachada.todosClientes();
							tempC5 = clientes.todosClientes();
							
							
							while(tempC5[i][1] != null){
								try {
									JOptionPane.showMessageDialog(null,"id do cliente: " + tempC5[i][0] + "\nnome: " + tempC5[i][1] +"\nnascimento: " 
									+ tempC5[i][2] + "\ncpf: " + tempC5[i][3] + "\ntelefone: " 
									+ tempC5[i][4] + "\ncep: " + tempC5[i][5] 
									+ "\nestado: " + tempC5[i][6] + "\ncidade: " 
									+ tempC5[i][7] + "\nrua: " + tempC5[i][8] + "\n");
									i++;
								}
								catch (NullPointerException e){
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, e);
								}
							}
							
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
					
				case 2://Funcion�rio
					int opcaoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("    FUNCIONARIO\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 5. Todos\n 0. Voltar Menu"));
					switch (opcaoFuncionario){
						case 0://voltar menu
							break;
						case 1://inserir
							try{
								Funcionario tempF1 = new Funcionario();
								tempF1.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
								tempF1.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
								tempF1.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
								fachada.inserir(tempF1);
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (SemPosicaoParaInserirException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (RepositorioJaExisteException e) {
								e.printStackTrace();
							}
							break;
						case 2://atualizar
							Funcionario tempF2 = new Funcionario();
							try {
								tempF2.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do funcionario?")));
								if (fachada.procurarFuncionario(tempF2.getId()) != null) {
									tempF2.setNome(JOptionPane.showInputDialog("Qual o seu nome?"));
									tempF2.setCpf(JOptionPane.showInputDialog("Qual o seu cpf?"));
									tempF2.setTelefone(JOptionPane.showInputDialog("Qual o seu telefone?"));
									fachada.atualizar(tempF2);
									
								}else {
									NullPointerException e = new NullPointerException();
									throw e;
								}
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (HeadlessException e) {
								e.printStackTrace();
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							}
							break;
						case 3://remover
							int deletaF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								fachada.removerFuncionario(deletaF);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 4://procurar
							Funcionario tempF4 = new Funcionario();
							int buscaF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								tempF4 = fachada.procurarFuncionario(buscaF);
								JOptionPane.showMessageDialog(null,"id do funcionario: " + tempF4.getId() + "\nnome: " + tempF4.getNome() + "\ncpf: " + tempF4.getCpf() 
								+ "\ntelefone: " + tempF4.getTelefone());
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							}
							break;
						case 5://todos
							int i = 0;
							RepositorioFuncionarioArray funcionarios = new RepositorioFuncionarioArray();
							String[][] tempF5;
							funcionarios = fachada.todosFuncionarios();
							tempF5 = funcionarios.todosFuncionarios();
							
							
							while(tempF5[i][1] != null){
								try {
									JOptionPane.showMessageDialog(null,"id do funcionario: " + tempF5[i][0] + "\nnome: " + tempF5[i][1] + "\ncpf: " 
									+ tempF5[i][2] + "\ntelefone: " + tempF5[i][3]);
									i++;
								}
								catch (NullPointerException e){
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, e);
								}
							}
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
					
				case 3://Produto
					int opcaoProduto = Integer.parseInt(JOptionPane.showInputDialog("    PRODUTO\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 5. Todos\n 0. Voltar Menu"));
					switch (opcaoProduto){
						case 0://voltar menu
							break;
						case 1://inserir
							try {
								Produto tempP1 = new Produto();
								tempP1.setNome(JOptionPane.showInputDialog("Qual o nome?"));
								tempP1.setMarca(JOptionPane.showInputDialog("Qual a marca?"));
								tempP1.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Compra?")));
								tempP1.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Venda?")));
								tempP1.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade desse produto?")));
								fachada.inserir(tempP1);
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (SemPosicaoParaInserirException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (RepositorioJaExisteException e) {
								e.printStackTrace();
							}
							break;
						case 2://atualizar
							Produto tempP2 = new Produto();
							try {
								tempP2.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do produto?")));
								if (fachada.procurarProduto(tempP2.getId()) != null) {
									tempP2.setNome(JOptionPane.showInputDialog("Qual o nome?"));
									tempP2.setMarca(JOptionPane.showInputDialog("Qual a marca?"));
									tempP2.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Compra?")));
									tempP2.setValorVenda(Float.parseFloat(JOptionPane.showInputDialog("Qual o Valor de Venda?")));
									tempP2.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade desse produto?")));
									fachada.atualizar(tempP2);									
								}else {
									NullPointerException e = new NullPointerException();
									throw e;
								}
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (HeadlessException e) {
								e.printStackTrace();
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							}
							break;
						case 3://remover
							int deletaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								fachada.removerProduto(deletaP);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 4://procurar
							Produto tempP4 = new Produto();
							int buscaP = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								tempP4 = fachada.procurarProduto(buscaP);
								JOptionPane.showMessageDialog(null,"id do produto: " + tempP4.getId() + "\nnome: " + tempP4.getNome() + "\nmarca: " + tempP4.getMarca() 
								+ "\nvalor de compra: " + tempP4.getValorCompra() + "\nvalor de venda: " + tempP4.getValorVenda() + "\n Quantidade em estoque: " + tempP4.getQuantidade());
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							}
							break;
						case 5://Mostrar Todos
							int i = 0;
							RepositorioProdutoArray produtos = new RepositorioProdutoArray();
							String[][] tempP5;
							produtos = fachada.todosProdutos();
							tempP5 = produtos.todosProdutos();
							
							
							while(tempP5[i][1] != null){
								try {
									JOptionPane.showMessageDialog(null,"id do produto: " + tempP5[i][0] + "\nnome: " + tempP5[i][1] + "\nmarca: " + tempP5[i][2] 
									+ "\nvalor de compra: " + tempP5[i][3] + "\nvalor de venda: " + tempP5[i][4] + "\n Quantidade: " + tempP5[i][5]);
									i++;
								}
								catch (NullPointerException e){
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, e);
								}
							}
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR!!\n Opcao nao confere");
							break;
					}
					break;
					/////////
					//Venda//
					/////////
				case 4:
					int opcaoVenda = Integer.parseInt(JOptionPane.showInputDialog("    VENDA\n 1. Inserir\n 2. Atualizar\n 3. Remover\n 4. Procurar\n 5. Todos\n 6. Itens da venda\n 0. Voltar Menu"));
					switch(opcaoVenda){
					case 0://voltar menu
						break;
					case 1://inserir
							try {
								int op = 1;
								int i = 0;
								Venda tempV1 = new Venda();
								ItemVenda tempIV = new ItemVenda();
								ItemVenda[] tempIV1 = new ItemVenda[10];
								
								tempV1.setIdCliente(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
								//implementar automaticamente
								tempV1.setTotal(Float.parseFloat(JOptionPane.showInputDialog("Qual o total da venda?")));
								tempV1.setData(JOptionPane.showInputDialog("Qual a data da venda?"));
								while(op == 1) {
									//implementar a inser��o do id_venda
									tempIV.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do produto a comprar?")));
									tempIV.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantos desse produto voc� deseja comprar?")));
									fachada.inserir(tempIV);
									
									tempIV1[i] = tempIV;
									i++;
									op = Integer.parseInt(JOptionPane.showInputDialog("Deseja comprar outro produto?  1. Sim\t 0. N�o"));
								}
								tempV1.setVendas(tempIV1);
								
								fachada.inserir(tempV1);
							} catch (SemPosicaoParaInserirException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (QuantidadeProdutoInvalidaException e) {
								e.printStackTrace();
							}
							break;
						case 2://atualizar
							try {
								Venda tempV2 = new Venda();
								ItemVenda tempIV = new ItemVenda();
								ItemVenda[] tempIV2 = fachada.procurarVenda(tempV2.getId()).getVendas();
								
								//procura o cliente / produto e manda para o temV2
								tempV2.setId(Integer.parseInt(JOptionPane.showInputDialog("Qual o id da venda?")));
								
								if (fachada.procurarVenda(tempV2.getId()) != null) {
									tempV2.setIdCliente(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do cliente?")));
									//implementar automaticamente
									tempV2.setTotal(Float.parseFloat(JOptionPane.showInputDialog("Qual o total da venda?")));
									tempV2.setData(JOptionPane.showInputDialog("Qual a data da venda?"));
									
									//pega todos os itens da venda
									int i = 0;
									while(fachada.procurarItemVenda(tempIV2[i].getId()) != null) {
										tempIV.setIdVenda(tempV2.getId());
										tempIV.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Qual o id do novo produto comprado?")));
										tempIV.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantos desse produto voc� deseja comprar?")));
										fachada.inserir(tempIV);
										
										tempIV2[i] = tempIV;
										i++;
									}
									tempV2.setVendas(tempIV2);
									
									fachada.atualizar(tempV2);
								}else 
									throw new IdNaoExisteException();
								
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (TamanhoException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (HeadlessException e) {
								e.printStackTrace();
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							} catch (QuantidadeProdutoInvalidaException e) {
								e.printStackTrace();
							}
							break;
						case 3://remover
							int deletaV = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
							fachada.removerVenda(deletaV);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
							break;
						case 4://procurar
							Venda tempV4 = new Venda();
							int buscaV = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
							try {
								tempV4 = fachada.procurarVenda(buscaV);
								Cliente cliente = new Cliente();
								//procura cliente pelo seu id
								cliente = fachada.procurarCliente(tempV4.getIdCliente());
								
								
								JOptionPane.showMessageDialog(null,"id da venda: " + tempV4.getId() + "\nnome Cliente: " 
								+ cliente.getNome() + "\nId Cliente:"+ cliente.getId() + "\nData da venda: " + tempV4.getData() 
								+ "\nQuantidade de produtos comprados:" + tempV4.getVendas().length);
							} catch (NullPointerException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							} catch (IdNaoExisteException e) {
								e.printStackTrace();
							}
							break;
						case 5://Mostrar Todos
							int i = 0;
							RepositorioVendaArray vendas = new RepositorioVendaArray();
							String[][] tempV5;
							vendas = fachada.todasVendas();
							tempV5 = vendas.todasVendas();
							
							
							while(tempV5[i][1] != null) {
								try {
									
									JOptionPane.showMessageDialog(null, "id da venda: " + tempV5[i][0] +"\nId Cliente: " 
									+ tempV5[i][1]  + "\nTotal da venda: " + tempV5[i][2] + "\n Data da venda: " 
									+ tempV5[i][3] );
									i++;
								}
								catch (NullPointerException e){
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, e);
								}
							}
							break;
							//////////////
							//Item Venda//
							//////////////
						case 6:
							int j = 0, idVenda;
							idVenda = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da venda!"));
							RepositorioItemVendaArray itensVenda = new RepositorioItemVendaArray();
							String[][] tempIV6;
							itensVenda = fachada.todosItensVenda(idVenda);
							tempIV6 = itensVenda.todosItensVenda();
							while(tempIV6[j][2] != null) {
								try {
									
									JOptionPane.showMessageDialog(null, "id do Item venda: " + tempIV6[j][0] +"\nId Venda: " 
									+ tempIV6[j][1] + "\n Id produto: " + tempIV6[j][2] + "\nQuantidade comprada" + tempIV6[j][3]);
									j++;
								}
								catch (NullPointerException e){
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, e);
								}
							}
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